package dao;

import config.HibernateUtil;
import entity.Country;
import entity.Region;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class CountryDAO {
	public void addCountry(String id, String name, Region region) {
	    Country country = new Country(id, name, region);
	    
	    System.out.println("Saving Country => " + country.getCountryId() + ", " + country.getCountryName() + ", " + country.getRegion());

	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        Transaction tx = session.beginTransaction();
	        session.persist(country);
	        tx.commit();
	    }
	}


    public List<Country> getAllCountries() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Country", Country.class).list();
        }
    }

    public void deleteCountry(String id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Country c = session.get(Country.class, id);
            if (c != null) session.remove(c);
            tx.commit();
        }
    }
}
