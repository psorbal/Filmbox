package pl.filmbox.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_authority")
public class UserAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_authority_id")
    private Long userAuthorityId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authority_id")
    private Authority authority;

    public Long getUserAuthorityId() {
        return userAuthorityId;
    }

    public void setUserAuthorityId(Long userAuthorityId) {
        this.userAuthorityId = userAuthorityId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAuthority)) return false;
        UserAuthority that = (UserAuthority) o;

        return Objects.equals(userAuthorityId, that.userAuthorityId) &&
                Objects.equals(user, that.user) &&
                Objects.equals(authority, that.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userAuthorityId, user, authority);
    }
}
