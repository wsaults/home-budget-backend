package com.wsaults.budget;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class RestConfig extends WebSecurityConfigurerAdapter {

  private CorsConfigurationProperties corsConfigurationProperties;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
      http.cors();
  }

  public RestConfig(CorsConfigurationProperties corsConfigurationProperties) {
    this.corsConfigurationProperties = corsConfigurationProperties;
  }

  @Bean
  public CorsFilter corsFilter() {
      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      CorsConfiguration config = new CorsConfiguration();
      config.setAllowedOrigins(corsConfigurationProperties.getDomains());
      config.setAllowedHeaders(corsConfigurationProperties.getHeaders());
      config.setAllowedMethods(corsConfigurationProperties.getMethods());
      config.setAllowCredentials(true);
      config.addAllowedOrigin("*");
      source.registerCorsConfiguration("/**", config);
      return new CorsFilter(source);
  }
}