package com.serivce.mock.impl;

import com.serivce.mock.dto.ResponseDTO;
import com.serivce.mock.model.APIEntity;
import com.serivce.mock.model.ResponseEntity;
import com.serivce.mock.repository.APIRepository;
import com.serivce.mock.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
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
            responseDTO.setData(responseEntity.getResponse());
        }
        return responseDTO;
    }
}
