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
        super(firstname, lastname, address, locality, state, email, username, password, phonenumber);
        
    }

    @Override
    void reserve(MovieStoreItem msi, Customer c) {
        c.getReservedList().add(msi);
    }

    void rent(MovieStoreItem msi, Customer c){
        c.getRentedList().add(msi);
    }
    
    Customer registerUser(String firstname, String lastname, String address, String locality,
            String state, String email, String username, String password, long phonenumber){
        return new Customer(firstname, lastname, address, locality, state, email, username, password, phonenumber);
    }
}
