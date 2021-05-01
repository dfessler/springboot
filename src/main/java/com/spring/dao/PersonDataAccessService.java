package com.spring.dao;

import com.spring.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao
{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> allPerson()
    {
        String sql = "Select * from person";
        return jdbcTemplate.query(sql, (resultSet, i) ->
        {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String firstname = resultSet.getString("firstname");
            String lastname = resultSet.getString("lastname");
            return new Person(id, firstname, lastname);
        } );

    }

    @Override
    public Optional<Person> selectPerson(UUID id) {
        String sql ="Select * from person where id = ?";

        Person person = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) ->
        {
            UUID personId = UUID.fromString(resultSet.getString("id"));
            String firstname = resultSet.getString("firstname");
            String lastname = resultSet.getString("lastname");
            return new Person(personId, firstname, lastname);
        } );

        return Optional.ofNullable(person);
    }

    @Override
    public int deletePerson(UUID id) {
        return 0;
    }

    @Override
    public int updatePerson(UUID id, Person person) {
        return 0;
    }
}
