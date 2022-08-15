//package net.idrok.oquvmarkaz.config;
//
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//@Order(2)
//public class MyFilter  implements Filter {
//
//
//    @Override
//    public void doFilter(
//            ServletRequest servletRequest,
//            ServletResponse servletResponse,
//            FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("1");
//        HttpServletRequest hsr = (HttpServletRequest) servletRequest;
//        HttpServletResponse hsrp = (HttpServletResponse) servletResponse;
//        String login = hsr.getHeader("login");
//        System.out.println(login);
//        if (login != null && login.equals("admin")){
//            hsrp.setHeader("status", "malades");
//            filterChain.doFilter(servletRequest, servletResponse);
//        }else{
//            hsrp.setHeader("status", "adashding");
//        }
//    }
//}
