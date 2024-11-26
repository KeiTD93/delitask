package hvnh.delitask_serverapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Áp dụng cho tất cả các endpoint
                        .allowedOrigins("*") // Cho phép các domain này
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Phương thức HTTP được phép
                        .allowedHeaders("*") // Cho phép tất cả các header
                        .allowCredentials(false); // Cho phép gửi cookie hoặc thông tin xác thực
            }
        };
    }
}