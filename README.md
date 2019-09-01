<h1># Hibernate_dziedziczenie</h1>
<h3>Hibernate przykłady z dziedziczenia.</h3>

Super Class *Firma*
* id
* nazwa firmy
* imie
* nazwisko

Child Class *Klient*
* id
* nazwa firmy
* imie
* nazwisko
* telefonKon

Child Class *Pracownik*
* id
* nazwa firmy
* imie
* nazwisko
* stanowisko
* wynagrodzenie

 Mamy następującą strukturę danych:
Zadanie 1
Odwzorować strukturę danych tak aby dane klienta i pracownika znajdowały się 
w dwóch tabelach (tabela Klient i Pracownik-wykorzystać do tego @MappedSuperclass) 
Zadanie 2
Stwórz 2 klasy DAO-KlientDAO i PracownikDAO, które będą posaidały metody:
* CRUD: 4 metody create, read, update, delete
* findById: szuka po id konkretnego pracownika lub klienta
* findByNazwisko:  zwraca listę klientów lub pracowników z podanym nazwiskiem
