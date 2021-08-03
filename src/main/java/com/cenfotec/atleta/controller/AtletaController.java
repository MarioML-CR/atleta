package com.cenfotec.atleta.controller;
import com.cenfotec.atleta.domian.*;
import com.cenfotec.atleta.service.*;
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

    @Autowired
    IndiceMasaMuscularService indiceMasaMuscularService;

    @Autowired
    DeporteService deporteService;

    @Autowired
    DireccionService direccionService;

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

    @RequestMapping("/agregarIMC/{id}")
    public String cargarAtletaParaIMC(Model model, @PathVariable long id) {
        Optional<Atleta> atleta = atletaService.getAtletaById(id);
        IndiceMasaMuscular indiceMasaMuscular = new IndiceMasaMuscular();
        if (atleta.isPresent()){
            model.addAttribute("nombreAtleta", atleta.get().getPrimerNombre());
            model.addAttribute("idAtleta", atleta.get().getIdAtleta());
            model.addAttribute("imc", indiceMasaMuscular);
            return "agregarIMC";
        }
        return "noFound";
    }
    @RequestMapping(value = "/agregarIMC/{id}", method = RequestMethod.POST)
    public String guardarIMC(IndiceMasaMuscular indiceMasaMuscular, Model model, @PathVariable long id) {
        Optional<Atleta> atleta = atletaService.getAtletaById(id);
        if(atleta.isPresent()) {
            indiceMasaMuscular.setAtleta(atleta.get());
            indiceMasaMuscularService.saveIMC(indiceMasaMuscular);
            return "index";
        }
        return "error";
    }

    @RequestMapping("/agregarDeporte/{id}")
    public String cargarAtletaParaDeporte(Model model, @PathVariable long id) {
        Optional<Atleta> atleta = atletaService.getAtletaById(id);
        Deporte deporte = new Deporte();
        if (atleta.isPresent()) {
            model.addAttribute("nombreAtleta", atleta.get().getPrimerNombre());
            model.addAttribute("idAtleta", atleta.get().getIdAtleta());
            model.addAttribute("deporte", deporte);
            return "agregarDeporte";
        }
        return "noFound";
    }
    @RequestMapping(value = "/agregarDeporte/{id}", method = RequestMethod.POST)
    public String guardarDeporte(Deporte deporte, Model model, @PathVariable long id) {
        Optional<Atleta> atleta = atletaService.getAtletaById(id);
        if(atleta.isPresent()) {
            deporte.setAtleta(atleta.get());
            deporteService.saveDeporte(deporte);
            return "index";
        }
        return "error";
    }
    @RequestMapping("/agregarDireccion/{id}")
    public String cargarAtletaParaDireccion(Model model, @PathVariable long id) {
        Optional<Atleta> atleta = atletaService.getAtletaById(id);
        Direccion direccion = new Direccion();
        if (atleta.isPresent()) {
            model.addAttribute("nombreAtleta", atleta.get().getPrimerNombre());
            model.addAttribute("idAtleta", atleta.get().getIdAtleta());
            model.addAttribute("adress", direccion);
            return "agregarDireccion";
        }
        return "noFound";
    }
    @RequestMapping(value = "/agregarDireccion/{id}", method = RequestMethod.POST)
    public String guardarDireccion(Direccion direccion, Model model, @PathVariable long id) {
        Optional<Atleta> atleta = atletaService.getAtletaById(id);
        if(atleta.isPresent()) {
            direccion.setAtleta(atleta.get());
            direccionService.saveDireccion(direccion);
            return "index";
        }
        return "error";
    }
}
