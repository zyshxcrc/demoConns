package Config;

import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * Created by Administrator on 2017/7/20.
 */
public class ConnWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[] {
                new DelegatingFilterProxy("shiroFilter")
        };
    }
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {/*设置dispatcherServlet属性*/
        registration.setMultipartConfig(new MultipartConfigElement(null,52428800,52428800,0));
        registration.setAsyncSupported(true);
        //registration.setLoadOnStartup(3);
        //registration.setInitParameter();
    }
}
