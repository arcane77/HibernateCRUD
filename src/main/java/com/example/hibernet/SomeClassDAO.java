package com.example.hibernet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class SomeClassDAO {

    private SessionFactory sessionFactory;

    public SomeClassDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // create 
    public void createEntity(Scanner scanner) {
        System.out.println("enter the ID:");
        int id = scanner.nextInt();
        System.out.println("enter the name:");
        String name = scanner.next();

        SomeClass entity = new SomeClass();
        entity.setId(id);
        entity.setName(name);

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            System.out.println("entity inserted successfully!");
        }
    }

    // read
    public void readEntity(Scanner scanner) {
        System.out.println("enter the ID of the entity to read:");
        int id = scanner.nextInt();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            SomeClass entity = session.get(SomeClass.class, id);

            if (entity != null) {
                System.out.println("entity: " + entity);
            } else {
                System.out.println("no entity found with ID " + id);
            }

            session.getTransaction().commit();
        }
    }

    // update 
    public void updateEntity(Scanner scanner) {
        System.out.println("enter the ID of the entity to update:");
        int id = scanner.nextInt();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            SomeClass entity = session.get(SomeClass.class, id);

            if (entity != null) {
                System.out.println("enter the new name:");
                String newName = scanner.next();
                entity.setName(newName);
                session.update(entity);  // Explicit update
                System.out.println("entity updated!");
            } else {
                System.out.println("no entity found with ID " + id);
            }

            session.getTransaction().commit();
        }
    }

    // delete 
    public void deleteEntity(Scanner scanner) {
        System.out.println("enter the ID of the entity to delete:");
        int id = scanner.nextInt();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            SomeClass entity = session.get(SomeClass.class, id);

            if (entity != null) {
                session.delete(entity);
                System.out.println("entity deleted!");
            } else {
                System.out.println("no entity found with ID " + id);
            }

            session.getTransaction().commit();
        }
    }
}
