package servlets.signin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.dto.SignInUserDto;
import models.dto.SignUpDto;
import models.dto.UserDto;
import models.dxo.SignUpDxo;
import models.services.UserService;

@WebServlet(name = "signin.IndexServlet", urlPatterns = { "/signin/index" })
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public IndexServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        SignUpDto dto = (SignUpDto) session.getAttribute("signInDto");
        if (dto == null) {
            // 初回画面表示
            dto = new SignUpDto();
            session.setAttribute("signInDto", dto);
        }
        String path = "/WEB-INF/views/signin/index.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // パラメータの詰め替え
        SignUpDto dto = SignUpDxo.convert(request);
        HttpSession session = request.getSession();
        // サインイン確認
        UserService service = new UserService();
        List<UserDto> result = service.isValidSignIn(dto.getName(), dto.getEmail());
        String path = "";
        if (result != null && result.size() == 1) {
            // 登録したユーザーのID,Nameをセッションに保存しログイン管理に使用する
            session.setAttribute("signInUserDto", new SignInUserDto(result.get(0).getId(), result.get(0).getName()));
            session.removeAttribute("signInDto");
            // Top画面へ遷移する
            path = "/sample-servlet-jsp/top/index";
        } else {
            // エラーのためサインイン画面へ戻りメッセージを表示する
            dto.setMessage("error");
            session.setAttribute("signInDto", dto);
            path = "/sample-servlet-jsp/signin/index";
        }
        response.sendRedirect(path);
    }
}
