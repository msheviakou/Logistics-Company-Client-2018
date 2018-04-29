package edu.bsuir;

import edu.bsuir.filter.Filter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class LogisticsCompanyClientApplication {

    public static void main(String[] args) { SpringApplication.run(LogisticsCompanyClientApplication.class, args); }

    @Bean
    public Filter filter() {
        return new Filter();
    }
}
