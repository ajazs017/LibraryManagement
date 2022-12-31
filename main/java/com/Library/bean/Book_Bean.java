package com.Library.bean;

public class Book_Bean {
private int id;
private String bookName,bookDesc,authName,category;



public Book_Bean() {
	
}


public Book_Bean(int id, String bookName, String bookDesc, String authName, String category) {
	
	this.id = id;
	this.bookName = bookName;
	this.bookDesc = bookDesc;
	this.authName = authName;
	this.category = category;
}


public Book_Bean(String bookName, String bookDesc, String authName, String category) {
	
	this.bookName = bookName;
	this.bookDesc = bookDesc;
	this.authName = authName;
	this.category = category;
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
public String getBookDesc() {
	return bookDesc;
}
public void setBookDesc(String bookDesc) {
	this.bookDesc = bookDesc;
}
public String getAuthName() {
	return authName;
}
public void setAuthName(String authName) {
	this.authName = authName;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}


@Override
public String toString() {
	return "Book_Bean [id=" + id + ", bookName=" + bookName + ", bookDesc=" + bookDesc + ", authName=" + authName
			+ ", category=" + category + "]";
}








}
