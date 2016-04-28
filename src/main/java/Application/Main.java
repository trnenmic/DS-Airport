package Application;

import Model.Airplane;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by M on 27. 4. 2016.
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();


        /*Airplane airplane = Airplane.createAirplane(50, 25, "AIRLINE", 5, 10, "CODE_123");

        tx.begin();
        em.persist(airplane);
        tx.commit();*/

        Airplane airplane = em.find(Airplane.class, 101);
        System.out.println(airplane);
        
        System.out.println("Testing Netbeans connection!");

        System.out.println("Testing IDEA connection!");


//finding by ID
        //Airplane booka = em.find(Airplane.class, 1);
        //System.out.println("Finding book> "+booka);
    }
}
