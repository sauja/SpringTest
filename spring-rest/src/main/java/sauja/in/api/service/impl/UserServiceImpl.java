package sauja.in.api.service.impl;

import org.springframework.stereotype.Service;
import sauja.in.api.entities.Users;
import sauja.in.api.repository.UserRepository;
import sauja.in.api.service.UserService;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Users getUser(String id) {
        return userRepository.getUser(id);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteUser(id);
    }

    @Override
    public void modifyUser(String id, Users users) {
        userRepository.modifyUser(id, users);
    }

    @Override
    public void createUser(Users users) {
        userRepository.createUser(users);
    }
}
