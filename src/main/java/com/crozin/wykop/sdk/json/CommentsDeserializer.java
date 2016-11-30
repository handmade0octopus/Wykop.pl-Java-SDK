package com.crozin.wykop.sdk.json;

import com.crozin.wykop.sdk.domain.EntryComment;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CommentsDeserializer extends JsonDeserializer<List<EntryComment>> {


    @Override
    public List<EntryComment> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {

        return new ObjectMapper().readValue(jp, new TypeReference<List<EntryComment>>() {
        });
    }
}
