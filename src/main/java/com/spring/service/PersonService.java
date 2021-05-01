package com.spring.service;

import com.spring.dao.PersonDao;
import com.spring.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService
{
    private PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("postgres")  PersonDao personDao)
    {
        this.personDao = personDao;
    }

    public int addPerson(Person person)
    {
        return personDao.addPerson(person);
    }

    public List<Person> allPerson()
    {
        return personDao.allPerson();
    }

    public Optional<Person> selectPerson(UUID id)
    {
        return personDao.selectPerson(id);
    }

    public int deletePerson(UUID id)
    {
        return personDao.deletePerson(id);
    }

    public int updatePerson(UUID id, Person person)
    {
        return personDao.updatePerson(id, person);
    }
}
