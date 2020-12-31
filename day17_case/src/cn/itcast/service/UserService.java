package cn.itcast.service;

import cn.itcast.domain.User;
import java.util.List;

/**
 @author     JacksonTom
 @date       ${DATE}
 @function   用户管理的业务接口
 */
public interface UserService {

    /*
    * 查询所有用户信息
    * @return List<User>
    * */
    List<User> findAll();
    /*
     * 根据用户名密码查询用户
     * @return User
     * */
    User login(User user);
    /*
     * 新增用户
     * @return int
     * */
    int addUser(User user);
    /*
     * 根据id删除用户
     * @return int
     * */
    int DeleteUser(int id);
    /*
     * 根据id查询
     * @return User
     * */
    User findUserByid(int id);
    /*
     * 更新user
     * @return int
     * */
    int updateUser(User user);
}
