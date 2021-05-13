package com.sda.mirceapopa.hibernate;

import com.sda.mirceapopa.hibernate.model.*;
import com.sda.mirceapopa.hibernate.repository.DepartmentRepository;
import com.sda.mirceapopa.hibernate.repository.EmployeeRepository;
import com.sda.mirceapopa.hibernate.repository.ProjectRepository;
import com.sda.mirceapopa.hibernate.utils.SessionManager;

import java.sql.Date;
import java.time.Instant;

public class OneToManyMain {

    public static void main(String[] args) {


        //Exersize on Department

        DepartmentRepository departmentRepository = new DepartmentRepository();// creez obiect ca sa pot apela metodele

        Department department1 = new Department();
        department1.setName("Marcheting");
        Department department2 = new Department();
        department2.setName("HR");
        Department department3 = new Department();
        department3.setName("IT");

        departmentRepository.save(department1);// apelez metoda save, care adauga noi entitati in tabel.
        departmentRepository.save(department2);
        departmentRepository.save(department3);


        //---------------------------------------------------------------------------------------------------------------------

        //Exersize on Employee

        EmployeeRepository employeeRepository = new EmployeeRepository();

        Employee employee1 = new Employee();
        employee1.setFirstname("Mircea");
        employee1.setLastName("Popa");
        employee1.setEmail("jgfuf@yahoo.com");
        employee1.setDateOfBirth(Date.valueOf("1987-02-03"));
        employee1.setDepartment(department1);
        employee1.setPhoneNumber("0744128986");
        employee1.setSalary(5000);

        Employee employee2 = new Employee();
        employee2.setFirstname("Vasile");
        employee2.setLastName("Vasilescu");
        employee2.setEmail("jgfuf@yahoo.com");
        employee2.setDateOfBirth(Date.valueOf("1950-02-03"));
        employee2.setDepartment(department2);
        employee2.setPhoneNumber("0744654548");
        employee2.setSalary(12000);

        Account account1 = new Account();
        account1.setCreationDate(Date.valueOf("1995-09-23"));
        Account account2 = new Account();
        account2.setCreationDate(Date.valueOf("1997-11-12"));

        employeeRepository.save(employee1,account1);
        employeeRepository.save(employee2,account2);

        System.out.println(employeeRepository.findById(1));
        System.out.println(employeeRepository.findById(2));




        employee1.setSalary(9000);
        employeeRepository.update(employee1);
        System.out.println(employeeRepository.findById(1));

        employeeRepository.delete(employee2);
        System.out.println(employeeRepository.findById(2));

        ProjectRepository projectRepository = new ProjectRepository();
        Project project1 = new Project();
        project1.setName("Java Project");
        project1.setBudget(20000);
        project1.setCurrency("Euro");
        project1.setProjectType(ProjectType.ENTERPRISE);
        projectRepository.save(project1);



       // System.out.println(projectRepository.findById(1));

        SessionManager.shutDown(); // sterge baza de date si opreste hibernat-ul, si toate procesele lui.

    }
}
