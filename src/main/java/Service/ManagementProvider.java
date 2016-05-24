package Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author M
 */
public class ManagementProvider {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
    
    private AirplaneManager airplaneManager = new AirplaneService();
    private AirportManager airportManager = new AirportService();
    private RouteManager routeManager = new RouteService();
    
    private ClientManager clientManager = new ClientService();
    private CrewMemberManager crewMemberManager = new CrewMemberService();
    
    private RelationService relationService;

    public ManagementProvider() {
        this.relationService = new RelationService(airplaneManager, airportManager, routeManager);
    }

    public RelationService getRelationService() {
        return relationService;
    }

    public void setRelationService(RelationService relationService) {
        this.relationService = relationService;
    }

    public AirplaneManager getAirplaneManager() {
        return airplaneManager;
    }

    public void setAirplaneManager(AirplaneManager airplaneManager) {
        this.airplaneManager = airplaneManager;
    }

    public AirportManager getAirportManager() {
        return airportManager;
    }

    public void setAirportManager(AirportManager airportManager) {
        this.airportManager = airportManager;
    }

    public RouteManager getRouteManager() {
        return routeManager;
    }

    public void setRouteManager(RouteManager routeManager) {
        this.routeManager = routeManager;
    }

    public EntityManager getEm() {
        return em;
    }

    public EntityTransaction getTx() {
        return tx;
    }

    public ClientManager getClientManager() {
        return clientManager;
    }

    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    public CrewMemberManager getCrewMemberManager() {
        return crewMemberManager;
    }

    public void setCrewMemberManager(CrewMemberManager crewMemberManager) {
        this.crewMemberManager = crewMemberManager;
    }

}
