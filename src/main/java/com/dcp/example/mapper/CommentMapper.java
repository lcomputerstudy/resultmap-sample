package com.dcp.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dcp.example.domain.Comment;

@Mapper
public interface CommentMapper {
	public List<Comment> selectCommentList(Comment comment);
	
	public void writeComment(Comment comment);
	
	public void setUpOriginal();
	
	public void setUpReplace1(Comment comment);
	
	public void setUpReplace2(Comment comment);
}
