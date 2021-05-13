package com.sda.mirceapopa.hibernate;

import com.sda.mirceapopa.hibernate.model.Account;
import com.sda.mirceapopa.hibernate.model.Department;
import com.sda.mirceapopa.hibernate.model.Employee;
import com.sda.mirceapopa.hibernate.repository.DepartmentRepository;
import com.sda.mirceapopa.hibernate.repository.EmployeeRepository;
import com.sda.mirceapopa.hibernate.utils.SessionManager;

import java.sql.Date;

public class OneToOneMain {

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

        Department department = departmentRepository.findById(1);  // atribui rezultatul metodei unei variabile de tip (Obiect)
        System.out.println(department);

        department.setName("HR-department");
        departmentRepository.update(department); // modific instanta din tabel si ii pun nume nou.


        System.out.println(departmentRepository.findById(1));
        System.out.println(departmentRepository.findById(2));

//        departmentRepository.delete(department);
//        department = departmentRepository.findById(1);
//        System.out.println(department);  // rezultatul va fi null pt ca am sters inainte

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

        // One to one relation
        Account account1 = new Account();
        account1.setCreationDate(Date.valueOf("1995-09-23"));
        Account account2 = new Account();
        account2.setCreationDate(Date.valueOf("1997-11-12"));

        employeeRepository.save(employee1,account1);
        employeeRepository.save(employee2,account2);

        System.out.println(employeeRepository.findById(1));
        System.out.println(employeeRepository.findById(2));


        SessionManager.shutDown(); // sterge baza de date si opreste hibernat-ul, si toate procesele lui.

    }
}
