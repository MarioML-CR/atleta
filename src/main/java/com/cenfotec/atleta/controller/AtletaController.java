package com.cenfotec.atleta.controller;
import com.cenfotec.atleta.domian.Atleta;
import com.cenfotec.atleta.domian.Correo;
import com.cenfotec.atleta.domian.Telefono;
import com.cenfotec.atleta.service.AtletaService;
import com.cenfotec.atleta.service.CorreoService;
import com.cenfotec.atleta.service.TelefonoService;
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

    @Autowired
    TelefonoService telefonoService;

    @RequestMapping({"/"})
    public String home(Model model) {
        return "index";
    }

    @RequestMapping(value = "/insertarAtleta", method = RequestMethod.GET)
    public String insertarPage(Model model) {
        model.addAttribute(new Atleta());
        return "insertarAtleta";
    }
    @RequestMapping(value = "/insertarAtleta", method = RequestMethod.POST)
    public String insertarAction(Atleta atleta, BindingResult result, Model model) {
        atletaService.saveAtleta(atleta);
        return "index";
    }

    @RequestMapping("/listarAtleta")
    public String listar(Model model) {
        logger.info("atletas", atletaService.getAllAtletas());
        model.addAttribute("atletas", atletaService.getAllAtletas());
        return "listarAtleta";
    }
    @GetMapping(path = {"/atleta/{id}"})
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
    @RequestMapping("/agregarCorreo/{id}")
    public String cargarAtletaParaCorreo(Model model, @PathVariable long id) {
        Optional<Atleta> atleta = atletaService.getAtletaById(id);
        Correo correo = new Correo();
        if (atleta.isPresent()) {
            model.addAttribute("nombreAtleta", atleta.get().getPrimerNombre());
            model.addAttribute("idAtleta", atleta.get().getIdAtleta());
            model.addAttribute("correo", correo);
            return "agregarCorreo";
        }
        return "noFound";
    }
    @RequestMapping(value = "/agregarCorreo/{id}", method = RequestMethod.POST)
    public String guardarCorreo(Correo correo, Model model, @PathVariable long id) {
        Optional<Atleta> atleta = atletaService.getAtletaById(id);
        if (atleta.isPresent()) {
            correo.setAtleta(atleta.get());
            correoService.saveCorreo(correo);
            return "index";
        }
        return "error";
    }



    @RequestMapping("/agregarTelefono/{id}")
    public String cargarAtletaParaTelefono(Model model, @PathVariable long id) {
        Optional<Atleta> atleta = atletaService.getAtletaById(id);
        Telefono telefono = new Telefono();
        if (atleta.isPresent()) {
            model.addAttribute("nombreAtleta", atleta.get().getPrimerNombre());
            model.addAttribute("idAtleta", atleta.get().getIdAtleta());
            model.addAttribute("telefono", telefono);
            return "agregarTelefono";
        }
        return "noFound";
    }
    @RequestMapping(value = "/agregarTelefono/{id}", method = RequestMethod.POST)
    public String guardarTelefono(Telefono telefono, Model model, @PathVariable long id) {
        Optional<Atleta> atleta = atletaService.getAtletaById(id);
        if(atleta.isPresent()) {
            telefono.setAtleta(atleta.get());
            telefonoService.saveTelefono(telefono);
            return "index";
        }
        return "error";
    }
}
