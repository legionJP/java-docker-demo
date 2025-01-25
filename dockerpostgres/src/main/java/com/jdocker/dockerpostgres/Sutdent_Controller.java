package com.jdocker.dockerpostgres;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sutdent_Controller{
    @Autowired
    StudentRepo repo;

    @RequestMapping("/getStudents")
    public List<Student> getStudents()
    {
        // return List.of(
        //     new Student(1,"Rsa", 22),
        //     new Student(2,"Osa", 21),
        //     new Student(3,"PAS", 23),
        //     new Student(4,"JPA", 24)

        // );
        return repo.findAll();
    }

}

