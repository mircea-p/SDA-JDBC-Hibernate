package com.sda.mirceapopa.hibernate;

import com.sda.mirceapopa.hibernate.model.Account;
import com.sda.mirceapopa.hibernate.model.Department;
import com.sda.mirceapopa.hibernate.model.Employee;
import com.sda.mirceapopa.hibernate.repository.DepartmentRepository;
import com.sda.mirceapopa.hibernate.repository.EmployeeRepository;
import com.sda.mirceapopa.hibernate.utils.SessionManager;

import java.sql.Date;

public class NoRelationsMain {

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

        departmentRepository.delete(department);
        department = departmentRepository.findById(1);
        System.out.println(department);  // rezultatul va fi null pt ca am sters inainte

        //---------------------------------------------------------------------------------------------------------------------

        SessionManager.shutDown(); // sterge baza de date si opreste hibernat-ul, si toate procesele lui.

    }
}
