package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;

/**
 * @author JacksonTom
 * @date 2020/12/27
 * @function
 */
public interface UserDao {

    public List<User> findAll();

    public User findUserByUsernameAndPassword(String username, String password);

    public int addUser(User user);

    public int deleteUser(int id);
}
