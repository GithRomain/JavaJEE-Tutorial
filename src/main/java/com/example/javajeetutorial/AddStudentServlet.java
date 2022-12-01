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

@WebServlet(name = "AddStudentServlet", value = "/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    private StudentDBUtil studentDbUtil;

    private DataSource dataSource;
    int id;

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
            studentDbUtil = new StudentDBUtil(dataSource);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/add-student.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String fn= request.getParameter("firstName");
        String ln= request.getParameter("lastName");
        String email = request.getParameter("email");
        try {
            id = studentDbUtil.getStudents().size();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Student student = new Student(id,fn,ln,email);
        studentDbUtil.addStudent(student);
        response.sendRedirect("StudentControllerServlet");
    }
}
