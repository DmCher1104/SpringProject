package coursework.howwiki.model;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Privilege implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_x_privilege",
            joinColumns = {
                    @JoinColumn(name = "id_privilege")
            }, inverseJoinColumns = {@JoinColumn(name = "id_user")})
    private List<User> users;

    public Privilege(Long id, String name, List<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public Privilege(Long id, String name) {
        this.id=id;
        this.name=name;
    }

    public Privilege() {
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

    public void setUser(List<User> users) {
        this.users = users;
    }

   @Override
    public String getAuthority() {
        return name;
    }
}
