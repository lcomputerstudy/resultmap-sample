package com.dcp.example.domain;

public class Comment {
	private int cMaster;
	private int cId;
	private String cContentall;
	private String cContent;
	private String cWriter;
	private String cDateTime;
	private int cGroup;
	private int cDepth;
	private int cOrder;
	private User user;
	private Board board;
	
	public int getcMaster() {
		return cMaster;
	}
	public void setcMaster(int cMaster) {
		this.cMaster = cMaster;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcContentall() {
		return cContentall;
	}
	public void setcContentall(String cContentall) {
		this.cContentall = cContentall;
	}
	public String getcContent() {
		return cContent;
	}
	public void setcContent(String cContent) {
		this.cContent = cContent;
	}
	public String getcWriter() {
		return cWriter;
	}
	public void setcWriter(String cWriter) {
		this.cWriter = cWriter;
	}
	public String getcDateTime() {
		return cDateTime;
	}
	public void setcDateTime(String dateTime) {
		cDateTime = dateTime;
	}
	public int getcGroup() {
		return cGroup;
	}
	public void setcGroup(int cGroup) {
		this.cGroup = cGroup;
	}
	public int getcDepth() {
		return cDepth;
	}
	public void setcDepth(int cDepth) {
		this.cDepth = cDepth;
	}
	public int getcOrder() {
		return cOrder;
	}
	public void setcOrder(int cOrder) {
		this.cOrder = cOrder;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}

}
