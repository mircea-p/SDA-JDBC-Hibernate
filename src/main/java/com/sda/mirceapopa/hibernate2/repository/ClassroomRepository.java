package com.sda.mirceapopa.hibernate2.repository;

import com.sda.mirceapopa.hibernate2.model.Classroom;
import com.sda.mirceapopa.hibernate2.model.Team;
import com.sda.mirceapopa.hibernate2.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClassroomRepository {

    public void save(Classroom classroom){
        Session session = SessionManager.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(classroom);
        transaction.commit();
        session.close();
    }
}
