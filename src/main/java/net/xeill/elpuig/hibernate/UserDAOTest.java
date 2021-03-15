package net.xeill.elpuig.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserDAOTest {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        User existingUser = new User();
        existingUser.setId(1);
        existingUser.setEmail("johndoe@elpuig.xeill.net");
        existingUser.setFullname("John Doe");
        existingUser.setPassword("johndoe");
        entityManager.merge(existingUser);

        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();
    }
}