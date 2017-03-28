package pl.filmbox.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_id")
    private Long authorityId;

    @Column(name = "authority")
    private String authority;

    @OneToMany(mappedBy = "authority")
    private Set<UserAuthority> userAuthorities = new HashSet<UserAuthority>();

    public Long getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Long authorityId) {
        this.authorityId = authorityId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Set<UserAuthority> getUserAuthorities() {
        return userAuthorities;
    }

    public void setUserAuthorities(Set<UserAuthority> userAuthorities) {
        this.userAuthorities = userAuthorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Authority)) return false;
        Authority authority1 = (Authority) o;

        return Objects.equals(authorityId, authority1.authorityId) &&
                Objects.equals(authority, authority1.authority) &&
                Objects.equals(userAuthorities, authority1.userAuthorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorityId, authority, userAuthorities);
    }
}
