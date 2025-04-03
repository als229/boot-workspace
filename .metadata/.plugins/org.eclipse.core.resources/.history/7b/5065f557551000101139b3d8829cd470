package com.kh.start.comments.model.vo;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Comment {
	private Long commentNo;
	@NotBlank(message="댓글이 비어있다?")
	private String commentContent;
	private Long commentWriter;
	private Date createDate;
	private Long refBoardNo;
}
