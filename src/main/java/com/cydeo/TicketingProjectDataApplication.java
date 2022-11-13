package com.cydeo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication // this annotation include @configuration also so we can create bean here
public class TicketingProjectDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketingProjectDataApplication.class, args);

        }

        @Bean
        public ModelMapper mapper(){
            return new ModelMapper();
    }


}
// whenever we use third party clas  we need to create a bean we can create confing class and use @ Configuration
// annotation and create the method we can do that in runner class since @SpringBootApplication also includes @Configuration