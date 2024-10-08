package domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Comment")
@Getter @Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long backId;   //코멘트 고유 어카운트

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contentId", referencedColumnName = "backId", insertable = false, updatable = false)
    private Content content;

    @Column(unique = true, length = 10, nullable = false)
    private  String contentId; //코멘트 테이블 고유 어카운트

    @Column(length = 300, nullable = false)
    private String comment; //코멘트 내용

    @Column
    private  Long recommentId;   //대댓글

    @Column
    private LocalDateTime regDate; //코멘트 등록일

}
