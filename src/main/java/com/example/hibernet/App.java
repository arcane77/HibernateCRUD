package com.example.hibernet;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
       

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(SomeClass.class)
                .buildSessionFactory();

        SomeClassDAO dao = new SomeClassDAO(sessionFactory);

        try (Scanner scanner = new Scanner(System.in)) { 
            while (true) {
                System.out.println("choose an operation:");
                System.out.println("1. create");
                System.out.println("2. read");
                System.out.println("3. update");
                System.out.println("4. delete");
                System.out.println("5. exit");

                int choice = scanner.nextInt();
                switch(choice) {
                case 1:
                    dao.createEntity(scanner);
                    break;
                case 2:
                    dao.readEntity(scanner);
                    break;
                case 3:
                    dao.updateEntity(scanner);
                    break;
                case 4:
                    dao.deleteEntity(scanner);
                    break;
                    
                case 5:
                    return;
                    
                default:
                    System.out.println("invalid choice");
                }

            }
        }
  }
}
