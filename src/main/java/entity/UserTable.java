package entity;

import javax.persistence.*;

@Entity
@Table
public class UserTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String login;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}

