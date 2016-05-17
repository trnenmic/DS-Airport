/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Model.Airport;
import Service.ManagementProvider;
import java.util.List;

/**
 *
 * @author M
 */
public class TestPerformance {
    
    public static void main(String[] args) {
        TestPerformance testPerformance = new TestPerformance();
        testPerformance.start();
    }
    
    public void start(){
        ManagementProvider mgProvider = new ManagementProvider();
        Long start1 = System.nanoTime(); 
        Object[] list1 = mgProvider.getAirportManager().findSpecifiedAlternate(null,
                "New York", "USA", null, null).toArray();
        Long end1 = System.nanoTime();
        Long start2 = System.nanoTime();
        Object[] list2 = mgProvider.getAirportManager().findSpecified(null,
                "New York", "USA", null, null).toArray();
        Long end2 = System.nanoTime();
        double resultMs1 = ((double)(end1 - start1)/1000000);
        double resultMs2 = ((double)(end2 - start2)/1000000);
        System.out.println("Named Query - time: " + resultMs1 + " ; Number of found results: " +  list1.length + " ;");
        System.out.println("JPA Criteria - time: " + resultMs2 + " ; Number of found results: " +  list2.length + " ;");
    }
    
}
