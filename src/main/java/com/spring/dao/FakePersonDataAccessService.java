package com.spring.dao;

import com.spring.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao
{
    private static List<Person> db = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person)
    {
        db.add(new Person(id, person.getFirstName(), person.getLastName()));
        return 1;
    }

    @Override
    public List<Person> allPerson()
    {
        return db;
    }

    @Override
    public Optional<Person> selectPerson(UUID id)
    {
        return db.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePerson(UUID id)
    {
        Optional<Person> personMaybe = selectPerson(id);
        if (personMaybe.isEmpty())
        {
            return 0;
        }
        db.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePerson(UUID id, Person person)
    {
        return selectPerson(id)
                .map(p -> {
                    int indexOfPersonToUpdate = db.indexOf(p);
                    if (indexOfPersonToUpdate >=0){
                        db.set(indexOfPersonToUpdate, new Person(id, person.getFirstName(), person.getLastName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }


}
