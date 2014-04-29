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
public abstract class User {
    private String fName;
    private String lName;
    private String address;
    private String locality;
    private String state;
    private String email;
    private String username;
    private String password;
    private long phonenumber;
    private long ccNumber;
    
    User(){
        this.fName = "";
        this.lName = "";
        this.address = "";
        this.locality = "";
        this.state = "";
        this.email = "";
        this.username = "";
        this.password = "";
        this.phonenumber = 999999999;
        this.ccNumber = 1111111111;
    }
    
    User(String firstname, String lastname, String address, String locality, 
            String state, String email, String username, String password, long phonenumber, long ccNumber){
        this.setfName(firstname);
        this.setlName(lastname);
        this.setAddress(address);
        this.setLocality(locality);
        this.setState(state);
        this.setEmail(email);
        this.setUsername(username);
        this.setPassword(password);
        this.setPhonenumber(phonenumber);
        this.setCcNumber(ccNumber);
    }

    /**
     * @return the fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * @param fName the fName to set
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * @return the lName
     */
    public String getlName() {
        return lName;
    }

    /**
     * @param lName the lName to set
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the phonenumber
     */
    public long getPhonenumber() {
        return phonenumber;
    }

    /**
     * @param phonenumber the phonenumber to set
     */
    public void setPhonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }

    /**
     * @return the locality
     */
    public String getLocality() {
        return locality;
    }

    /**
     * @param locality the locality to set
     */
    public void setLocality(String locality) {
        this.locality = locality;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }
    
    abstract void reserve(MovieStoreItem msi, Customer c);

    /**
     * @return the ccNumber
     */
    public long getCcNumber() {
        return ccNumber;
    }

    /**
     * @param ccNumber the ccNumber to set
     */
    public void setCcNumber(long ccNumber) {
        this.ccNumber = ccNumber;
    }
    
}
