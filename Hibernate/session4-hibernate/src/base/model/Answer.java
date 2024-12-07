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
@Table(name="answer")
public class Answer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "answer_name")
    private String answerName;

    public Answer(String answerName) {
        this.answerName = answerName;
    }
}
