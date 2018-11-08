package com.matmazur.springaopintro.repository;

import com.matmazur.springaopintro.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonRepository implements GenericRepository<Long, Person> {

    private List<Person> personList;

    public PersonRepository() {
        personList = new ArrayList<>();
    }

    @Override
    public Person getById(Long id) {


        Person is = personList.stream().filter(p -> p.getId().equals(id)).findAny().orElseThrow(() -> new RuntimeException("ggaa"));


        return is;
    }

    @Override
    public void add(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("You can't add null item");
        }
        personList.add(person);
    }
}
