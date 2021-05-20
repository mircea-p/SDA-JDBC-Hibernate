package com.sda.mirceapopa.hibernate2.repository;

import com.sda.mirceapopa.hibernate2.model.*;
import com.sda.mirceapopa.hibernate2.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ModuleRepository {

    public void save(Module module, Classroom classroom, Team team, Topic topic){
        Session session = SessionManager.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(classroom);
        module.setClassroom(classroom);
        module.setTeam(team);
        module.setTopic(topic);
        session.save(module);
        transaction.commit();
        session.close();
    }

}
