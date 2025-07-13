package dao;

import config.HibernateUtil;
import entity.Region;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class RegionDAO {
    public void addRegion(String name) {
        Region region = new Region(name);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(region);
            tx.commit();
        }
    }

    public List<Region> getAllRegions() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Region", Region.class).list();
        }
    }

    public Region getById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Region.class, id);
        }
    }

    public void deleteRegion(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Region r = session.get(Region.class, id);
            if (r != null) session.remove(r);
            tx.commit();
        }
    }
}
