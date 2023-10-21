package com.abc.ecommerce.controller;


import com.abc.ecommerce.dto.LogisticRequestDTO;
import com.abc.ecommerce.dto.LogisticResponseDTO;
import com.abc.ecommerce.service.LogisticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class LogisticController {

    @Autowired
    private LogisticService logisticService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/abc/logistics/info")
    public ResponseEntity<LogisticResponseDTO> query(@RequestBody LogisticRequestDTO logisticRequestDTO){
          logger.info("Received request to fetch the courier rate from different sources");
         return  ResponseEntity.ok(logisticService.queryLogisticInfo(logisticRequestDTO));

    }
}
