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
public class Admin extends User {

    public Admin() {
        super();
    }

    public Admin(String firstname, String lastname, String address, String locality,
            String state, String email, String username, String password, long phonenumber) {
        super(firstname, lastname, address, locality, state, email, username, password, phonenumber, 999999999);
    }

    @Override
    void reserve(MovieStoreItem msi, Customer c) {
        c.getReservedList().add(msi);
    }

    void updateRental() {

    }

}
