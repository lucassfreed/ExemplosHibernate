
import bean.Sistema;
import java.util.List;
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
public class Principal {

    public static void main(String[] args) {
        Configuration conf = new Configuration();
        StandardServiceRegistry sr = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        SessionFactory factory = new Configuration().buildSessionFactory(sr);
        Transaction transaction = null;

        try {
            Session session = factory.openSession();
            transaction = session.getTransaction();
            transaction.begin();
            
            // INSERT
            /*Sistema sistemaDoKleton = new Sistema();
            sistemaDoKleton.setNome("Creitom");
            session.save(sistemaDoKleton);*/

            // UPDATE
            /*Sistema sistemaDoKleton = new Sistema();
            sistemaDoKleton.setNome("Creitom");
            sistemaDoKleton.setId(1);
            session.update(sistemaDoKleton);*/
            
            //LISTAR
            /*List resultados = session.createQuery("from Sistema").list();

            for (Sistema sistema : (List<Sistema>) resultados) {
                System.out.println(sistema.getNome());
            }*/
            
            // EXCLUIR
            Sistema sistema = new Sistema();
            sistema.setNome("asdasd");
            session.save(sistema);
            
            
            // INSERT NA TABELA
            transaction.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            factory.close();
        }

    }

}
