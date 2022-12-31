package com.Library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Library.dao.BookDao;
import com.Library.dao.ConnectionDao;


@WebServlet("/AddBooksServlet")
public class deleteBook extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			PrintWriter out = res.getWriter();
			//fetching id from servlet
			int id = Integer.parseInt(req.getParameter("id"));
			
			//Creating bookdao object
			BookDao bd  = new BookDao(ConnectionDao.getConnection());
			bd.deleteBook(id);
			res.sendRedirect("index.jsp");
			
			
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		
		
		
	}
	
	

}
