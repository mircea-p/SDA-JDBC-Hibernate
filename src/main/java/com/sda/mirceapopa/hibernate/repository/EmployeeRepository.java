package com.sda.mirceapopa.hibernate.repository;
import com.sda.mirceapopa.hibernate.model.Account;
import com.sda.mirceapopa.hibernate.model.Department;
import com.sda.mirceapopa.hibernate.model.Employee;
import com.sda.mirceapopa.hibernate.model.Project;
import com.sda.mirceapopa.hibernate.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeRepository {
    public Employee findById(Integer id)
    {
        Session session = SessionManager.getSessionFactory().openSession();
        //The find method returns the object with the provided id
        Employee employee = session.find(Employee.class, id);
        session.close();
        return employee;
    }
    public void save(Employee employee, Account account)
    {
        Session session= SessionManager.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        session.save(account); // am adaugat un account in tabel si se genereaza un id pt account.
        employee.setAccount(account); // setam la employee account-ul
        session.save(employee); // adaugam employee-ul in baza de date.
        transaction.commit();
        session.close();
    }

    public void delete(Employee employee){

        Session session = SessionManager.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(employee);
        transaction.commit();
        session.close();
    }

    public void update(Employee employee){

        Session session = SessionManager.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(employee);
        transaction.commit();
        session.close();

    }

    public List<Employee> findAllEmployeesFromDepartment(String departmentName){

        Session session = SessionManager.getSessionFactory().openSession();
        String hqlQuery = "FROM  Employee e where e.department.name = :departmentName";
        Query<Employee> employeeQuery = session.createQuery(hqlQuery);
        employeeQuery.setParameter("departmentName", departmentName);
        List<Employee> employeeList = employeeQuery.list(); // da rezultatul la Query, afiseaza rezultatul(list)
        session.close();
        return employeeList;

    }
    public List<Employee> displayAllEmployees(){

        Session session = SessionManager.getSessionFactory().openSession();
        String displayAllEmployeesQuery = "FROM Employee";
        Query<Employee> employeeQuery = session.createQuery(displayAllEmployeesQuery);
        List<Employee> employeeList = employeeQuery.list();
        session.close();
        return employeeList;

    }

    public List<Employee> displayAllEmployeesWithLetter(String letter){

        Session session = SessionManager.getSessionFactory().openSession();
        String displayAllEmployeesWithLetterQuery = "FROM Employee e where e.firstname like '%M%'";
        Query<Employee> employeeQuery = session.createQuery(displayAllEmployeesWithLetterQuery);
       // employeeQuery.setParameter("letter", letter);
        List<Employee> employeeList = employeeQuery.list();
        session.close();
        return employeeList;

    }

    public List<Employee> displayAllEmployeesAlphabetically(){

        Session session = SessionManager.getSessionFactory().openSession();
        String displayAllEmployeesQuery = "FROM Employee e order by e.firstname desc";
        Query<Employee> employeeQuery = session.createQuery(displayAllEmployeesQuery);
        List<Employee> employeeList = employeeQuery.list();
        session.close();
        return employeeList;

    }
}