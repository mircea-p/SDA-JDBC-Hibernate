package com.sda.mirceapopa.hibernate.repository;

import com.sda.mirceapopa.hibernate.model.Department;
import com.sda.mirceapopa.hibernate.model.Project;
import com.sda.mirceapopa.hibernate.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProjectRepository {

    // To do, to be implemented like in DepartmentRepository

    public Project findById(Integer id)
    {
        Session session = SessionManager.getSessionFactory().openSession();
        //The find method returns the object with the provided id
        Project project = session.find(Project.class, id);
        session.close();
        return project;
    }
    public void save(Project project)
    {
        Session session = SessionManager.getSessionFactory().openSession(); // deschidem conexiunea cu baza de date
        Transaction transaction = session.beginTransaction(); // ne garanteaza ca modificarile se vor duce dintr-o singura bucata la baza de date.
        // Toate modificarile se fac impreuna. Aproba doar daca merg toate, nu pe bucati.
        //The save method persists the object to the database
        session.save(project);
        transaction.commit();
        session.close();
    }

    public void delete(Project project){

        Session session = SessionManager.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(project);
        transaction.commit();
        session.close();
    }

    public void update(Project project){

        Session session = SessionManager.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(project);
        transaction.commit();
        session.close();

    }
}
