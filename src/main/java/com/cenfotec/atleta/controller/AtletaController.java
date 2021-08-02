package com.cenfotec.atleta.controller;

import com.cenfotec.atleta.service.AtletaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/atleta"})
public class AtletaController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AtletaService atletaService;
}
