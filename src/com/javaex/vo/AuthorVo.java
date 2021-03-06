package com.javaex.vo;

public class AuthorVo {
	
	private int authorId;
	private String authorName;
	private String authorDesc;
	
	public AuthorVo() {}
	
	public AuthorVo(int authorId) {//delete할때 쓸려고 내가 만듬
		this.authorId = authorId;
	}
	
	public AuthorVo(String authorName, String authorDesc) {//insert할떄
		this.authorName = authorName;
		this.authorDesc = authorDesc;
	}
	
	public AuthorVo(int authorId, String authorName, String authorDesc) {//update할때
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorDesc = authorDesc;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorDesc() {
		return authorDesc;
	}
	public void setAuthorDesc(String authorDesc) {
		this.authorDesc = authorDesc;
	}
	@Override
	public String toString() {
		return "AuthorVo [authorId=" + authorId + ", authorName=" + authorName + ", authorDesc=" + authorDesc + "]";
	}
	
	
}
