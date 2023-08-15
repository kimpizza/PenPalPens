package com.penpalpens.penpalpens.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@DynamicInsert
@Table(name = "Diary")
public class Diary {
    // 개인 다이어리
    // 글 번호, 글 제목, 글 내용, 글 작성자(모든 정보), 글 작성일자
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "diarySeq")
    @SequenceGenerator(name = "diarySeq", sequenceName = "diarySeq", allocationSize = 1)
    private int dIdx;

    @Column(nullable = true, length = 300)
    private String dTitle;

    @Column(nullable = true, length = 3000)
    private String dContent;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uEmail")
    private UserInfo userInfoVO;

    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime dDate;
}
