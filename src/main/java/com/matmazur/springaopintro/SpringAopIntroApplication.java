package com.matmazur.springaopintro;

import com.matmazur.springaopintro.model.Person;
import com.matmazur.springaopintro.repository.GenericRepository;
import com.matmazur.springaopintro.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@EnableAspectJAutoProxy(proxyTargetClass = true)
@SpringBootApplication
public class SpringAopIntroApplication {

    public static void main(String[] args) {


        ConfigurableApplicationContext context = SpringApplication.run(SpringAopIntroApplication.class, args);

//        GenericRepository<Long, Person> repo = context.getBean(GenericRepository.class);

        PersonRepository repo = context.getBean(PersonRepository.class);


        Person p1 = new Person("Mike", "Czekolao", 1L);
        Person p2 = new Person("Angela", "Czekolao", 2L);
        Person p3 = new Person("Stevenson", "Czekolao", 3L);
        System.out.println("P1 VALIDATION");
        validation(p1, repo);
        System.out.println("\n\nP2 VALIDATION");
        validation(p2, repo);
        System.out.println("\n\nP3 VALIDATION");
        validation(p3, repo);

//        repo.add(null);
        System.out.println("\n\n");
        repo.getById(1L);
        repo.getById(2L);
        repo.getById(3L);

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
