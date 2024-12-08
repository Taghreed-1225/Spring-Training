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
@Table(name="course")
public class Course {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "course_name")
    private String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;


    public Course(String courseName ,Instructor instructor){
        this.courseName=courseName;
        this.instructor=instructor;

    }
}
