/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Validator.InvalidAttributeException;

/**
 *
 * @author M
 */
public interface ValidatorInterface {
    
    void validateAirplane() throws InvalidAttributeException;
    
    void validateAirport() throws InvalidAttributeException;
    
    void validateRoute() throws InvalidAttributeException;
    
}
