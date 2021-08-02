package com.cenfotec.atleta.controller;

import com.cenfotec.atleta.domian.Atleta;
import com.cenfotec.atleta.service.AtletaService;
import com.cenfotec.atleta.service.CorreoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller

public class AtletaController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AtletaService atletaService;

    @Autowired
    CorreoService correoService;

    @RequestMapping({"/"})
    public String home(Model model) {
        return "index";
    }

    @RequestMapping(value = "/insertar", method = RequestMethod.GET)
    public String insertarPage(Model model) {
        model.addAttribute(new Atleta());
        return "insertar";
    }
    @RequestMapping(value = "/atleta/insertar", method = RequestMethod.POST)
    public String insertarAction(Atleta atleta, BindingResult result, Model model) {
        atletaService.saveAtleta(atleta);
        return "index";
    }

    @RequestMapping("/atleta/listar")
    public String listar(Model model) {
        logger.info("lista de Atletas", atletaService.getAllAtletas());
        model.addAttribute("Atletas", atletaService.getAllAtletas());
        return "listar";
    }
    @GetMapping(path = {"atleta/{id}"})
    public ResponseEntity<Atleta> getAtletaById(@PathVariable long id) {
        Optional<Atleta> result = atletaService.getAtletaById(id);
        if (result.isPresent()) {
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
//    @GetMapping(path = {"atleta/{nombre}"})
//    public ResponseEntity<List<Atleta>> findAtletaByName(String nombre) {
//        List<Atleta> result = atletaService.findAtletaByName(nombre);
//        if (!result.isEmpty()){
//            return ResponseEntity.ok().body(result);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
