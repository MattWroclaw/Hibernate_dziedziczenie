package sda.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Pracownik")
public class Pracownik extends Firma {
    @Column
    private String stanowisko;
    @Column
    private Integer wynagrodzenie;

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public Integer getWynagrodzenie() {
        return wynagrodzenie;
    }

    public void setWynagrodzenie(Integer wynagrodzenie) {
        this.wynagrodzenie = wynagrodzenie;
    }
}
