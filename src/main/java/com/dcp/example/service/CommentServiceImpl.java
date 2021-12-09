package com.dcp.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcp.example.domain.Board;
import com.dcp.example.domain.Comment;
import com.dcp.example.mapper.CommentMapper;

@Service("CommentServiceImpl")
public class CommentServiceImpl implements CommentService {
	
	@Autowired CommentMapper commentmapper;
	
	@Override
	public List<Comment> selectCommentList(Comment comment) {
		return commentmapper.selectCommentList(comment);
	}
	
	@Override
	public void writeComment(Comment comment) {
		commentmapper.writeComment(comment);
		
		commentmapper.setUpOriginal();
	}
	
	@Override
	public void rewriteComment(Comment comment) {
		commentmapper.setUpReplace1(comment);
		commentmapper.writeComment(comment);
		commentmapper.setUpReplace2(comment);
	}
}
