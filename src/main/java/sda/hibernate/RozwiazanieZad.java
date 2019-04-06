package sda.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sda.hibernate.entity.Klient;
import sda.hibernate.entity.Pracownik;

public class RozwiazanieZad {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr =session.beginTransaction();
        Pracownik pracownik=new Pracownik();
        pracownik.setImie("Ewa");
        pracownik.setNazwisko("Kowalska");
        pracownik.setStanowisko("Mlodszy Programista JAVA");
        pracownik.setNazwaFirmy("SDA");
        pracownik.setWynagrodzenie(5000);
        session.persist(pracownik);

        Klient klient = new Klient();
        klient.setImie("Adam");
        klient.setNazwisko("Nowak");
        klient.setNazwaFirmy("SDA");
        klient.setTelefonKon("123456789");
        session.persist(klient);
        tr.commit();
        session.close();
    }
}
