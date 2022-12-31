package com.Library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Library.bean.Book_Bean;

public class BookDao {
	Connection con;

	public BookDao(Connection con) {
		this.con = con;
	}
	
	public boolean addBooks(Book_Bean book)
	{
		boolean test = false;
		String query = "insert into books(bname,bdesc,aname,category) values(?,?,?,?)";
		
		try {
			PreparedStatement psmt = this.con.prepareStatement(query);
			//psmt.setInt(1, book.getId());
			psmt.setString(1, book.getBookName());
			psmt.setString(2, book.getBookDesc());
			psmt.setString(3, book.getAuthName());
			psmt.setString(4, book.getCategory());
			
			psmt.executeUpdate();
			test=true;	 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return test;
	}
	
	public List<Book_Bean> getAllBooks()
	{
		List<Book_Bean> b = new ArrayList<>();
		
		try {
			String query = "select * from books";
			PreparedStatement psmt = this.con.prepareStatement(query);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next())
			{
				int id = rs.getInt("id");
				String name = rs.getString("bname");
				String desc = rs.getString("bdesc");
				String author = rs.getString("aname");
				String category = rs.getString("category");
				
				Book_Bean bk = new Book_Bean(id,name,desc,author,category);
				b.add(bk);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return b;
	}
	
	//Getting Single Book by Id
	
	public Book_Bean getSingleBook(int id)
	{
		Book_Bean b = null;
		try {
			String query = "select * from books where id = ?";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next())
			{
				
				int bid = rs.getInt("id");
				String bname = rs.getString("bname");
				String bdesc = rs.getString("bdesc");
				String bauthor = rs.getString("aname");
				String bcategory = rs.getString("category");
				b = new Book_Bean(id,bname,bdesc,bauthor,bcategory);
			}
			
			//b.add(bk);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}
	
	
	
	public boolean editBookInfo(Book_Bean b)
	{
		boolean test = true;
		try {
			String query = "update books set bname = ?,bdesc = ?,aname=?,category = ? where id = ?";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setString(1, b.getBookName());
			psmt.setString(2, b.getBookDesc());
			psmt.setString(3, b.getAuthName());
			psmt.setString(4, b.getCategory());
			psmt.setInt(5, b.getId());
			
			psmt.executeUpdate();
			test = true;
			
			
		}
		catch(Exception e)
		{
			
		}
		return test;
	}
	
	//Delete book from database
	
	public void deleteBook(int id) throws SQLException
	{
		try {
			String query = "delete from books where id = ?";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setInt(1, id);
			psmt.executeQuery();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
