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
@Table(name="passport")
public class Passport {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @OneToOne(cascade  =CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person personId;
    @Column(name = "passport_no")
     private String passportNo;
    @Column(name = "expiry_date")
    private Date expiryDate;
    @Transient
    private SimpleDateFormat dateFormat;

    public Passport(String passportNo, String expiryDate) throws ParseException {
        this.passportNo = passportNo;
        dateFormat=new SimpleDateFormat("yyyy-MM-dd");


        this.expiryDate = dateFormat.parse(expiryDate);
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }
}
