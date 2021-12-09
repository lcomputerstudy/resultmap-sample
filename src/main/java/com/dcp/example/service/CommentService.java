package com.dcp.example.service;

import java.util.List;

import com.dcp.example.domain.Board;
import com.dcp.example.domain.Comment;

public interface CommentService {
	public List<Comment> selectCommentList(Comment comment);
	
	public void writeComment(Comment comment);
	
	public void rewriteComment(Comment comment);

}
