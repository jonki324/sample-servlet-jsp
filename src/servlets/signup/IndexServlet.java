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
import models.dxo.SignUpDxo;

@WebServlet(name = "signup.IndexServlet", urlPatterns = { "/signup/index" })
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public IndexServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        SignUpDto dto = (SignUpDto) session.getAttribute("signUpDto");
        if (dto == null) {
            // 初回画面表示
            dto = new SignUpDto();
            session.setAttribute("signUpDto", dto);
        }

        String path = "/WEB-INF/views/signup/index.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // パラメータの詰め替え
        SignUpDto dto = SignUpDxo.convert(request);
        HttpSession session = request.getSession();
        session.setAttribute("signUpDto", dto);

        String path = "/sample-servlet-jsp/signup/confirm";
        response.sendRedirect(path);
    }
}
