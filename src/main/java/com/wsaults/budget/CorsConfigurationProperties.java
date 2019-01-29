package com.wsaults.budget;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "cors.allowed")
public class CorsConfigurationProperties {
  private List<String> domains;
  private List<String> headers;
  private List<String> exposed;
  private List<String> methods;

  public void setDomains(List<String> domains) {
    this.domains = domains;
  }

  public List<String> getDomains() {
    return this.domains;
  }

  public void setHeaders(List<String> headers) {
    this.headers = headers;
  }

  public List<String> getHeaders() {
    return this.headers;
  }

  public void setExposed(List<String> exposed) {
    this.exposed = exposed;
  }

  public List<String> getExposed() {
    return this.exposed;
  }
 
  public void setMethods(List<String> methods) {
    this.methods = methods;
  }

  public List<String> getMethods() {
    return this.methods;
  }
}