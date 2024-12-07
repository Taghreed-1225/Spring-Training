package base.model;

import lombok.*;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor

@Entity
@Table(name="person")
public class Person {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    private Date birthDate;
    @Transient
    private SimpleDateFormat dateFormat;

    public Person(String firstName, String lastName, String birthDate) throws ParseException {
        this.firstName = firstName;
        this.lastName = lastName;

        dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        this.birthDate = dateFormat.parse(birthDate);
    }



}
