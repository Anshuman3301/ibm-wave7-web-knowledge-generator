package com.stackroute.configuration;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
        import org.springframework.kafka.core.DefaultKafkaProducerFactory;
        import org.springframework.kafka.core.KafkaTemplate;
        import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
    @Configuration
    public class ProducerConfig {
        @Bean
        public ProducerFactory<String,String> producerFactory() {
            LinkedHashMap<String, Object> config = new LinkedHashMap<>();
            config.put(org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
            config.put(org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
            config.put(org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
            return new DefaultKafkaProducerFactory<>(config);
        }
        @Bean
        public KafkaTemplate<String,String> kafkaTemplate()
        {
            return new KafkaTemplate<>(producerFactory());
        }
    }

