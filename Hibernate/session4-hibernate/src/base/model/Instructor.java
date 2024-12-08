package base.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor

@Entity
@Table(name="instructor")
public class Instructor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "instructor_name")
    private String instructorName;


    //mapped by bec bi direction
    @OneToMany(mappedBy = "instructor",cascade = {CascadeType.PERSIST,
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private List<Course> courses;

    public Instructor(String instructorName) {
        this.instructorName = instructorName;
    }
}
