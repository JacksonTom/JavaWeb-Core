package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.PageBean;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @author JacksonTom
 * @date 2020/12/27
 * @function
 */
public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public int addUser(User user) {
        return dao.addUser(user);

    }

    @Override
    public int DeleteUser(int id) {
        return dao.deleteUser(id);
    }

    @Override
    public User findUserByid(int id) {
        return dao.findUserById(id);
    }

    @Override
    public int updateUser(User user) {
        return dao.updateUser(user);
    }

    @Override
    public int deleteUserByids(String[] ids) {
        return dao.deleteUserByids(ids);
    }

    @Override
    public PageBean<User> findUserByPage(int currentPage, int rows, Map<String, String[]> condition) {
        PageBean<User> userPageBean = new PageBean<User>();
        userPageBean.setCurrentPage(currentPage);
        userPageBean.setRows(rows);
        //总记录数
        int totalCount = dao.findTotalCount(condition);
        userPageBean.setTotalCount(totalCount);
        userPageBean.setTotalPage(totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1);
        int start = (currentPage - 1) * rows;
        List<User> userByPage = dao.findUserByPage(start, rows,condition);
        userPageBean.setList(userByPage);
        return userPageBean;
    }


}
