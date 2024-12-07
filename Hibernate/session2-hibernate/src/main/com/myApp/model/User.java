package main.com.myApp.model;
import lombok.*;
//import main.com.myApp.annotations.Confirm;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

//@Component
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="user")
public class User {
@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String username;

@Column(name = "password")
   private  String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

