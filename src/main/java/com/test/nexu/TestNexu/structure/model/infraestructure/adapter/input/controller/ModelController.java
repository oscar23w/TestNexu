package com.test.nexu.TestNexu.structure.model.infraestructure.adapter.input.controller;

import com.test.nexu.TestNexu.structure.model.application.port.input.ManagingModel;
import com.test.nexu.TestNexu.structure.model.domain.model.ModelModel;
import com.test.nexu.TestNexu.structure.model.infraestructure.adapter.input.request.ModelRequest;
import com.test.nexu.TestNexu.structure.model.infraestructure.adapter.input.response.ModelResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/models")
@RequiredArgsConstructor
public class ModelController {
    private final ManagingModel managingModel;


}
