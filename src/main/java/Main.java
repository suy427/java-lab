import com.sondahum.config.MyConfig1;
import com.sondahum.config.MyConfig2;
import com.sondahum.config.MyConfig3;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



public class Main extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {MyConfig1.class, MyConfig2.class, MyConfig3.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }
}
