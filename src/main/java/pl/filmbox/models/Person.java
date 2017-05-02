package pl.filmbox.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;
    private String firstname;
    private String lastname;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthdate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate death;

    @OneToMany(mappedBy = "person")
    private Set<FilmPeople> filmPeople = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public LocalDate getDeath() {
        return death;
    }

    public void setDeath(LocalDate death) {
        this.death = death;
    }

    public Set<FilmPeople> getFilmPeople() {
        return Collections.unmodifiableSet(this.filmPeople);
    }

    public void addFilmPeople(FilmPeople filmPeople) {
        filmPeople.setPerson(this);
        this.filmPeople.add(filmPeople);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(firstname, person.firstname) &&
                Objects.equals(lastname, person.lastname) &&
                Objects.equals(birthdate, person.birthdate) &&
                Objects.equals(death, person.death);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, birthdate, death);
    }
}
