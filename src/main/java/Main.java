import com.sondahum.servlet.config.MyAppConfig;
import com.sondahum.servlet.config.MyWebConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Arrays;
import java.util.List;


public class Main implements WebApplicationInitializer/*extends AbstractAnnotationConfigDispatcherServletInitializer*/ {

    public static void main(String[] args) {

    }

    @Override
    public void onStartup(ServletContext rootContext) throws ServletException { // todo 이 onStartup메소드가 기냥 web.xml과 내용이 똑같구만..!!
        // 착각하지 말자 rootContext는 WAS의 Servlet Container이고 밑에 만든 servletContext는 Spring의 IoC Container이다.
        AnnotationConfigWebApplicationContext springContext = new AnnotationConfigWebApplicationContext();
        springContext.setServletContext(rootContext);

        springContext.register(MyWebConfig.class); // servlet-context
        springContext.refresh();

        DispatcherServlet dispatcher = new DispatcherServlet(springContext);
        ServletRegistration.Dynamic registration = rootContext.addServlet("dispatcher", dispatcher);
        registration.addMapping("/");
    }

//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class[0];
//    }
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class<?>[] {MyWebConfig.class};
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[0];
//    }
}
