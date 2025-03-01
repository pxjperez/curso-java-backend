package edu.cibertec.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration //Esta configuracion es la misma que se hizo en el properties
public class KafkaConfig {

    @Value("${kafka.server}")
    private String kafkaServer;

    @Bean
    public ConsumerFactory<String, Object> consumerFactory() {
        Map<String, Object> configprops = new HashMap<>();
        configprops.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
        configprops.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configprops.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(configprops);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaTemplate() {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
    
}
