package pl.filmbox.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long personId;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "death")
    private Date dateOfDeath;

    @OneToMany(mappedBy = "person")
    private Set<FilmPeople> filmPeople = new HashSet<FilmPeople>();

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Date dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public Set<FilmPeople> getFilmPeople() {
        return filmPeople;
    }

    public void setFilmPeople(Set<FilmPeople> filmPeople) {
        this.filmPeople = filmPeople;
    }

    public void addFilmPeople(FilmPeople filmPeople) {
        this.filmPeople.add(filmPeople);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;

        return Objects.equals(personId, person.personId) &&
                Objects.equals(firstname, person.firstname) &&
                Objects.equals(lastname, person.lastname) &&
                Objects.equals(birthday, person.birthday) &&
                Objects.equals(dateOfDeath, person.dateOfDeath) &&
                Objects.equals(filmPeople, person.filmPeople);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, firstname, lastname, birthday, dateOfDeath, filmPeople);
    }
}
