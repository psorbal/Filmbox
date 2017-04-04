package pl.filmbox.models;

import javax.persistence.*;
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
    private Date birthdate;
    private Date death;

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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getDeath() {
        return death;
    }

    public void setDeath(Date death) {
        this.death = death;
    }

    public Set<FilmPeople> getFilmPeople() {
        return Collections.unmodifiableSet(this.filmPeople);
    }

    public void addFilmPeople(FilmPeople filmPeople) {
        filmPeople.setPerson(this);
        this.filmPeople.add(filmPeople);
    }
}
