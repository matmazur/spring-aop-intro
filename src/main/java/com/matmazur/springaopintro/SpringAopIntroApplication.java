package com.matmazur.springaopintro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringAopIntroApplication {

    public static void main(String[] args) {


        ConfigurableApplicationContext context = SpringApplication.run(SpringAopIntroApplication.class, args);


        List<String> strings = new ArrayList<>();

        System.out.println(strings.get(4));

    }
}
