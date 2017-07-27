package Config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by Administrator on 2017/7/20.
 */
@Configuration
@Import({ShiroConfig.class,MailConfig.class})
@ImportResource(value = {"classpath:rabbitmq-config.xml"})
@PropertySource("classpath:rabbitmq-config.properties")
@PropertySource("classpath:mail.properties")
@ComponentScan(basePackages = {"service","listener"})
public class RootConfig {

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
