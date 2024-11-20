package main.com.myApp.model;
import java.util.List;
import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;

@Component
@Setter
@Getter
public class UserModel {
      // @NotNull(message=" is required")
     //@Size(min=1,message="is required")
    @NotEmpty(message = "cannot empty")
    private String username;
    private  String password;
    @Min(value=50000, message = " cannot be less than 50000")
    @Max(value=100000, message = " cannot be more than 100000")
    private Double salary;
    @Pattern(regexp = "^(.+)@(\\S+)$" ,message=" enter a valid email")
    private  String email;
    private String country;
    private String programmingLanguage;
    private List<String> operatingSystem;
}

