package Service;

import Model.CrewMember;
import Validator.InvalidAttributeException;
import java.util.List;

/**
 *
 * @author Martin Cap
 */
public interface CrewMemberManager {
    
    CrewMember createCrewMember(CrewMember crewMember) throws InvalidAttributeException;
    CrewMember updateCrewMember(CrewMember crewMember) throws InvalidAttributeException;
    void deleteCrewMember(CrewMember crewMember) throws InvalidAttributeException;

    CrewMember find(int idCrewMember);
    
    List<CrewMember> findAll();
}
