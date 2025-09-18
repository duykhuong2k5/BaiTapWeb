package vn.iostar.service;

import vn.iostar.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(Integer id);
    User save(User user);
    void deleteById(Integer id);
    List<User> searchByUserName(String userName);
    User login(String username,String password);
    List<User> getAllAdmins();

}
