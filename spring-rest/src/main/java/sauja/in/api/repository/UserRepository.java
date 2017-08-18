package sauja.in.api.repository;

import sauja.in.api.entities.Users;

import java.util.List;
public interface UserRepository {
    public List<Users> findAll();
    public Users getUser(String id);
    public boolean findEmail(String email);
    public void deleteUser(String id);
    public void modifyUser(String id, Users users);
    public void createUser(Users users);
}
