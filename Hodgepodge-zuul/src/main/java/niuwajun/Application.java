package niuwajun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import niuwajun.filter.TokenFilter;

@SpringBootApplication
@EnableZuulProxy
public class Application{
 
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
    
    //将过滤器交给Spring管理
    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }

}
