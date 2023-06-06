package models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_question_items")
public class QuestionItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 500)
    private String text;
    @Column(name = "is_true")
    private boolean isTrue;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;
    public QuestionItems() {}

    public QuestionItems(Question question, String text, boolean isTrue) {
        this.text = text;
        this.question = question;
        this.isTrue = isTrue;
    }
}
