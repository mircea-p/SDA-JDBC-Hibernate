package com.sda.mirceapopa.hibernate2.utils;


import com.sda.mirceapopa.hibernate2.model.Classroom;
import com.sda.mirceapopa.hibernate2.model.Module;
import com.sda.mirceapopa.hibernate2.model.Person;
import com.sda.mirceapopa.hibernate2.model.Team;
import com.sda.mirceapopa.hibernate2.utils.AbstractSessionManager;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager extends AbstractSessionManager {

    private static final com.sda.mirceapopa.hibernate2.utils.SessionManager INSTANCE = new com.sda.mirceapopa.hibernate2.utils.SessionManager();

    private SessionManager() {
    }
    public static void shutDown(){
        INSTANCE.shutdownSessionManager();
    }

    public static SessionFactory getSessionFactory(){
        return INSTANCE.getSessionFactory("sdaDatabaseStructure");

    }
    @Override
    protected void setAnnotatedClasses(Configuration configuration) {
       configuration.addAnnotatedClass(Person.class);
       configuration.addAnnotatedClass(Team.class);
       configuration.addAnnotatedClass(Module.class);
       configuration.addAnnotatedClass(Classroom.class);
    }


}

