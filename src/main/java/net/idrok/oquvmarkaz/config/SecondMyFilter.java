//package net.idrok.oquvmarkaz.config;
//
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//@Order(2)
//public class SecondMyFilter  implements Filter {
//    @Override
//    public void doFilter(
//            ServletRequest servletRequest,
//            ServletResponse servletResponse,
//            FilterChain filterChain) throws IOException, ServletException {
//        System.out.println(2);
//        HttpServletResponse hsrp = (HttpServletResponse) servletResponse;
//        hsrp.setHeader("xabar", "alladim");
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//}
