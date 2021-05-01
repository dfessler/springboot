package com.spring.api;

import com.spring.dao.PersonDao;
import com.spring.model.Person;
import com.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController
{
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService)
    {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Valid @NonNull @RequestBody Person person)
    {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> allPerson()
    {
        return personService.allPerson();
    }

    @GetMapping(path = "/{id}")
    public Optional<Person> selectPerson(@PathVariable("id") UUID id)
    {
        return personService.selectPerson(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePerson(@PathVariable("id") UUID id)
    {
        personService.deletePerson(id);
    }

    @PutMapping(path = "/{id}")
    public void updatePerson(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person updatePerson)
    {
        personService.updatePerson(id, updatePerson);
    }
}
