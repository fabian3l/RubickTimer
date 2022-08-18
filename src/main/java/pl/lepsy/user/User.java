package pl.lepsy.user;

import javax.persistence.*;

@Entity
@Table(name = User.TABLE_NAME)
public class User {

    final static String TABLE_NAME = "user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_password")
    private String userPassword;
}
