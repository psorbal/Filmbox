package pl.filmbox.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_credit")
public class UserCredit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_credit_id")
    private Long userCreditId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credit_id")
    private Credit credit;

    public Long getUserCreditId() {
        return userCreditId;
    }

    public void setUserCreditId(Long userCreditId) {
        this.userCreditId = userCreditId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserCredit)) return false;
        UserCredit that = (UserCredit) o;

        return Objects.equals(userCreditId, that.userCreditId) &&
                Objects.equals(user, that.user) &&
                Objects.equals(credit, that.credit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userCreditId, user, credit);
    }
}
