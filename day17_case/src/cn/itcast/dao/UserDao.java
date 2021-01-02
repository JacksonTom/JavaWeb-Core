package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;

/**
 * @author JacksonTom
 * @date 2020/12/27
 * @function
 */
public interface UserDao {

    List<User> findAll();

    User findUserByUsernameAndPassword(String username, String password);

    int addUser(User user);

    int deleteUser(int id);

    User findUserById(int id);

    int updateUser(User user);

    int deleteUserByids(String[] ids);

    int findTotalCount();

    List<User> findUserByPage(int start,int rows);
}
