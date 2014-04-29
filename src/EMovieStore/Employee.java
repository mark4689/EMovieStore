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
public class Employee extends User {

    public Employee() {
        super();
    }

    public Employee(String firstname, String lastname, String address, String locality,
            String state, String email, String username, String password, long phonenumber) {
        super(firstname, lastname, address, locality, state, email, username, password, phonenumber, 999999999);
        
    }

    @Override
    public void reserve(MovieStoreItem msi, Customer c) {
        c.getReservedList().add(msi);
    }

    public void rent(MovieStoreItem msi, Customer c){
        c.getRentedList().add(msi);
    }
    
    public User registerUser(String firstname, String lastname, String address, String locality,
            String state, String email, String username, String password, long phonenumber, long ccNumber){
        if (ccNumber == 99999999) return new Employee(firstname, lastname, address, locality, state, email, username, password, phonenumber);
        return new Customer(firstname, lastname, address, locality, state, email, username, password, phonenumber, ccNumber);
    }
}
