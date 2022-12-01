package com.example.javajeetutorial;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "WelcomeServlet", value = "/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("prenom");
        session.removeAttribute("nom");

        Cookie[] cookies = request.getCookies();
        if(cookies.length != 0){
            for (Cookie cookie : cookies)
            {
                    if(cookie.getName().equals("prenom"))
                        if (cookie.getValue().equals("romain"))
                            for (Cookie cookie2 : cookies){
                                if(cookie2.getName().equals("nom"))
                                    if (cookie2.getValue().equals("pasquier"))
                                        request.setAttribute("Student", new String[]{cookie.getValue(), cookie2.getValue()});
                            }
            }
        }
        else {
            System.out.println("no cookie");
        }
        request.getRequestDispatcher("/Welcome.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws IOException, ServletException {

        request.setAttribute("Error", true);

        String firstName= request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        Cookie cookie = new Cookie("prenom", firstName);
        Cookie cookie2 = new Cookie("nom", lastName);

        cookie.setMaxAge(15) ;
        cookie2.setMaxAge(15) ;

        response.addCookie(cookie);
        response.addCookie(cookie2);

        if(cookie.getName().equals("prenom")){
            if (cookie.getValue().equals("romain")){
                System.out.println("prenom bon");
                request.setAttribute("prenom", cookie.getValue()) ;
                    if(cookie2.getName().equals("nom")) {
                        if (cookie2.getValue().equals("pasquier")) {
                            System.out.println("nom bon");
                            request.setAttribute("prenom", cookie2.getValue());

                            HttpSession session = request.getSession();
                            session.setAttribute("prenom", firstName);
                            session.setAttribute("nom", lastName);

                            StudentControllerServlet studentControllerServlet = new StudentControllerServlet();
                            studentControllerServlet.doGet(request, response);

                            request.getRequestDispatcher("/list-students.jsp").forward(request, response);
                        }
                    }
            }
        }
        request.getRequestDispatcher("/Welcome.jsp").forward(request, response);
    }
}
