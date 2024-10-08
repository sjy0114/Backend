package NewJeans.FanCm.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Content")
@Getter @Setter
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long backId;   //사용자 고유 어카운트

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private Member member;

    @Column(unique = true, length = 10, nullable = false)
    private String id;  //사용자 어카운트

    @Column(length = 50, nullable = false)
    private String title;  //cm 게시글 제목

    @Column(length = 5000, nullable = false)
    private String content;    //cm 게시글 내용

    @Column(length = 80)
    private String attachment; //cm 게시글 첨부파일

    @Column
    private LocalDateTime regDate;   //게시글 작성일

    @Column
    private LocalDateTime updateDate;   //게시글 수정일
    
    @Enumerated(EnumType.STRING)
    private EnumContent genre;   //장르


}
