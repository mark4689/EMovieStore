/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EMovieStore;

/**
 *
 * @author mark4689
 */
public class MovieStoreItem {
    private String title;
    private double rentalRate;
    private int numCopies;
    private int numAvailable;
    private int rentalPeriod;
    private String status;
    private String classification;
    
    public MovieStoreItem(){
        this.setClassification("");
        this.setNumAvailable(0);
        this.setNumCopies(0);
        this.setRentalPeriod(7);
        this.setRentalRate(0.00);
        this.setStatus("");
        this.setTitle("");
    }
    
    public MovieStoreItem(String classification, int numAvailable, int numCopies, 
            int rentalPeriod,double rentalRate, String status, String title){
        this.setClassification(classification);
        this.setNumAvailable(numAvailable);
        this.setNumCopies(numCopies);
        this.setRentalPeriod(rentalPeriod);
        this.setRentalRate(rentalRate);
        this.setStatus(status);
        this.setTitle(title);
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the rentalRate
     */
    public double getRentalRate() {
        return rentalRate;
    }

    /**
     * @param rentalRate the rentalRate to set
     */
    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    /**
     * @return the numCopies
     */
    public int getNumCopies() {
        return numCopies;
    }

    /**
     * @param numCopies the numCopies to set
     */
    public void setNumCopies(int numCopies) {
        this.numCopies = numCopies;
    }

    /**
     * @return the numAvailable
     */
    public int getNumAvailable() {
        return numAvailable;
    }

    /**
     * @param numAvailable the numAvailable to set
     */
    public void setNumAvailable(int numAvailable) {
        this.numAvailable = numAvailable;
    }

    /**
     * @return the rentalPeriod
     */
    public int getRentalPeriod() {
        return rentalPeriod;
    }

    /**
     * @param rentalPeriod the rentalPeriod to set
     */
    public void setRentalPeriod(int rentalPeriod) {
        this.rentalPeriod = rentalPeriod;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the classification
     */
    public String getClassification() {
        return classification;
    }

    /**
     * @param classification the classification to set
     */
    public void setClassification(String classification) {
        this.classification = classification;
    }
    
}
