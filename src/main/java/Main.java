import com.sondahum.servlet.servlet1.service.MyService1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import com.sondahum.servlet.servlet1.config.MyConfig1;
import com.sondahum.servlet.servlet2.config.MyConfig2;
import com.sondahum.servlet.servlet3.config.MyConfig3;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import java.util.Arrays;
import java.util.List;


public class Main extends AbstractAnnotationConfigDispatcherServletInitializer {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");


        String[] ctxs = {"applicationContext.xml", "config-context.xml", "servlet1-context.xml", "servlet2-context.xml", "servlet3-context.xml"};
        GenericXmlApplicationContext moduleCtx = new GenericXmlApplicationContext(ctxs);
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MyConfig1.class);

        MyConfig1 myConfig1 =
        ctx.getBean("config1", MyConfig1.class);


        // myService1은 MyRepository1을 주입받은 상태로 생성된다!!!
        MyService1 myService1 =
        ctx.getBean("service1", MyService1.class);


        ctx.close();
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }
}
