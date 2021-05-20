package com.sda.mirceapopa.hibernate3.utils;


import com.sda.mirceapopa.hibernate2.model.Classroom;
import com.sda.mirceapopa.hibernate2.model.Module;
import com.sda.mirceapopa.hibernate2.model.Person;
import com.sda.mirceapopa.hibernate2.model.Team;
import com.sda.mirceapopa.hibernate3.model.Client;
import com.sda.mirceapopa.hibernate3.model.Reservation;
import com.sda.mirceapopa.hibernate3.model.Seat;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager extends AbstractSessionManager {

    private static final SessionManager INSTANCE = new SessionManager();

    private SessionManager() {
    }
    public static void shutDown(){
        INSTANCE.shutdownSessionManager();
    }

    public static SessionFactory getSessionFactory(){
        return INSTANCE.getSessionFactory("cinemaSDA");

    }
    @Override
    protected void setAnnotatedClasses(Configuration configuration) {
       configuration.addAnnotatedClass(Client.class);
       configuration.addAnnotatedClass(Reservation.class);
       configuration.addAnnotatedClass(Seat.class);

    }


}

