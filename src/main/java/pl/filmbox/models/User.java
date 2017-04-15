package pl.filmbox.models;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String login;
    private String password;
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<FilmRating> filmRatings = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "users_credits",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "credit_id")
    )
    private Set<Credit> credits = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Comment> getComments() {
        return Collections.unmodifiableSet(this.comments);
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public Set<FilmRating> getFilmRatings() {
        return Collections.unmodifiableSet(this.filmRatings);
    }

    public void addFilmRating(FilmRating filmRating) {
        filmRating.setUser(this);
        this.filmRatings.add(filmRating);
    }

    public Set<Credit> getCredits() {
        return Collections.unmodifiableSet(this.credits);
    }

    public void addCredit(Credit credit) {
        this.credits.add(credit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, email);
    }
}
