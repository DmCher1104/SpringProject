package coursework.howwiki.model;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Privelege implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String name;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_x_privelege",
            joinColumns = {
                    @JoinColumn(name = "id_privelege")
            }, inverseJoinColumns = {@JoinColumn(name = "id_user")})
    private List<User> users;

    public Privelege(Long id, String name, List<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public Privelege(Long id, String name) {
        this.id=id;
        this.name=name;
    }

    public Privelege() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
