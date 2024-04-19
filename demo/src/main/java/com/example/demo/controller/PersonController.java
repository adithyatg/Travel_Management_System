package com.example.demo.controller;

import com.example.demo.model.Person;
<<<<<<< HEAD
// import com.example.demo.model.Users;
import com.example.demo.service.PersonService;
// import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpSession;

=======
import com.example.demo.service.PersonService;
>>>>>>> origin/main
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD

import java.util.List;
=======
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;


>>>>>>> origin/main

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

<<<<<<< HEAD
    // @Autowired
    // private UserService userService;


    @GetMapping("/login")
    public String renderLoginPage(){
        return "login"; 
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,@RequestParam String password,Model model){
        List<Person> persons = personService.getAllPersons();
        int i = 0;
        for (; i < persons.size(); i++) {
            if (persons.get(i).getEmail().equals(email) && persons.get(i).getPassword().equals(password)){
                model.addAttribute("userId",persons.get(i).getUserId());
                return "home";
            } 
        }
        return "login";
=======
    @GetMapping("/login")
    public String renderLoginPage(){
        return "login"; //create a login.html page, that takes (email,password) as input in a form
    }

    @PostMapping("/login")
    public String login(@PathVariable String email,@PathVariable String password){
        // implement login logic here
        return "home"; // create a home.html page and render it only if the login is a success
>>>>>>> origin/main
    }

    @GetMapping("/signup")
    public String renderSignupPage(){
        return "signup"; //create a signup.html page, that takes (email,password,name,phone_number,address) as input in a form
    }

    @PostMapping("/signup")
<<<<<<< HEAD
    public String signup(@RequestParam String email, @RequestParam String password,
                        @RequestParam String name, @RequestParam int phoneNumber,
                        @RequestParam String address,Model model) {
        List<Person> persons = personService.getAllPersons();
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getEmail().equals(email)) return "signup";
            if (persons.get(i).getName().equals(name)) return "signup";
        }

        Person p = new Person();
        p.setName(name);
        p.setAddress(address);
        p.setEmail(email);
        p.setPassword(password);  

        Person savedPerson = personService.savePerson(p);
        model.addAttribute("userId",savedPerson.getUserId());

        return "home";
    }


    @PostMapping("/profile")
    public String getPersonById(@RequestParam int userId,Model model) {
        // int userId = (int) session.getAttribute("userId");
        Person user = personService.getPersonById(userId);
=======
    public String signup(@PathVariable String email,@PathVariable String password
    ,@PathVariable String name,@PathVariable int phone_number,@PathVariable String address){
        // implement signup logic here
        return "home"; // create a home.html page and render it only if the signup is a success
    }

    @GetMapping("/profile/{id}")
    public String getPersonById(@PathVariable int id, Model model) {
        Person user = personService.getPersonById(id);
>>>>>>> origin/main
        model.addAttribute("user", user);
        return "profile"; // This will render profile.html template
    }

<<<<<<< HEAD
    @GetMapping("/home")
    public String Home(Model model){
        // System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&7"+userId);
        // model.addAttribute("userId", userId);
        return "home";
    }

    @GetMapping("/logout")
    public String Logout(){
        return "logout";
    }

=======
    @DeleteMapping("/deletePerson/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable int id) {
        // Implement delete logic here
        personService.deletePerson(id);
        return ResponseEntity.ok("Person deleted successfully");
    }
    
>>>>>>> origin/main

}
