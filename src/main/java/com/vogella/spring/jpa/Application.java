package com.vogella.spring.jpa;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.vogella.spring.jpa.repository.TodoRepository;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner jpaSample(TodoRepository todoRepo) {
        return (args) -> {

            todoRepo.save(new Todo("Testando"));

            Todo todo = new Todo("Detalhe do Teste");
            todo.setDueDate(new Date());
            todo.setDescription("Detalhe da descrição");
            todoRepo.save(todo);

            //todoRepo.findAll().forEach(System.out::println);
            //todoRepo.readBySummaryOrDescription("Testesss", "Testandosss").close();
            //todoRepo.getTodosOf2016().forEach(System.out::println);
      
        };
    }
}
