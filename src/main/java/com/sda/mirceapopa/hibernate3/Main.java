package com.sda.mirceapopa.hibernate3;

import com.sda.mirceapopa.hibernate3.model.Client;
import com.sda.mirceapopa.hibernate3.repository.ClientRepository;
import com.sda.mirceapopa.hibernate3.utils.SessionManager;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {

        ClientRepository clientRepository = new ClientRepository();
        Client client1 = new Client("Andrei", "Vasilescu", "ioi@yahoo.com", Date.valueOf("1991-05-25"));
        Client client2 = new Client("Paul", "Tanase", "tane@yahoo.com", Date.valueOf("1989-05-25"));

        clientRepository.save(client1);
        clientRepository.save(client2);

        clientRepository.findAll().forEach(System.out::println);

        SessionManager.shutDown();

    }
}
