package sda.hibernate.entity;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Klient")
@NamedQueries(@NamedQuery(name = "findByNazwaFirmy",
        query = "SELECT k FROM Klient k WHERE k.nazwaFirmy=:nazwaFirmy"))
public class Klient extends Firma {
    @Column
    private String telefonKon;

    public String getTelefonKon() {
        return telefonKon;
    }

    public void setTelefonKon(String telefonKon) {
        this.telefonKon = telefonKon;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "telefonKon='" + telefonKon + '\'' +
                ", id=" + id +
                ", nazwaFirmy='" + nazwaFirmy + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                '}';
    }
}
