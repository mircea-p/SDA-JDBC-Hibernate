package com.sda.mirceapopa.hibernate2.repository;

import com.sda.mirceapopa.hibernate2.model.Team;
import com.sda.mirceapopa.hibernate2.model.Topic;
import com.sda.mirceapopa.hibernate2.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TopicRepository {

    public void save(Topic topic){
        Session session = SessionManager.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(topic);
        transaction.commit();
        session.close();
    }
}
