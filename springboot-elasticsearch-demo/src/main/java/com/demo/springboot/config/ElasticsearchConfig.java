package com.demo.springboot.config;

import lombok.val;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;

@Configuration
public class ElasticsearchConfig {

    @Bean
    RestHighLevelClient clientConfiguration() {
        val config = ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .build();
        return RestClients.create(config).rest();
    }

}
