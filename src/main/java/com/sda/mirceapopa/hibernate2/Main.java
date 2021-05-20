package com.sda.mirceapopa.hibernate2;

import com.sda.mirceapopa.hibernate2.model.*;
import com.sda.mirceapopa.hibernate2.repository.ClassroomRepository;
import com.sda.mirceapopa.hibernate2.repository.ModuleRepository;
import com.sda.mirceapopa.hibernate2.repository.TeamRepository;
import com.sda.mirceapopa.hibernate2.repository.PersonRepository;
import com.sda.mirceapopa.hibernate2.utils.SessionManager;

import java.sql.Date;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {



        TeamRepository teamRepository = new TeamRepository();

        Team team1 = new Team();
        team1.setTeamName("Python1Tallin");
        Team team2 = new Team();
        team2.setTeamName("JavaRemoteRo2020");

        teamRepository.save(team1);
        teamRepository.save(team2);

        PersonRepository personRepository= new PersonRepository();

        Person person1 = new Person();
        person1.setFirstName("Mircea");
        person1.setLastname("Popa");
        person1.setEmail("mircea@jsdghfjh.com");
        person1.setDateOfBirth(Date.valueOf("1987-02-03"));
        person1.setIsTrainer(IsTrainer.YES);
        person1.setTeam(team2);
        personRepository.save(person1);

        Person person2 = new Person();
        person2.setFirstName("Andrei");
        person2.setLastname("Gavris");
        person2.setEmail("andrei@jsdghfjh.com");
        person2.setDateOfBirth(Date.valueOf("1987-05-28"));
        person2.setIsTrainer(IsTrainer.NO);
        person2.setTeam(team1);
        personRepository.save(person2);

        //--------------------------------------------------------------

        ClassroomRepository classroomRepository = new ClassroomRepository();
        Classroom classroom1 = new Classroom();
        classroom1.setName("Sala Mihai Eminescu");
        classroom1.setAdress("BucharestCowork");
        classroomRepository.save(classroom1);

        Classroom classroom2 = new Classroom();
        classroom2.setName("Sala Stefan Cel Mare");
        classroom2.setAdress("Tallin Cozy Space");
        classroomRepository.save(classroom2);

        ModuleRepository moduleRepository = new ModuleRepository();
        Module module1 = new Module();
        module1.setStartDate(Date.valueOf("2021-05-25"));
        module1.setEndDate(Date.valueOf("2021-11-12"));
        moduleRepository.save(module1,classroom1);

        Module module2 = new Module();
        module2.setStartDate(Date.valueOf("2020-01-25"));
        module2.setEndDate(Date.valueOf("2020-08-12"));
        moduleRepository.save(module2,classroom2);

        Team team3 = new Team();
        team3.setTeamName("JavaScript team");
        team3.getModuleList().add(module1);
        teamRepository.save(team3);

        team1.getModuleList().add(module2);



        // 1. List all students.
        System.out.println("1. List all students.\n---------------------------------------------------------");

        personRepository.displayAllStudents().forEach(System.out::println);

        //2. List all students for team Python1Tallin.
        System.out.println("2. List all students for team Python1Tallin.\n---------------------------------------------------------");

        personRepository.listAllStudentsForATeam("Python1Tallin").forEach(System.out::println);

        //3. List all groups that had classes in location BucharestCowork.
        System.out.println("3. List all groups that had classes in location BucharestCowork.\n---------------------------------------------------------");

        teamRepository.listAllClasesInLocation("BucharestCowork").forEach(System.out::println);

        //4. List all groups that had classes in location Tallin Cozy Space in March 2020.
        System.out.println("4. List all groups that had classes in location Tallin Cozy Space in March 2020.\n---------------------------------------------------------");

        teamRepository.listAllClasesInLocationAndDate("Tallin Cozy Space", Date.valueOf("2020-03-01"),Date.valueOf("2020-03-30")).forEach(System.out::println);

        SessionManager.shutDown();

    }
}
