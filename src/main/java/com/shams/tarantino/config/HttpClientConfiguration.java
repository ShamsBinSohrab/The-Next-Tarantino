package com.shams.tarantino.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.shaded.okhttp3.OkHttpClient;

@Configuration
public class HttpClientConfiguration {

  @Bean
  public OkHttpClient httpClient() {
    return new OkHttpClient.Builder().build();
  }
}
