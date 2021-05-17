package com.sda.mirceapopa.hibernate2.repository;

import com.sda.mirceapopa.hibernate2.model.Classroom;
import com.sda.mirceapopa.hibernate2.model.Module;
import com.sda.mirceapopa.hibernate2.model.Person;
import com.sda.mirceapopa.hibernate2.model.Team;
import com.sda.mirceapopa.hibernate2.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ModuleRepository {

    public void save(Module module,Classroom classroom){
        Session session = SessionManager.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(module);
        transaction.commit();
        session.close();
    }

    public List<Team> listAllClasesInLocation(String location){

        Session session = SessionManager.getSessionFactory().openSession();
        String hqlQuery = "SELECT Module.team.teamName FROM  Module m  where m.classroom.adress = :location";
        Query<Team> teamQuery = session.createQuery(hqlQuery);
        teamQuery.setParameter("location", location);
        List<Team> teamList = teamQuery.list(); // da rezultatul la Query, afiseaza rezultatul(list)
        session.close();
        return teamList;

    }
}
