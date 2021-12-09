package com.dcp.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dcp.example.domain.Board;
import com.dcp.example.domain.Search;

@Mapper
public interface BoardMapper {
	public List<Board> selectBoardList();
	
	public Board readBoard(Board borad);
		
	public void plusViews(Board board);
	
	public void writeBoard(Board board);
	
	public void setUpOriginal();
	
	public void setUpReplace1(Board board);
	
	public void setUpReplace2(Board board);
	
	public void deleteBoard(Board board);
	
	public void adjustBoard(Board board);
	
	public List<Board> searchBoard(Search search);
}
