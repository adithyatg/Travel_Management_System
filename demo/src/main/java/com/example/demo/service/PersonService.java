package com.example.demo.service;

import com.example.demo.model.Person;
<<<<<<< HEAD
=======

>>>>>>> origin/main
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======

>>>>>>> origin/main
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(int id) {
        return personRepository.findById(id).orElse(null);
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }
<<<<<<< HEAD
    
    public boolean isUserAdmin(int userId) {
        Person person = getPersonById(userId);
        return person != null && person.isAdmin();
    }

=======
>>>>>>> origin/main
}
