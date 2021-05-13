package com.sda.mirceapopa.hibernate.repository;
import com.sda.mirceapopa.hibernate.model.Account;
import com.sda.mirceapopa.hibernate.model.Department;
import com.sda.mirceapopa.hibernate.model.Employee;
import com.sda.mirceapopa.hibernate.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
}