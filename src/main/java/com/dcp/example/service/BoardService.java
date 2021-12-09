package com.dcp.example.service;

import java.util.List;
import com.dcp.example.domain.Board;
import com.dcp.example.domain.Search;

public interface BoardService {
	public List<Board> selectBoardList();
	
	public Board readBoard(Board borad);
	
	public void plusViews(Board board);
	
	public void writeBoard(Board board);
		
	public void rewriteBoard(Board board);
	
	public void deleteBoard(Board board);
	
	public void adjustBoard(Board board);
	
	public List<Board> searchBoard(Search search);
}
