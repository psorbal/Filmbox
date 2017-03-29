package pl.filmbox.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "credits")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "credit_id")
    private Long creditId;

    @Column(name = "credit")
    private String credit;

    @OneToMany(mappedBy = "credit")
    private Set<UserCredit> userCredits = new HashSet<UserCredit>();

    public Long getCreditId() {
        return creditId;
    }

    public void setCreditId(Long creditId) {
        this.creditId = creditId;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public Set<UserCredit> getUserCredits() {
        return userCredits;
    }

    public void setUserCredits(Set<UserCredit> userCredits) {
        this.userCredits = userCredits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Credit)) return false;
        Credit credit1 = (Credit) o;

        return Objects.equals(creditId, credit1.creditId) &&
                Objects.equals(credit, credit1.credit) &&
                Objects.equals(userCredits, credit1.userCredits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditId, credit, userCredits);
    }
}
