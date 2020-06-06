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

@WebServlet(name = "signup.CompleteServlet", urlPatterns = { "/signup/complete" })
public class CompleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CompleteServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        SignUpDto dto = (SignUpDto) session.getAttribute("signUpDto");
        String message = dto.getMessage();
        session.removeAttribute("signUpDto");

        request.setAttribute("message", message);

        String path = "/WEB-INF/views/signup/complete.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
