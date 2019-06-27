package filter;

import beans.UsuarioBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(urlPatterns = {"/admin/*"})
public class AuthorizationFilter implements Filter {

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession sessao = req.getSession(true);
        UsuarioBean usuarioBean = (UsuarioBean) sessao.getAttribute("usuarioSMB");
        if (usuarioBean == null || usuarioBean.getUsuario() == null) {
            resp.sendRedirect(req.getContextPath() + "/public/login.jsf");
        } else {
            chain.doFilter(req, resp);
        }
    }

}
