package Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Administrator on 2017/7/20.
 */
@Configuration
@Import({ShiroConfig.class})
public class RootConfig {
}
