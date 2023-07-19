package com.crazyfly.services;

import com.crazyfly.models.OasGenTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;
import java.nio.charset.StandardCharsets;

public class OasGenTemplateSerializer implements Serializer<OasGenTemplate> {

    @Override
    public byte[] serialize(String topic, Headers headers, OasGenTemplate data) {
        return this.serialize(topic, data);
    }


    @Override
    public byte[] serialize(String s, OasGenTemplate oasGenTemplate) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsBytes(oasGenTemplate);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
