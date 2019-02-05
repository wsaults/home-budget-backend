package com.wsaults.budget;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import java.util.*;

@Configuration
public class RestConfig extends WebSecurityConfigurerAdapter {

  private CorsConfigurationProperties corsConfigurationProperties;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
      http.cors();
      http.csrf().disable();
  }

  public RestConfig(CorsConfigurationProperties corsConfigurationProperties) {
    this.corsConfigurationProperties = corsConfigurationProperties;
  }

  @Bean
  public CorsFilter corsFilter() {
      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      CorsConfiguration config = new CorsConfiguration();
      
      // config.setAllowedHeaders(corsConfigurationProperties.getHeaders());
      // List<String> domains = new ArrayList<>(Arrays.asList("*"));
      List<String> headers = new ArrayList<>(Arrays.asList("Origin", "Accept", "X-Requested-With", "Content-Type", "Access-Control-Request-Methods", "Access-Control-Request-Headers", "Authorization", "Access-Control-Allow-Origin"));
      List<String> methods = new ArrayList<>(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
      
      // config.setAllowedOrigins(domains);
      // config.setAllowedHeaders(headers);
      // config.setAllowedMethods(methods);
      config.addAllowedOrigin("*");
      config.addAllowedHeader("*");
      config.addAllowedMethod("*");
      source.registerCorsConfiguration("/**", config);
      return new CorsFilter(source);
  }
}