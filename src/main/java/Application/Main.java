package Application;

import Data.*;
import Model.Airplane;
import Model.Airport;
import Model.Route;
import Service.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by M on 27. 4. 2016.
 */
public class Main {
    public static void main(String[] args) {
//        Frame frame = new Frame();
//        NewJFrame visualTest = new NewJFrame();
        
        AirplaneService airplaneService = new AirplaneService();
        
        System.out.println("All airplanes, not sorted:");
        for (Airplane airplane : airplaneService.findAll()) {
            System.out.println(airplane);
        }
        System.out.println();
        System.out.println("All airplanes, sorted by id (ascending):");
        for (Airplane airplane : airplaneService.findAllOrderedById()) {
            System.out.println(airplane);
        }
        
        
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//
//        Airplane airplane = em.find(Airplane.class, 101);
//        System.out.println(airplane);
//
//
//        Airport airport = em.find(Airport.class, 301);
//        System.out.println(airport);
//
//        Route route = em.find(Route.class, 401);
//        System.out.println(route);
//
//
//        Object[]airplanes = route.getAirplanes().toArray();
//        System.out.println((Airplane) airplanes[0]);
//        Object[]routes = airplane.getRoutes().toArray();
//        System.out.println((Route) routes[0]);
//        
//        testAirplaneDAO();
        
    }
    
    public static void testAirplaneDAO() {
        AirplaneDAO airplaneDAO = new AirplaneDAO();
        System.out.println(airplaneDAO.find(451).getAirline());
    }
    
    public static void testGenericDAO() {
        
        GenericDAO dao = new GenericDAOImpl();
        
        Airplane a1 = Airplane.createAirplane(200, 50, "CSA", 500, 1000, "OK1");
        Airplane a2 = Airplane.createAirplane(200, 50, "CSA", 500, 1000, "OK2");
        
        dao.create(a1);
        dao.create(a2);
        
        a1.setAirline("Lufthansa");
//        
        dao.update(a1);
                
    }

    public static Airplane insertAirplane(EntityTransaction tx, EntityManager em){
        // ID = 101
        Airplane airplane = Airplane.createAirplane(50, 25, "AIRLINE", 5, 10, "CODE_123");
        tx.begin();
        em.persist(airplane);
        tx.commit();
        return airplane;
    }

    public static Route insertRoute(EntityTransaction tx, EntityManager em, Airport destination, Airport origin){
        //ID = 401
        Route route = Route.createRoute();
        route.setDestination(destination);
        route.setOrigin(origin);
        tx.begin();
        em.persist(route);
        tx.commit();
        return route;
    }

    public static Airport insertAirport(EntityTransaction tx, EntityManager em){
        //ID = 301
        Airport airport = Airport.createAirport("London", "Heathrow", "ICAO", "IAT", "Great Britain");
        tx.begin();
        em.persist(airport);
        tx.commit();
        return airport;
    }

    public static void connectAirplaneToRoute(EntityTransaction tx, EntityManager em, Airplane airplane, Route route){
        tx.begin();
        airplane.getRoutes().add(route);
        route.getAirplanes().add(airplane);
        em.merge(airplane);
        em.merge(route);
        tx.commit();
    }
}
