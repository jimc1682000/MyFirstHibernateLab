package utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class MyHibernateUtil {
	private static StandardServiceRegistry serviceRegistry;
	private static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration().configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				configuration.getProperties()).build();
		sessionFactory = configuration.configure().buildSessionFactory(
				serviceRegistry);
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
		if (serviceRegistry != null) {
			StandardServiceRegistryBuilder.destroy(serviceRegistry);
		}
	}
}
