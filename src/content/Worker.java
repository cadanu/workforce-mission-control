/*
 * WorkForce: Mission Control
 */
package content;

import java.security.SecureRandom;

/**
 *
 * @author G.D. Joyce
 * Worker.java: holds worker resources for JavaFX application ' WorkForce: Mission control '
 */

public class Worker {
    // constants
    public enum Constants {
        WFID;
    }
    // random number generator for security pin
    private SecureRandom rnd = new SecureRandom();
    private int rand = rnd.nextInt(9999);
    
    //private final String prefix = "WFID";
    private String id;
    private int accessPin;// security login for punch-in app
    private String name;
    private String lastname;
    private String streetAddress;
    private String city;
    private double rate;
    private double hours;
    
    private double overtime = hours - 40;// overtime hours
    // (hours * rate (including overtime)) + (overtime hours * balance of rate (0.5))
    private double paidThisPeriod = (hours * rate) + (overtime * (rate * 0.5));
    //private String emergencyContact;
    
    // total number of objects
    private Integer allWorkers = 100;
    
    // makes a unique id based on constant prefix and number of total employees
    private String makeId() {
        int allWorkersUpdate = getAllWorkers() + 1;        
        
        String cat = Constants.WFID + Integer.toString(allWorkersUpdate);
        allWorkers += 1;
        return cat;
    }
    
    // constructor
    public Worker() {
        this.id = makeId();
        this.accessPin = rand;
    }    

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the accessPin
     */
    public int getAccessPin() {
        return accessPin;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the streetAddress
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * @param streetAddress the streetAddress to set
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the hours
     */
    public double getHours() {
        return hours;
    }

    /**
     * @param hours the hours to set
     */
    public void setHours(double hours) {
        this.hours = hours;
    }

    /**
     * @return the rate
     */
    public double getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

    /**
     * @return the paidLastPeriod
     */
    public double getPaidLastPeriod() {
        return paidThisPeriod;
    }

    /**
     * @param paidLastPeriod the paidLastPeriod to set
     */
    public void setPaidLastPeriod(double paidLastPeriod) {
        this.paidThisPeriod = paidLastPeriod;
    }

    /**
     * @return the emergencyContact
     */
    /*
    public String getEmergencyContact() {
        return emergencyContact;
    }*/
    
    /**
     * @param emergencyContact the emergencyContact to set
     */
    /*
    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }*/

    /**
     * @return the allWorkers
     */
    public Integer getAllWorkers() {//////////
        return allWorkers;
    }

    /**
     * @return the lastname
     */
    public String getLastName() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastName(String lastname) {
        this.lastname = lastname;
    }  

    /**
     * @return the overtime
     */
    public double getOvertime() {
        return overtime;
    }

    /**
     * @param overtime the overtime to set
     */
    public void setOvertime(double overtime) {
        this.overtime = overtime;
    }
}// end Worker class
