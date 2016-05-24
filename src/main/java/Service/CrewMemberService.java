package Service;

import Data.GenericDAOImpl;
import Model.CrewMember;
import Validator.InvalidAttributeException;
import java.util.List;
import javax.persistence.criteria.Root;

/**
 *
 * @author Martin Cap
 */
public class CrewMemberService extends GenericServiceImpl<CrewMember> implements CrewMemberManager {

    private Root<CrewMember> root;

    private final GenericDAOImpl<CrewMember> crewMemberDAO = new GenericDAOImpl<>();

    @Override
    public CrewMember createCrewMember(CrewMember crewMember) throws InvalidAttributeException {
        // validation
        checkConstraints(crewMember);
        return crewMemberDAO.createTx(crewMember);
    }

    @Override
    public CrewMember updateCrewMember(CrewMember crewMember) throws InvalidAttributeException {
        // validation
        checkConstraints(crewMember);
        return crewMemberDAO.updateTx(crewMember);
    }

    private void checkConstraints(CrewMember crewMember) throws InvalidAttributeException {
        List<CrewMember> allCrewMembers = findAll();
        // check unique_passport_number_client
        String tmpPassportNumber = crewMember.getPassportNumber();
        for (CrewMember c : allCrewMembers) {
            if (tmpPassportNumber.equals(c.getPassportNumber())) {
                throw new InvalidAttributeException("Passport number of the crew member must be unique!");
            }
        }
    }

    @Override
    public void deleteCrewMember(CrewMember crewMember) throws InvalidAttributeException {
        crewMemberDAO.delete(crewMember);
    }

    @Override
    public CrewMember find(int idCrewMember) {
        return em.find(CrewMember.class, idCrewMember);
    }

    @Override
    public List<CrewMember> findAll() {
        refresh();
        createResultList();
        return getCastedResult();
    }

    public void refresh() {
        criteriaQuery = criteriaBuilder.createQuery();
        root = criteriaQuery.from(CrewMember.class);
    }
}
