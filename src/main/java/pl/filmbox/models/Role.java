package pl.filmbox.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "role")
    private Set<FilmPeople> filmPeople = new HashSet<FilmPeople>();

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
        if (!(o instanceof Role)) return false;
        Role role1 = (Role) o;

        return Objects.equals(roleId, role1.roleId) &&
                Objects.equals(role, role1.role) &&
                Objects.equals(filmPeople, role1.filmPeople);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, role, filmPeople);
    }
}
