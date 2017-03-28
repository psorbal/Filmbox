package pl.filmbox.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "film_person")
public class FilmPeople {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_person_id")
    private Long filmPersonId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role role;

    public Long getFilmPersonId() {
        return filmPersonId;
    }

    public void setFilmPersonId(Long filmPersonId) {
        this.filmPersonId = filmPersonId;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FilmPeople)) return false;
        FilmPeople that = (FilmPeople) o;

        return Objects.equals(filmPersonId, that.filmPersonId) &&
                Objects.equals(film, that.film) &&
                Objects.equals(person, that.person) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmPersonId, film, person, role);
    }
}
