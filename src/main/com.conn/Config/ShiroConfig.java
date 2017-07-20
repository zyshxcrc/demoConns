package Config;

import dao.MyRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public MyRealm myRealm(){
        return new MyRealm();
    }
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        defaultSecurityManager.setRealm(myRealm());
        return defaultSecurityManager;
    }
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }
    @Bean
    public MethodInvokingFactoryBean methodInvokingFactoryBean(){
        MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
        methodInvokingFactoryBean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
        methodInvokingFactoryBean.setArguments(new Object[]{securityManager()});

        return methodInvokingFactoryBean;
    }
    @Bean
    @DependsOn(value="lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        return new DefaultAdvisorAutoProxyCreator();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return authorizationAttributeSourceAdvisor;
    }


    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        /*1.设置Realm extends AuthorizingRealm
        * 2.设置SecurityManager 设置 realms
        * 3.设置ShiroFilterFactoryBean web.xml delegatingFilterProxy filter_name 设置 SecurityManager ShiroFilterChain
        * 4.设置LifeCycleBeanPostProcessor
        * 5.设置MethodInvokingFactoryBean SecurityUtils.setSecurityManager()*/
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> shirFilterChainMap = new HashMap<>();
        shirFilterChainMap.put("/login.jsp","anon");
        /*shirFilterChainMap.put("*//*","authc");*/
        shiroFilterFactoryBean.setLoginUrl("/login.jsp");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index.jsp");

        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/error.jsp");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(shirFilterChainMap);
        return shiroFilterFactoryBean;
    }
}
