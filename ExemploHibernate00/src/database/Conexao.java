package database;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Lucas Rodrigo Frederico
 */
public class Conexao {

    private StandardServiceRegistry sr = null;
    private SessionFactory factory = null;
    public Transaction transaction;
    public Session session = null;

    public boolean conectar() {
        sr = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        factory = new Configuration().buildSessionFactory(sr);
        try {
            session = factory.openSession();
            transaction = session.getTransaction();
            transaction.begin();
            return true;
        } catch (HibernateException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        }
    }

}
