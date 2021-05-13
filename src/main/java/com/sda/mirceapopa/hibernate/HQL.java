package com.sda.mirceapopa.hibernate;

import com.sda.mirceapopa.hibernate.model.Account;
import com.sda.mirceapopa.hibernate.model.Department;
import com.sda.mirceapopa.hibernate.model.Employee;
import com.sda.mirceapopa.hibernate.repository.DepartmentRepository;
import com.sda.mirceapopa.hibernate.repository.EmployeeRepository;

import java.sql.Date;

public class HQL {

    public static void main(String[] args) {

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

        //---------------------------------------------------------------

        EmployeeRepository employeeRepository = new EmployeeRepository();

        Employee employee1 = new Employee();
        employee1.setFirstname("Mircea");
        employee1.setLastName("Popa");
        employee1.setEmail("jgfuf@yahoo.com");
        employee1.setDateOfBirth(Date.valueOf("1987-02-03"));
        employee1.setDepartment(department1);
        employee1.setPhoneNumber("0744128986");
        employee1.setSalary(5000);


        Account account1 = new Account();
        account1.setCreationDate(Date.valueOf("1995-09-23"));

        employeeRepository.save(employee1,account1);

        employeeRepository.findAllEmployeesFromDepartment("Marcheting").forEach(employee -> System.out.println(employee));



    }

}
