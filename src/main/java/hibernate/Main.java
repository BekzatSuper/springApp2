package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration configuration= new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Passport.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            Person person = new Person("Test", 50);
            Passport passport = new Passport(person, 251616);
            person.setPassport(passport);
            session.save(person);
            session.getTransaction().commit();

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
