package pl.filmbox.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<FilmRating> filmRatings = new HashSet<FilmRating>();

    @OneToMany(mappedBy = "user")
    private Set<UserCredit> userCredits = new HashSet<UserCredit>();

    @OneToMany(mappedBy = "user")
    private Set<Comment> comments = new HashSet<Comment>();

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Set<FilmRating> getFilmRatings() {
        return filmRatings;
    }

    public void setFilmRatings(Set<FilmRating> filmRatings) {
        this.filmRatings = filmRatings;
    }

    public Set<UserCredit> getUserCredits() {
        return userCredits;
    }

    public void setUserCredits(Set<UserCredit> userCredits) {
        this.userCredits = userCredits;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;

        return Objects.equals(userId, user.userId) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(filmRatings, user.filmRatings) &&
                Objects.equals(userCredits, user.userCredits) &&
                Objects.equals(comments, user.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, login, password, email, filmRatings, userCredits, comments);
    }
}
