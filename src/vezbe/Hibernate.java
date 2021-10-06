package vezbe;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Hibernate {
	  private static SessionFactory sessionFactory;

	    public static SessionFactory getSessionFactory() {
	        if (sessionFactory == null) {
	            Configuration configuration = new Configuration().configure();
	            ServiceRegistry serviceRegistry
	                = new StandardServiceRegistryBuilder()
	                    .applySettings(configuration.getProperties()).build();
	     
	            sessionFactory = configuration.addAnnotatedClass(Dao.class).addAnnotatedClass(Person.class)
	            		.buildSessionFactory(serviceRegistry);  
	            
	        }
	         
	        return sessionFactory;
	    }
	
}
