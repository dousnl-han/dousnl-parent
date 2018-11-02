package com.dousnl.config;

import com.fasterxml.jackson.databind.*;

public class JasonObjectMapperWithView extends ObjectMapper {

    private static final long serialVersionUID = -7402610966787328180L;

    @Override
    public SerializationConfig getSerializationConfig() {
        this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        return super.getSerializationConfig();
    }

    @Override
    public DeserializationConfig getDeserializationConfig() {
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return super.getDeserializationConfig();
    }

}
