package com.sda.mirceapopa.hibernate;

import com.sda.mirceapopa.hibernate.model.*;
import com.sda.mirceapopa.hibernate.repository.DepartmentRepository;
import com.sda.mirceapopa.hibernate.repository.EmployeeRepository;
import com.sda.mirceapopa.hibernate.repository.ProjectRepository;
import com.sda.mirceapopa.hibernate.utils.SessionManager;

import java.sql.Date;

public class ManyToManyMain {

    public static void main(String[] args) {


        DepartmentRepository departmentRepository = new DepartmentRepository();// creez obiect ca sa pot apela metodele

        Department department1 = new Department();
        department1.setName("Finance");
        Department department2 = new Department();
        department2.setName("HR");
        Department department3 = new Department();
        department3.setName("IT");

        departmentRepository.save(department1);// apelez metoda save, care adauga noi entitati in tabel.
        departmentRepository.save(department2);
        departmentRepository.save(department3);

        //-------------------------------------------------------------------------------------------------------

        ProjectRepository projectRepository = new ProjectRepository();

        Project project1 = new Project();
        project1.setName("Java Project");
        project1.setBudget(20000);
        project1.setCurrency("Euro");
        project1.setProjectType(ProjectType.ENTERPRISE);
        projectRepository.save(project1);

        Project project2 = new Project();
        project2.setName("Project x");
        project2.setBudget(15000);
        project2.setCurrency("Euro");
        project2.setProjectType(ProjectType.OPEN_SOURCE);
        projectRepository.save(project2);

        //--------------------------------------------------------------------------------

        EmployeeRepository employeeRepository = new EmployeeRepository();

        Employee employee1 = new Employee();
        employee1.setFirstname("Mircea");
        employee1.setLastName("Popa");
        employee1.setEmail("jgfuf@yahoo.com");
        employee1.setDateOfBirth(Date.valueOf("1987-02-03"));
        employee1.setDepartment(department1);
        employee1.setPhoneNumber("0744128986");
        employee1.setSalary(5000);
        employee1.getProjectSet().add(project1);
        employee1.getProjectSet().add(project2);

        Account account1 = new Account();
        account1.setCreationDate(Date.valueOf("1995-09-23"));

        employeeRepository.save(employee1,account1);

        //===============================

        Employee employee2 = new Employee();
        employee2.setFirstname("Vasile");
        employee2.setLastName("Vasilescu");
        employee2.setEmail("jgfuf@yahoo.com");
        employee2.setDateOfBirth(Date.valueOf("1950-02-03"));
        employee2.setDepartment(department2);
        employee2.setPhoneNumber("0744654548");
        employee2.setSalary(12000);
        employee2.getProjectSet().add(project1);

        Account account2 = new Account();
        account2.setCreationDate(Date.valueOf("1997-11-12"));

        employeeRepository.save(employee2,account2);

        //===================================

        Employee employee3 = new Employee();
        employee3.setFirstname("Ion");
        employee3.setLastName("Popescu");
        employee3.setEmail("jgfuf@yahoo.com");
        employee3.setDateOfBirth(Date.valueOf("1987-02-03"));
        employee3.setDepartment(department1);
        employee3.setPhoneNumber("0744128986");
        employee3.setSalary(5000);
        employee3.getProjectSet().add(project1);
        employee3.getProjectSet().add(project2);

        Account account3 = new Account();
        account3.setCreationDate(Date.valueOf("2021-06-30"));

        employeeRepository.save(employee3,account3);

        //-----------------------------------------------------------------------------------------------

        // 1.Display all projects:
        System.out.println("1.Display all projects:\n----------------------------------------------------------");

        projectRepository.displayAllProjects().forEach(System.out::println);

        // 2.Display all employees:
        System.out.println("2.Display all employees:\n----------------------------------------------------------");

        employeeRepository.displayAllEmployees().forEach(System.out::println);

        // 3. Display all employees with names starting with the letter J.
        System.out.println("3. Display all employees with names starting with the letter J:\n----------------------------------------------------------");

        employeeRepository.displayAllEmployeesWithLetter("V").forEach(System.out::println);

        // 4. Display all employees working in the Finance department.
        System.out.println("4. Display all employees working in the Finance department:\n----------------------------------------------------------");

        employeeRepository.findAllEmployeesFromDepartment("Finance").forEach(System.out::println);

        // 5. Display all employees alphabetically:
        System.out.println("5. Display all employees alphabetically:\n----------------------------------------------------------");

        employeeRepository.displayAllEmployeesAlphabetically().forEach(System.out::println);
        SessionManager.shutDown();

    }


}
