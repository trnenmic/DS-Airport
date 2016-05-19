package Tests;

import Service.ManagementProvider;

/**
 *
 * @author M
 */
public class TestPerformance {

    public static void main(String[] args) {
        TestPerformance testPerformance = new TestPerformance();
        System.out.println();
        System.out.println();
        testPerformance.test1();
        testPerformance.test2();
        testPerformance.testConcreteAirport();
        testPerformance.testFindAll();
        testPerformance.test1();
        testPerformance.testConcreteAirportIataIcao();
        System.out.println();
        System.out.println();
    }

    public void test1() {
        ManagementProvider mgProvider = new ManagementProvider();
        Long start1 = System.nanoTime();
        Object[] list2 = mgProvider.getAirportManager().findSpecified(null, "New York", "USA", null, null).toArray();
        Long end1 = System.nanoTime();
        Long start2 = System.nanoTime();
        Object[] list1 = mgProvider.getAirportManager().findSpecifiedAlternate(null, "New York", "USA", null, null).toArray();
        Long end2 = System.nanoTime();
        double resultMs1 = ((double) (end1 - start1) / 1000000);
        double resultMs2 = ((double) (end2 - start2) / 1000000);
        
        System.out.println("=================================================================");
        System.out.println("Test - find all airports in New York, USA (there are none):");
        System.out.println();
        System.out.println("JPA Criteria - time: " + resultMs1 + "\t; Number of found results: " + list1.length + "\t;");
        System.out.println(" Typed Query - time: " + resultMs2 + "\t; Number of found results: " + list2.length + "\t;");
        System.out.println("=================================================================");

    }

    public void test2() {
        ManagementProvider mgProvider = new ManagementProvider();
        Long start1 = System.nanoTime();
        Object[] list2 = mgProvider.getAirportManager().findSpecified(null, null, "China", null, null).toArray();
        Long end1 = System.nanoTime();
        Long start2 = System.nanoTime();
        Object[] list1 = mgProvider.getAirportManager().findSpecifiedAlternate(null, null, "China", null, null).toArray();
        Long end2 = System.nanoTime();
        double resultMs1 = ((double) (end1 - start1) / 1000000);
        double resultMs2 = ((double) (end2 - start2) / 1000000);
        System.out.println("=================================================================");
        System.out.println("Test - find all airports in China (one not null argument):");
        System.out.println();
        System.out.println("JPA Criteria - time: " + resultMs1 + "\t; Number of found results: " + list1.length + "\t;");
        System.out.println(" Typed Query - time: " + resultMs2 + "\t; Number of found results: " + list2.length + "\t;");
        System.out.println("=================================================================");

    }

    public void testConcreteAirport() {
        ManagementProvider mgProvider = new ManagementProvider();
        Long start1 = System.nanoTime();
        Object[] list2 = mgProvider.getAirportManager().findSpecified("Ed Pacocha Airport", "Alangalang", "Philippines", "TXVA", "XRK").toArray();
        Long end1 = System.nanoTime();
        Long start2 = System.nanoTime();
        Object[] list1 = mgProvider.getAirportManager().findSpecifiedAlternate(null, "Alangalang", "Philippines", "TXVA", "XRK").toArray();
        Long end2 = System.nanoTime();
        double resultMs1 = ((double) (end1 - start1) / 1000000);
        double resultMs2 = ((double) (end2 - start2) / 1000000);

        System.out.println("=================================================================");
        System.out.println("Test - find one aiport by using all arguments:");
        System.out.println();
        System.out.println("JPA Criteria - time: " + resultMs1 + "\t; Number of found results: " + list1.length + "\t;");
        System.out.println(" Typed Query - time: " + resultMs2 + "\t; Number of found results: " + list2.length + "\t;");
        System.out.println("=================================================================");
    }
    

    public void testFindAll() {
        ManagementProvider mgProvider = new ManagementProvider();
        Long start1 = System.nanoTime();
        Object[] list2 = mgProvider.getAirportManager().findSpecified(null, null, null, null, null).toArray();
        Long end1 = System.nanoTime();
        Long start2 = System.nanoTime();
        Object[] list1 = mgProvider.getAirportManager().findSpecifiedAlternate(null, null, null, null, null).toArray();
        Long end2 = System.nanoTime();
        double resultMs1 = ((double) (end1 - start1) / 1000000);
        double resultMs2 = ((double) (end2 - start2) / 1000000);

        System.out.println("=================================================================");
        System.out.println("Test - find all airports (all arguments are null):");
        System.out.println();
        System.out.println("JPA Criteria - time: " + resultMs1 + "\t; Number of found results: " + list1.length + "\t;");
        System.out.println(" Typed Query - time: " + resultMs2 + "\t; Number of found results: " + list2.length + "\t;");
        System.out.println("=================================================================");
    }
    
    public void testConcreteAirportIataIcao() {
        ManagementProvider mgProvider = new ManagementProvider();
        Long start1 = System.nanoTime();
        Object[] list2 = mgProvider.getAirportManager().findSpecified(null, null, null, "JEKR", "JCZ").toArray();
        Long end1 = System.nanoTime();
        Long start2 = System.nanoTime();
        Object[] list1 = mgProvider.getAirportManager().findSpecifiedAlternate(null, null, null, "JEKR", "JCZ").toArray();
        Long end2 = System.nanoTime();
        double resultMs1 = ((double) (end1 - start1) / 1000000);
        double resultMs2 = ((double) (end2 - start2) / 1000000);

        System.out.println("=================================================================");
        System.out.println("Test - find one aiport by using IATA and ICAO codes:");
        System.out.println();
        System.out.println("JPA Criteria - time: " + resultMs1 + "\t; Number of found results: " + list1.length + "\t;");
        System.out.println(" Typed Query - time: " + resultMs2 + "\t; Number of found results: " + list2.length + "\t;");
        System.out.println("=================================================================");
    }

}
