package cn.itcast.dao.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author JacksonTom
 * @date 2020/12/27
 * @function
 */
public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<>(User.class));
        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        String sql = "select * from user where username = ? and password = ?";
        User user = null;
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int addUser(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        int insert = template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
        return insert;
    }

    @Override
    public int deleteUser(int id) {
        String sql = "delete from user where id = ?";
        int update = template.update(sql, id);
        return update;
    }

    @Override
    public User findUserById(int id) {
        String sql = "select * from user where id = ?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return user;
    }

    @Override
    public int updateUser(User user) {
        String sql = "update user set name = ?,gender = ?,age = ?,address = ?,qq = ?,email = ? where id = ?";
        int update = template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
        return update;
    }

    @Override
    public int deleteUserByids(String[] ids) {
        StringBuilder builder = new StringBuilder();
        builder.append("delete from user where id in (");
        for (int i = 0; i < ids.length; i++) {
            builder.append(ids[i]);
            if (i < ids.length - 1) {
                builder.append(",");
            }
        }
        builder.append(")");
        int update = template.update(builder.toString());
        return update;
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        String sql = "select count(1) from user where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        List<Object> params = new ArrayList<Object>();
        //遍历集合
        Set<String> keySet = condition.keySet();
        for (String key : keySet) {
            if ("name".equals(key) || "address".equals(key) || "email".equals(key)) {
                String value = condition.get(key)[0];
                if (null != value && !"".equals(value)) {
                    sb.append(" and " + key + " like ? ");
                    params.add("%" + value + "%");//条件的值
                }
            }
        }
        System.out.println(sb);
        System.out.println(params);
        Integer totalCount = template.queryForObject(sb.toString(), Integer.class, params.toArray());
        return totalCount;
    }

    @Override
    public List<User> findUserByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from user where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        List<Object> params = new ArrayList<Object>();
        //遍历集合
        Set<String> keySet = condition.keySet();
        for (String key : keySet) {
            if ("name".equals(key) || "address".equals(key) || "email".equals(key)) {
                String value = condition.get(key)[0];
                if (null != value && !"".equals(value)) {
                    sb.append(" and " + key + " like ? ");
                    params.add("%" + value + "%");//条件的值
                }
            }
        }
        sb.append(" order by id limit ?,?");
        params.add(start);
        params.add(rows);
        System.out.println(sb);
        System.out.println(params);
        List<User> userList = template.query(sb.toString(), new BeanPropertyRowMapper<User>(User.class), params.toArray());
        return userList;
    }

}
