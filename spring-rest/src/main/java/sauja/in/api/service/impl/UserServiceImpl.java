package sauja.in.api.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sauja.in.api.entities.Users;
import sauja.in.api.exception.BadRequestException;
import sauja.in.api.exception.NotFoundException;
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
    @Transactional(readOnly = true)
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Users getUser(String id) {
        Users users=userRepository.findById(id);
        if(users==null)
            throw new NotFoundException("User with id "+users.getId()+" not found");
        return users;
    }



    @Override
    @Transactional(readOnly = true)
    public Users findByEmail(String email) {
        Users users=userRepository.findByEmail(email);
        if(users==null)
            throw new NotFoundException("User with email "+email+" not found");
        return users;
    }

    @Override
    @Transactional
    public void deleteUser(String id) {
        Users users=userRepository.findById(id);
        if(users==null)
            throw new NotFoundException("User with id "+users.getId()+" not found");
        userRepository.deleteUser(id);
    }

    @Override
    @Transactional
    public void modifyUser(String id, Users users) {
        Users u=userRepository.findById(id);
        if(u==null)
            throw new NotFoundException("User with id "+users.getId()+" not found");
        userRepository.modifyUser(id, users);
    }

    @Override
    @Transactional
    public void createUser(Users users) {
        if(userRepository.findByEmail(users.getEmail())==null)
        {
            userRepository.createUser(users);
            return;
        }
        throw new BadRequestException("User with email "+users.getEmail()+" already exists");
    }
}
