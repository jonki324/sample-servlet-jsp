package servlets.signup;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.dto.SignUpDto;

@WebServlet(name = "signup.ConfirmServlet", urlPatterns = { "/signup/confirm" })
public class ConfirmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ConfirmServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/WEB-INF/views/signup/confirm.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        SignUpDto dto = (SignUpDto) session.getAttribute("signUpDto");

        String path = "/sample-servlet-jsp/signup/complete";
        response.sendRedirect(path);
    }
}
