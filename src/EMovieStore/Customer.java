/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EMovieStore;

import java.util.ArrayList;

/**
 *
 * @author mark4689
 */
public class Customer extends User {
    private ArrayList<MovieStoreItem> rentedList,reservedList;
    private CreditCard cc;
    
    public Customer(){
        super();
        rentedList = new ArrayList();
        reservedList = new ArrayList();
        cc = new CreditCard();
    }
    
    public Customer(String firstname, String lastname, String address, String locality, 
            String state, String email, String username, String password, long phonenumber){
        super(firstname, lastname, address, locality, state, email, username, password, phonenumber);
        rentedList = new ArrayList();
        reservedList = new ArrayList();
        cc = new CreditCard();
    }

    @Override
    void reserve(MovieStoreItem msi, Customer c) {
        c = this;
        c.reservedList.add(msi);
    }

    /**
     * @return the rentedList
     */
    public ArrayList<MovieStoreItem> getRentedList() {
        return rentedList;
    }

    /**
     * @return the reservedList
     */
    public ArrayList<MovieStoreItem> getReservedList() {
        return reservedList;
    }

    /**
     * @return the cc
     */
    public CreditCard getCc() {
        return cc;
    }

    /**
     * @param cc the cc to set
     */
    public void setCc(CreditCard cc) {
        this.cc = cc;
    }
    
}
