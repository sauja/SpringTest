package sauja.in.api.service;

import sauja.in.api.entities.Users;

import java.util.List;
public interface UserService {
    public List<Users> findAll();
    public Users getUser(String id);
    public void deleteUser(String id);
    public void modifyUser(String id, Users users);
    public void createUser(Users users);
}
