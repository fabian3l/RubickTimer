package pl.lepsy.user;

import javax.persistence.*;

@Entity
@Table(name = User.TABLE_NAME)
public class User {

    final static String TABLE_NAME = "user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String userPassword;
}
