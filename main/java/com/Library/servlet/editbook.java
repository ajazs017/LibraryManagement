package com.Library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Library.bean.Book_Bean;
import com.Library.dao.BookDao;
import com.Library.dao.ConnectionDao;


@WebServlet("/EditBooksServlet")
public class editbook extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			PrintWriter out = res.getWriter();
			
			//Fetching the data
			int id=Integer.parseInt(req.getParameter("bid"));
			String name = req.getParameter("bname");
			String desc = req.getParameter("bdesc");
			String author = req.getParameter("authorname");
			String cat = req.getParameter("category");
			
			//create a book object
			Book_Bean b = new Book_Bean();
			b.setBookName(name);
			b.setBookDesc(desc);
			b.setAuthName(author);
			b.setCategory(cat);
			b.setId(id);
			
			//Creating object of dao
			
			BookDao bk = new BookDao(ConnectionDao.getConnection());
			 boolean success = bk.editBookInfo(b);
			 if(success)
			 {
				 res.sendRedirect("index.jsp");
			 }
			 else
			 {
				 out.print("Something went wrong");
			 }
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	
	

}
