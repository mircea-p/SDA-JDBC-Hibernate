package com.sda.mirceapopa.hibernate2.repository;

import com.sda.mirceapopa.hibernate.model.Employee;
import com.sda.mirceapopa.hibernate2.model.Team;
import com.sda.mirceapopa.hibernate2.utils.SessionManager;
import com.sda.mirceapopa.hibernate2.model.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PersonRepository {

    public void save(Person person){
        Session session= com.sda.mirceapopa.hibernate2.utils.SessionManager.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        session.save(person);
        transaction.commit();
        session.close();


    }

    public List<Person> displayAllStudents(){

        Session session = SessionManager.getSessionFactory().openSession();
        String displayAllStudentsQuery = "FROM Person";
        Query<Person> personQuery = session.createQuery(displayAllStudentsQuery);
        List<Person> personList =personQuery.list();
        session.close();
        return personList;
    }

    public List<Person> listAllStudentsForATeam(String teamName){
        Session session = SessionManager.getSessionFactory().openSession();
        String hqlQuery = "FROM  Person p where p.team.teamName = :teamName";
        Query<Person> personQuery = session.createQuery(hqlQuery);
        personQuery.setParameter("teamName", teamName);
        List<Person> personList = personQuery.list(); // da rezultatul la Query, afiseaza rezultatul(list)
        session.close();
        return personList;

    }
}
