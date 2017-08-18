package sauja.in.api.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sauja.in.StaticRepo;
import sauja.in.api.entities.Users;
import sauja.in.api.exception.BadRequestException;
import sauja.in.api.exception.NotFoundException;
import sauja.in.api.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Users> findAll() {
        TypedQuery<Users> query=entityManager.createNamedQuery("Users.findAll",Users.class);
        return query.getResultList();

    }

    @Override
    public Users getUser(String id) {
        return entityManager.find(Users.class,id);
    }

    @Override
    @Transactional(readOnly = true)
    public Users findByEmail(String email) {
        TypedQuery<Users> query=entityManager.createNamedQuery("Users.findByEmail",Users.class);
        query.setParameter("pEmail",email);
        List<Users>  usersList=query.getResultList();
        if(usersList.isEmpty())
            return null;
        return usersList.get(0);
    }

    @Override
    public Users findById(String id) {
        Users users=entityManager.find(Users.class,id);
        if(users!=null)
            return users;
        return null;
    }

    @Override
    public void deleteUser(String id) {
        entityManager.remove(getUser(id));
    }

    @Override
    public void modifyUser(String id, Users users) {
        entityManager.merge(users);
    }

    @Override
    public void createUser(Users users) {
        entityManager.persist(users);
    }
}
