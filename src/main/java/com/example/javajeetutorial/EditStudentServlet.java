package com.example.javajeetutorial;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "EditStudentServlet", value = "/EditStudentServlet")
public class EditStudentServlet extends HttpServlet {
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        id = Integer.parseInt(request.getParameter("studentId"));
        Student student = studentDbUtil.fetchStudent(id);
        request.setAttribute("Student", student);
        request.getRequestDispatcher("edit-student.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String fn= request.getParameter("firstName");
        String ln= request.getParameter("lastName");
        String email = request.getParameter("email");
        Student student = new Student(id,fn,ln,email);
        studentDbUtil.updateStudent(student);
        response.sendRedirect("StudentControllerServlet");
    }
}