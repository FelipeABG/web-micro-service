package service;

import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserService {

    private EntityManager em;

    public UserService(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        this.em = emf.createEntityManager();
    }

    public void addNewUser(User user){
        this.em.getTransaction().begin();
        this.em.persist(user);
        this.em.getTransaction().commit();
    }

    public User getUserById(Long id){
        this.em.getTransaction().begin();
        User user = this.em.find(User.class, id);
        this.em.getTransaction().commit();
        return user;
    }

    public void deleteUser(Long id) {
        this.em.getTransaction().begin();
        this.em.remove(em.find(User.class, id));
        this.em.getTransaction().commit();
    }

    public void updateUser(User user){
        this.em.getTransaction().begin();
        this.em.merge(user);
        this.em.getTransaction().commit();
    }

}
