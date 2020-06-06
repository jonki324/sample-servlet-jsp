package servlets.signup;

import java.io.IOException;

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
import models.dxo.UserDxo;
import models.services.UserService;

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
        SignUpDto signUpDto = (SignUpDto) session.getAttribute("signUpDto");
        // 入力からユーザーデータへ詰め替え
        UserDto userDto = UserDxo.convert(signUpDto);
        // ユーザーの登録処理
        UserService service = new UserService();
        int result = service.add(userDto);
        String path = "";
        if (result > 0) {
            // 登録したユーザーのID,Nameをセッションに保存しログイン管理に使用する
            session.setAttribute("signInUserDto", new SignInUserDto(result, userDto.getName()));
            // 登録完了画面へ遷移する
            signUpDto.setMessage("success");
            path = "/sample-servlet-jsp/signup/complete";
        } else {
            // 登録エラーのため登録確認画面へ戻りメッセージを表示する
            signUpDto.setMessage("error");
            path = "/sample-servlet-jsp/signup/confirm";
        }
        response.sendRedirect(path);
    }
}
