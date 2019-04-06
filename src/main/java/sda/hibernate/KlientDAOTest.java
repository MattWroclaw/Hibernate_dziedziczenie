package sda.hibernate;

import sda.hibernate.DAO.KlientDAO;
import sda.hibernate.entity.Klient;

import java.util.List;

public class KlientDAOTest {
    public static void main(String[] args) {
        KlientDAO klientDAO = new KlientDAO();
        //create 5 klientow
        klientDAO.create("SDA", "Adam", "Nowak", "123456789");
        klientDAO.create("PG", "EWA", "Kowalska", "123456788");
        klientDAO.create("SDA", "Marek", "Kowal", "987654321");
        klientDAO.create("UG", "Adam", "Duda", "122548785");
        klientDAO.create("SDA", "Piotr", "Nowak", "123547896");

        //read klient id 4
        Klient klientDB = klientDAO.read(4L);
        System.out.println("Znaleziono klienta: " + klientDB.toString());

        //update klient
        System.out.println("Znaleziono klienta: " + klientDAO.read(5L).toString());
        klientDAO.update("SDA", "PiotrNowy", "Nowak", "brak", 5L);
        System.out.println("Znaleziono klienta: " + klientDAO.read(5L).toString());

        //delete klient id 3
        Klient klientDBdoUsuniecia = klientDAO.read(3L);
        klientDAO.delete(klientDBdoUsuniecia);

        //findByNazwisko
        List<Klient> klientList = klientDAO.findByNazwisko("Nowak");
        for(Klient klient:klientList){
            System.out.println(klient.toString());
        }

        //findByNazwisko
        List<Klient> klientList2 = klientDAO.findByNazwaFirmy("SDA");
        for(Klient klient:klientList2){
            System.out.println(klient.toString());
        }

    }
}
