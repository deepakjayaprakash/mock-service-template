package com.service.mock.controller;

import com.service.mock.dto.ResponseDTO;
import com.service.mock.impl.MockImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping(value = "/mock-service")
public class MockController {

    @Autowired
    private MockImpl mockImpl;

    /**
     * API for returning mock response of POST API
     */
    @PostMapping(value = {"/post-api/{apiId}"})
    public ResponseDTO getPostResponse(@PathVariable(value = "apiId") Long apiId) {
        ResponseDTO responseDTO = mockImpl.getResponse(apiId);
        return responseDTO;
    }

    /**
     * API for returning mock response of GET API
     */
    @GetMapping(value = {"/get-api/{apiId}"})
    public ResponseDTO getGetResponse(@PathVariable(value = "apiId") Long apiId) {
        ResponseDTO responseDTO = mockImpl.getResponse(apiId);
        return responseDTO;
    }

}
