package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import java.util.List;

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
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
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


}
