package com.sda.mirceapopa.hibernate3.repository;

import com.sda.mirceapopa.hibernate3.model.Client;
import com.sda.mirceapopa.hibernate3.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClientRepository {

    public Client findById(Integer id) {

        Session session = SessionManager.getSessionFactory().openSession();
        Client client = session.find(Client.class, id);
        session.close();
        return client;
    }
    public void save(Client client){
        Session session = SessionManager.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(client);
        transaction.commit();
        session.close();
    }
    public Set<Client> findAll(){
        Session session = SessionManager.getSessionFactory().openSession();
        List<Client> clientListResult = session.createQuery("SELECT c FROM Client c").getResultList();
        session.close();
        return new HashSet<>(clientListResult);

    }
}
