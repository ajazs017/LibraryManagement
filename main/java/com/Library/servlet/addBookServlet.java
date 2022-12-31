package com.Library.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Library.bean.Book_Bean;
import com.Library.dao.BookDao;
import com.Library.dao.ConnectionDao;

@WebServlet("/AddBooksServlet")
public class addBookServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	{
		try {
			PrintWriter out = res.getWriter();
			String bname = req.getParameter("bookname");
			String  bdesc= req.getParameter("bookdesc");
			String aname = req.getParameter("authorname");
			String category = req.getParameter("category");
			
		
			
			Book_Bean b = new Book_Bean(bname,bdesc,aname,category);
			
			try {
				BookDao bd = new BookDao(ConnectionDao.getConnection());
				if(bd.addBooks(b))
				{
				res.sendRedirect("index.jsp");
				}
				else
				{
					out.print("Something Went Wrong..!!!");
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
