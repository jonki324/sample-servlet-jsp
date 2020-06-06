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

import models.dto.SignInUserDto;

@WebFilter("/top/*")
public class SignInFilter implements Filter {

    public SignInFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        boolean isValid = false;
        HttpSession session = ((HttpServletRequest) request).getSession();
        if (session != null) {
            SignInUserDto dto = (SignInUserDto) session.getAttribute("signInUserDto");
            if (dto != null && dto.getId() != null && dto.getName() != null) {
                isValid = true;
            }
        }

        if (isValid) {
            chain.doFilter(request, response);
        } else {
            String path = "/sample-servlet-jsp/signin/index";
            ((HttpServletResponse) response).sendRedirect(path);
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }
}
