package config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import entity.Region;
import entity.Country;

public class HibernateUtil {
    private static final SessionFactory factory;

    static {
        factory = new Configuration()
                .configure()
                .addAnnotatedClass(Region.class)
                .addAnnotatedClass(Country.class)
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }
}
