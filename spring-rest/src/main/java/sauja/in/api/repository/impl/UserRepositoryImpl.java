package sauja.in.api.repository.impl;

import org.springframework.stereotype.Repository;
import sauja.in.StaticRepo;
import sauja.in.api.entities.Users;
import sauja.in.api.exception.BadRequestException;
import sauja.in.api.exception.NotFoundException;
import sauja.in.api.repository.UserRepository;

import java.util.List;
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Override
    public List<Users> findAll() {
        return StaticRepo.getUsers();
    }

    @Override
    public Users getUser(String id) {
        List<Users> users=StaticRepo.getUsers();
        for(Users u:users)
        {
            System.out.println("u:"+u.getId()+" id"+id);
            if(u.getId().equals(id))
                return u;
        }
        throw  new NotFoundException("User "+id+" not found");
    }

    @Override
    public boolean findEmail(String email) {
        List<Users> users=StaticRepo.getUsers();
        for(Users u:users)
        {
            if(u.getEmail()==email)
                return true;
        }
        return false;
    }

    @Override
    public void deleteUser(String id) {
        List<Users> users=StaticRepo.getUsers();
        for(Users u:users)
        {
            if(u.getId().equals(id))
            {
                users.remove(u);
                return;
            }
        }
        throw new NotFoundException("User Id "+id+" not found");
    }

    @Override
    public void modifyUser(String id, Users users) {
        List<Users> usersList=StaticRepo.getUsers();

        for(Users u:usersList)
        {
            if(id.equals(u.getId()))
            {
                usersList.remove(u);
                usersList.add(users);
                return;
            }
        }
        throw new NotFoundException("Id "+ users.getId()+" not found");
    }

    @Override
    public void createUser(Users users) {
        List<Users> usersList=StaticRepo.getUsers();
        if(!findEmail(users.getEmail()))
        {
            usersList.add(users);
            return;
        }
        throw new BadRequestException("User with id "+users.getId()+" already exists");
    }
}
