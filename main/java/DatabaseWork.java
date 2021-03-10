import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;

public class DatabaseWork implements Closeable {
    static private Session session;
    static private SessionFactory sessionFactory;

    static {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        sessionFactory = metadata.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public DatabaseWork(String nameTable) {
        Transaction transaction = session.beginTransaction();
        session.createQuery("delete from " + nameTable).executeUpdate();
        session.flush();
        transaction.commit();

    }

    public void addElement(Phrase phrase) {
        Transaction transaction = session.beginTransaction();
        session.save(phrase);
        session.flush();
        transaction.commit();

    }

    @Override
    public void close() throws IOException {
        sessionFactory.close();
    }
}
