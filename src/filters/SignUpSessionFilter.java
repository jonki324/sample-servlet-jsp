package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.dto.SignUpDto;

@WebFilter({ "/signup/confirm", "/signup/complete" })
public class SignUpSessionFilter implements Filter {

    public SignUpSessionFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        if (session != null) {
            SignUpDto dto = (SignUpDto) session.getAttribute("signUpDto");
            if (dto != null) {
                chain.doFilter(request, response);
                return;
            }
        }
        String path = "/sample-servlet-jsp/signin/index";
        ((HttpServletResponse) response).sendRedirect(path);
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }
}
