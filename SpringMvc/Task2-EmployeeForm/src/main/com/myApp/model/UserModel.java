package main.com.myApp.model;
import lombok.Getter;
import lombok.Setter;
import main.com.myApp.annotations.Confirm;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Component
@Setter
@Getter

@Confirm(first = "password", second = "confirmrpassword" , message = "not match")
public class UserModel {
      // @NotNull(message=" is required")
     //@Size(min=1,message="is required")
    @NotEmpty(message = "cannot empty")
    private String username;
    @NotEmpty(message = "cannot empty")
    @Pattern(regexp = "^(.+)@(\\S+)$" ,message=" enter a valid email")
    private  String email;
    @NotEmpty(message = "cannot empty")
    private  String password;
    @NotEmpty(message = "cannot empty")

    private  String  confirmrpassword;



}

