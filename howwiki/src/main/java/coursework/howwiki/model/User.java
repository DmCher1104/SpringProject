package coursework.howwiki.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @CreatedDate
//    private LocalDate dateCreate;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String email;

    @Column(name="number_of_post")
    private int numberOfPost;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_x_privilege",
            joinColumns = {
                    @JoinColumn(name = "id_user")
            }, inverseJoinColumns = {@JoinColumn(name = "id_privilege")})
    private Set<Privilege> privileges;

    public User(Long id, String login, String password, String email, int numberOfPost, Set<Privilege> privileges) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.numberOfPost = numberOfPost;
        this.privileges = privileges;
    }

    public Set<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<Privilege> privileges) {
        this.privileges = this.privileges;
    }

    public User() {
    }

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return privileges;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
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

    public int getNumberOfPost() {
        return numberOfPost;
    }

    public void setNumberOfPost(int numberOfPost) {
        this.numberOfPost = numberOfPost;
    }
}
