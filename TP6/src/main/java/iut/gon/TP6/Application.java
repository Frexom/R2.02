package iut.gon.TP6;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.h2.tools.Server;

public class Application {

    public static void main(String[] args) throws SQLException {
        startDatabase();

        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        Customer customer = new Customer();
        //Produit kop1pel = new Produit("kop1pel", 11.);
        //Prestation prestation = new Prestation("Prestation", 1000., 5.5);
        customer.setFirstName("Dennys");
        customer.setLastName("Fredericci");

        entityManager.getTransaction().begin();
        //entityManager.persist(customer);
        //entityManager.persist(kop1pel);
        //entityManager.persist(prestation);
        entityManager.getTransaction().commit();
        
        Query q = entityManager.createQuery("FROM Customer");
        System.out.println("List : " + q.getResultList());

        System.out.println("Open your browser and navigate to http://localhost:8082/");
        System.out.println("JDBC URL: jdbc:h2:mem:my_database");
        System.out.println("User Name: sa");
        System.out.println("Password: ");

    }

    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }
}
