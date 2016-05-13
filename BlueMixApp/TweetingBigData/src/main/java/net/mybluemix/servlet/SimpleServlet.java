package net.mybluemix.servlet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/getQueries")
public class SimpleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HttpSession session;
    private List<Query> queries;
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
    	session = request.getSession(true);
    	
    	PrintWriter out = response.getWriter();
    	out.println("<html>");
    	
    	out.println("<body bgcolor=\"white\">");
    	
    	out.println("<head>");
    	out.println("<title>Big Data Queries</title>");
    	out.println("</head>");
 
    	out.println("<body>");
    	try
    	{
	    	QueriesMain mainQuery = new QueriesMain();
	    	mainQuery.main(null);
	    	queries = mainQuery.getQueries();
	    	
	    	for (Query query : queries)
	    	{
	    		out.println("<input type=\"submit\" value=\""+query.getLabel()+"\""
	    				+ " onclick=\"window.open('"+response.encodeURL(query.getURL())+"')\">");
	    		out.println("<br>");
	    	}
	    	
	       	out.println("</body>");
	    	out.println("</html>");
	    	out.close();
    	}
    	catch (Exception e)
    	{
    		for (Query query : queries)
	    	{
	    		out.println("<input type=\"submit\" value=\""+query.getLabel()+"\""
	    				+ " onclick=\"window.open('"+response.encodeURL(query.getURL())+"')\">");
	    		out.println("<br>");
	    	}
	    	
	       	out.println("</body>");
	    	out.println("</html>");
	    	out.close();
    	}
    }  
}
