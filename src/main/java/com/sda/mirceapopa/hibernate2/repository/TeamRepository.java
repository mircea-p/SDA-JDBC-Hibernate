package com.sda.mirceapopa.hibernate2.repository;

import com.sda.mirceapopa.hibernate2.model.Classroom;
import com.sda.mirceapopa.hibernate2.model.Module;
import com.sda.mirceapopa.hibernate2.model.Team;
import com.sda.mirceapopa.hibernate2.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TeamRepository {

    public void save(Team team){
        Session session = SessionManager.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(team);
        transaction.commit();
        session.close();
    }

    public List<Team> listAllClasesInLocation(String location){

        Session session = SessionManager.getSessionFactory().openSession();
        String hqlQuery = "FROM Classroom c where c.adress = :location";
        Query<Classroom> teamQuery = session.createQuery(hqlQuery);
        teamQuery.setParameter("location", location);
        List<Classroom> classroomList = teamQuery.list(); // da rezultatul la Query, afiseaza rezultatul(list)

        Set<Team> teamSet = new HashSet<>();

        for (Classroom classroom: classroomList)
        {
            for (Module module : classroom.getModuleList())
            {
                teamSet.addAll(module.getTeamList());
            }
        }

        session.close();
        return new ArrayList<>(teamSet);

    }

}
