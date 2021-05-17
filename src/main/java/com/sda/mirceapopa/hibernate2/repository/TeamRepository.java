package com.sda.mirceapopa.hibernate2.repository;

import com.sda.mirceapopa.hibernate2.model.Team;
import com.sda.mirceapopa.hibernate2.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TeamRepository {

    public void save(Team team){
        Session session = SessionManager.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(team);
        transaction.commit();
        session.close();
    }

}
