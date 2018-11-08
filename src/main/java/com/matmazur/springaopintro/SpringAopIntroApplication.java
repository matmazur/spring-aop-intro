package com.matmazur.springaopintro;

import com.matmazur.springaopintro.model.Person;
import com.matmazur.springaopintro.repository.GenericRepository;
import com.matmazur.springaopintro.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringAopIntroApplication {

    public static void main(String[] args) {


        ConfigurableApplicationContext context = SpringApplication.run(SpringAopIntroApplication.class, args);

        GenericRepository<Long, Person> repo = context.getBean(PersonRepository.class);


        Person p1 = new Person("Mike", "Czekolao", -1L);
        Person p2 = new Person("Angela", "Czekolao", 2L);
        Person p3 = new Person("Stevenson", "Czekolao", 3L);
        System.out.println("P1 VALIDATION");
        validation(p1, repo);
        System.out.println("P2 VALIDATION");
        validation(p2, repo);
        System.out.println("P3 VALIDATION");
        validation(p3, repo);


//        System.out.println(repo.getById(-1L));
        System.out.println(repo.getById(2L));

        System.out.println(repo.getById(3L));

    }

    private static void validation(Person somePerson, GenericRepository<Long, Person> repo) {

        boolean boo = true;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Person>> violations = validator.validate(somePerson);

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println(violation.getMessage());
            boo = false;
        }

        if (boo) {
            repo.add(somePerson);
        }
    }
}
