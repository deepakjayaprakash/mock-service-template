package com.service.mock.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.mock.dto.ResponseDTO;
import com.service.mock.model.APIEntity;
import com.service.mock.model.ResponseEntity;
import com.service.mock.repository.APIRepository;
import com.service.mock.repository.ResponseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class MockImpl {

    @Autowired
    private APIRepository apiRepository;

    @Autowired
    private ResponseRepository responseRepository;

    public ResponseDTO getResponse(Long apiId) {
        ResponseDTO responseDTO = new ResponseDTO();
        APIEntity apiEntity = apiRepository.getByAPIId(apiId);
        if (apiEntity != null) {
            ResponseEntity responseEntity = responseRepository.getByResponseId(apiEntity.getId());
            responseDTO.setData(convertToDatabaseColumn(responseEntity.getResponseJson()));
        }
        return responseDTO;
    }

    public Map<String, Object> convertToDatabaseColumn(String attribute)
    {
        if (attribute == null) {
            return new HashMap<>();
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(attribute, HashMap.class);
        }
        catch (IOException e) {
            log.error("Convert error while trying to convert string(JSON) to map data structure.");
        }
        return new HashMap<>();
    }
}
