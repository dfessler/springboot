package com.spring.dao;

import com.spring.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao
{
    int insertPerson(UUID id, Person person);

    default int addPerson(Person person)
    {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> allPerson();

    Optional<Person> selectPerson(UUID id);

    int deletePerson(UUID id);

    int updatePerson(UUID id, Person person);
}
