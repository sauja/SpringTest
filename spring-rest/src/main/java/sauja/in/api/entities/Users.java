package sauja.in.api.entities;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name = "Users.findAll",query = "select u from Users u"),
        @NamedQuery(name = "Users.findByEmail", query = "select u from Users u where u.email=:pEmail")
})
public class Users {
    @Id
    private @Getter @Setter String id;
    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;
    @Column(unique = true)
    private @Getter @Setter String email;

    public Users() {
        this.id = UUID.randomUUID().toString();
    }
}
