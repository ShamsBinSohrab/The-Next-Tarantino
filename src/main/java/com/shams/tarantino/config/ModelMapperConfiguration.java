package com.shams.tarantino.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {

  @Bean
  public ModelMapper modelMapper() {
    var mapper = new ModelMapper();
    //    mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    return mapper;
  }
}
