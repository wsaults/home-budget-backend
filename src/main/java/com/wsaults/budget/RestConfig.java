package com.wsaults.budget;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class RestConfig {

  private CorsConfigurationProperties corsConfigurationProperties;

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
      source.registerCorsConfiguration("/**", config);
      return new CorsFilter(source);
  }
}