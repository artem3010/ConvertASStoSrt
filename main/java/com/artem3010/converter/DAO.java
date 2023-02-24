package com.artem3010.converter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.Closeable;

public class DAO implements Closeable {

    private static volatile DAO instance = new DAO();
    private static Object mutex = new Object();

    private String tableName;
    public static DAO getInstance(String tableName) {
        DAO result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null) {
                    instance = new DAO();
                    result = instance;
                }
            }
        }
        instance.tableName = tableName;
        return result;
    }
    private static SessionFactory sessionFactory;

    public DAO() {
    }

    static {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().
                configure("com/artem3010/converter/hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        sessionFactory = metadata.buildSessionFactory();
    }

    public void addElement(Phrase phrase) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(phrase);
        session.flush();
        transaction.commit();

    }

    @Override
    public void close() {
        sessionFactory.close();
    }
}
