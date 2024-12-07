package base.model;

import lombok.*;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor

@Entity
@Table(name="question")
public class Question {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @OneToMany(cascade  =CascadeType.ALL)
    @JoinColumn(name = "qid")
    private List<Answer> answers;


    @Column(name = "question_name")
     private String questionName;


    public Question(String questionName) {
        this.questionName = questionName;
    }
}
