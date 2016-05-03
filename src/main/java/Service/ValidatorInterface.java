/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Airplane;
import Model.Airport;
import Model.Route;
import Validator.InvalidAttributeException;

/**
 *
 * @author M
 */
public interface ValidatorInterface {
    
    void validateAirplane(Airplane airplane) throws InvalidAttributeException;
    
    void validateAirport(Airport airport) throws InvalidAttributeException;
    
    void validateRoute(Route route) throws InvalidAttributeException;
    
}
