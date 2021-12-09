package com.dcp.example.domain;

public class Board {
	
	private int bId;
	private String bTitle;
	private String bTitleall;
	private String bContent;
	private String bWriter;
	private String bDateTime;
	private int bViews;
	private int bGroup;
	private int bOrder;
	private int bDepth;
	private int bRownum;
	private User user;
	
	
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbTitleall() {
		return bTitleall;
	}
	public void setbTitleall(String bTitleall) {
		this.bTitleall = bTitleall;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public String getbWriter() {
		return bWriter;
	}
	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}
	public String getbDateTime() {
		return bDateTime;
	}
	public void setbDateTime(String bDateTime) {
		this.bDateTime = bDateTime;
	}
	public int getbViews() {
		return bViews;
	}
	public void setbViews(int bViews) {
		this.bViews = bViews;
	}
	public int getbGroup() {
		return bGroup;
	}
	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}
	public int getbOrder() {
		return bOrder;
	}
	public void setbOrder(int bOrder) {
		this.bOrder = bOrder;
	}
	public int getbDepth() {
		return bDepth;
	}
	public void setbDepth(int bDepth) {
		this.bDepth = bDepth;
	}
	public int getbRownum() {
		return bRownum;
	}
	public void setbRownum(int bRownum) {
		this.bRownum = bRownum;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
