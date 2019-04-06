package sda.hibernate.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sda.hibernate.HibernateUtil;
import sda.hibernate.entity.Klient;

import java.util.List;

public class KlientDAO {
    public Klient create(String nazwaFirmy, String imie, String nazwisko, String telefon) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        Klient nowyKlient = new Klient();
        nowyKlient.setNazwaFirmy(nazwaFirmy);
        nowyKlient.setImie(imie);
        nowyKlient.setNazwisko(nazwisko);
        nowyKlient.setTelefonKon(telefon);
        session.persist(nowyKlient);
        tr.commit();
        session.close();
        return nowyKlient;
    }

    public Klient read(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Klient klientDB = session.find(Klient.class, id);
        session.close();
        return klientDB;
    }

    public void update(String nazwaFirmy, String imie, String nazwisko, String telefon, Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.createQuery("UPDATE Klient k SET k.telefonKon=:telefonKon, " +
                "k.nazwaFirmy=:nazwaFirmy, " +
                "k.imie=:imie, k.nazwisko=:nazwisko WHERE k.id=:id")
                .setParameter("telefonKon", telefon).setParameter("nazwaFirmy", nazwaFirmy)
                .setParameter("imie", imie).setParameter("nazwisko", nazwisko)
                .setParameter("id", id).executeUpdate();
        tr.commit();
        session.close();
    }

    public void delete(Klient klient) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.delete(klient);
        tr.commit();
        session.close();
    }

    public List<Klient> findByNazwisko(String nazwisko){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Klient> klienci = session.createNativeQuery("SELECT * FROM firma f " +
                "WHERE f.nazwisko=:nazwisko",Klient.class).setParameter("nazwisko",nazwisko)
                .getResultList();
        session.close();
        return klienci;
    }

    public List<Klient> findByNazwaFirmy(String nazwaFirmy){
        Session session= HibernateUtil.getSessionFactory().openSession();
        List<Klient> klienci = session.createNamedQuery("findByNazwaFirmy",Klient.class)
                .setParameter("nazwaFirmy",nazwaFirmy).getResultList();
        session.close();
        return klienci;
    }
}
