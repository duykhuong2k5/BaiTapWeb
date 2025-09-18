package vn.iostar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.iostar.entity.User;
import vn.iostar.repository.UserRepository;
import vn.iostar.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> searchByUserName(String userName){
        return userRepository.findByUserNameContainsIgnoreCase(userName);
    }

    @Override
    public User login(String username,String password){
        Optional<User> user = userRepository.findByUserName(username);
        if(user.isPresent() && user.get().getPassword().equals(password)){
            return user.get();
        }
        return null;
    }


    @Override
    public List<User> getAllAdmins() {
        // Truy vấn từ database lấy danh sách các admin (roleid = 1)
        return userRepository.findByRoleid(1);
    }

}
