package com.example.javajeetutorial;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentControllerServlet", value = "/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {

    private StudentDBUtil studentDBUtil;
    private DataSource dataSource;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    private DataSource getDataSource() throws NamingException {
        String jndi="java:comp/env/jdbc/studentdb" ;
        Context context = new InitialContext();
        return (DataSource) context.lookup(jndi);
    }
    @Override
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        super.init();
        try {
            dataSource = getDataSource();
            studentDBUtil = new StudentDBUtil(dataSource);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            listStudents(request,response);
        } catch (Exception e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private void listStudents(HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        init();
        List<Student> students = studentDBUtil.getStudents();
        request.setAttribute("STUDENT_LIST", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
        dispatcher.forward(request, response);
    }
}
