package main.com.myApp.model;
import lombok.*;
//import main.com.myApp.annotations.Confirm;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
//@Component
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="user")
public class UserModel {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String username;
@Column(name = "email")
private  String email;
@Column(name = "password")
   private  String password;





}

