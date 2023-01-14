package com.panda.framework.config;

//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//
//@Configuration
//public class CrosConfig implements WebMvcConfigurer {
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:8080")
//                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
//                .allowCredentials(true)
//                .maxAge(3600)
//                .allowedHeaders("*");
//    }
//}




import com.panda.framework.util.CorsResponseHeaderFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.DefaultCorsProcessor;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * 网关跨域配置
 */
@Configuration
public class CrosConfig {
    @Bean
    public CorsResponseHeaderFilter corsResponseHeaderFilter() {
        return new CorsResponseHeaderFilter();
    }

    @Bean
    public CorsWebFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        source.registerCorsConfiguration("/**", buildCorsConfiguration());

        CorsWebFilter corsWebFilter = new CorsWebFilter(source, new DefaultCorsProcessor() {
            @Override
            protected boolean handleInternal(ServerWebExchange exchange, CorsConfiguration config,
                                             boolean preFlightRequest)
            {
                // 预留扩展点
                // if (exchange.getRequest().getMethod() == HttpMethod.OPTIONS) {
                return super.handleInternal(exchange, config, preFlightRequest);
                // }

                // return true;
            }
        });

        return corsWebFilter;
    }

    private CorsConfiguration buildCorsConfiguration() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");

        corsConfiguration.addAllowedMethod(HttpMethod.OPTIONS);
        corsConfiguration.addAllowedMethod(HttpMethod.POST);
        corsConfiguration.addAllowedMethod(HttpMethod.GET);
        corsConfiguration.addAllowedMethod(HttpMethod.PUT);
        corsConfiguration.addAllowedMethod(HttpMethod.DELETE);
        corsConfiguration.addAllowedMethod(HttpMethod.PATCH);
        // corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");


        corsConfiguration.setMaxAge(7200L);
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }
}


















