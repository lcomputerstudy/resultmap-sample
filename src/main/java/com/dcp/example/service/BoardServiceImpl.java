package com.dcp.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcp.example.domain.Board;
import com.dcp.example.domain.Search;
import com.dcp.example.mapper.BoardMapper;

@Service("BoardServiceImpl")
public class BoardServiceImpl implements BoardService {
	
	@Autowired BoardMapper boardmapper;
	
	@Override
	public List<Board> selectBoardList() {
		return boardmapper.selectBoardList();
	}
	
	@Override
	public Board readBoard(Board board) {
		return boardmapper.readBoard(board);
	}
	
	@Override
	public void plusViews(Board board){
		boardmapper.plusViews(board);
	}
	
	@Override
	public void writeBoard(Board board){
		boardmapper.writeBoard(board);
		boardmapper.setUpOriginal();
		
	}
	
	@Override
	public void rewriteBoard(Board board){
		boardmapper.setUpReplace1(board);
		boardmapper.writeBoard(board);
		boardmapper.setUpReplace2(board);
	}
	
	@Override
	public void deleteBoard(Board board){
		boardmapper.deleteBoard(board);
	}
	
	@Override
	public void adjustBoard(Board board){
		boardmapper.adjustBoard(board);
	}
	
	@Override
	public List<Board> searchBoard(Search search){
		return boardmapper.searchBoard(search);
	}
}
