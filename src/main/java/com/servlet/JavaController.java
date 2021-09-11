package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Student;
import com.entity.Subject;
import com.util.HibernateUtil;

/**
 * Servlet implementation class JavaController
 */
@WebServlet("/java-full-stack")
public class JavaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JavaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session sessionHb = null;
		
		try {
		 sessionHb = sf.openSession();
		 sessionHb.beginTransaction();
		   
		 Query q1 = sessionHb.createQuery("from Subject where class_id = 10001");
		 List <Subject> subList = (List <Subject>) q1.list();
		 
		 Query q2 = sessionHb.createQuery("from Student where class_id = 10001");
		 List <Student> stdList = (List<Student>) q2.list();
		 
		 
		 request.setAttribute("subList", subList);
		 request.setAttribute("stdList", stdList);
		 
		 sessionHb.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (sessionHb != null) {
				sessionHb.close();
			}
		}
        
		RequestDispatcher rd = request.getRequestDispatcher("show-class.jsp");
		rd.forward(request, response);
	}

}
