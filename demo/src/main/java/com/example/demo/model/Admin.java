<<<<<<< HEAD
// package com.example.demo.model;

// import jakarta.persistence.Entity;

// @Entity
// public class Admin extends Person {

//     // Additional attributes specific to Admin
//     private String adminRole;

//     // Constructors
//     public Admin() {
//         // Default constructor
//     }

//     public Admin(String username, String password, String email, String adminRole) {
//         this.adminRole = adminRole;
//     }

//     // Getter and Setter for adminRole
//     public String getAdminRole() {
//         return adminRole;
//     }


//     @Override
//     public String toString() {
//         return "Admin{" +
//                 "adminRole='" + adminRole + '\'' +
//                 "} " + super.toString();
//     }

//     public void manageUsers() {
        
//     }

//     public void addFlight(Flight flight) {
      
//     }

//     public void removeFlight(int flightId) {

//     }

//     public void modifyFlight(Flight flight) {

//     }
// }
=======
package com.example.demo.model;

import jakarta.persistence.Entity;

@Entity
public class Admin extends Users {

}
>>>>>>> origin/main
