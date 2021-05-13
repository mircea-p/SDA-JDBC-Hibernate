package com.sda.mirceapopa.hibernate.repository;

import com.sda.mirceapopa.hibernate.model.Department;
import com.sda.mirceapopa.hibernate.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class DepartmentRepository
{
    public Department findById(Integer id)
    {
        Session session = SessionManager.getSessionFactory().openSession();
        //The find method returns the object with the provided id
        Department department = session.find(Department.class, id);
        session.close();
        return department;
    }
    public void save(Department department)
    {
        Session session = SessionManager.getSessionFactory().openSession(); // deschidem conexiunea cu baza de date
        Transaction transaction = session.beginTransaction(); // ne garanteaza ca modificarile se vor duce dintr-o singura bucata la baza de date.
        // Toate modificarile se fac impreuna. Aproba doar daca merg toate, nu pe bucati.

        //The save method persists the object to the database
        session.save(department);
        transaction.commit();
        session.close();
    }

    public void delete(Department department){

        Session session = SessionManager.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(department);
        transaction.commit();
        session.close();
    }

    public void update(Department department){

        Session session = SessionManager.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(department);
        transaction.commit();
        session.close();

    }
}