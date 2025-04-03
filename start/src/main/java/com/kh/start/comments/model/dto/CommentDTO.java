package com.kh.start.comments.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommentDTO {
	private Long commentNo;
	private String commentContent;
	private String commentWriter;
	private Date createDate;
	private Long refBoardNo;
}
