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

import javax.swing.text.html.Option;
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
    @RequestMapping("/listar")
    public String listarA(Model model) {
        logger.info("atletas", atletaService.getAllAtletas());
        model.addAttribute("atletas", atletaService.getAllAtletas());
        return "listar";
    }
    @RequestMapping("/cargarDetalle/{id}")
    public String cargarAtletaParaDetalle(Model model, @PathVariable long id) {
        Optional<Atleta> atleta = atletaService.getAtletaById(id);
        if (atleta.isPresent()) {
            model.addAttribute("atleta", atleta.get());
            model.addAttribute("correos", atleta.get().getCorreos());
            return "cargarDetalleAtleta";
        }
        return "noFound";
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
//    @RequestMapping("atleta/{nombre}")
//    public String findAtletaByName(Model model, @PathVariable String nombre) {
//        List<Atleta> result = atletaService.findAtletaByName(nombre);
//        if (!result.isEmpty()){
//            return "listarAtleta";
//        } else {
//            return "noFound";
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
    @RequestMapping("/updateCorreo/{id}")
    public String cargarCorreo(Model model, @PathVariable long id) {
        Optional<Correo> correo = correoService.getCorreoById(id);
        if (correo.isPresent()) {
            model.addAttribute("correoAtleta", correo.get());
            model.addAttribute("atleta", correo.get().getAtleta());
            return "updateCorreo";
        }
        return "noFound";
    }
    @RequestMapping(value = "/updateCorreo/{id}", method = RequestMethod.POST)
    public String updateCorreo(Correo correo, @PathVariable long id) {
        Optional<Correo> correo1 = correoService.getCorreoById(id);
        if (correo1.isPresent()) {
            correo.setAtleta(correo1.get().getAtleta());
            correo.setIdCorreo(correo1.get().getIdCorreo());
            correoService.updateCorreo(correo);
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

    @RequestMapping("/updateTelefono/{id}")
    public String cargarTelefono(Model model, @PathVariable long id) {
        Optional<Telefono> telefono = telefonoService.getTelefonoById(id);
        if (telefono.isPresent()) {
            model.addAttribute("telefonoAtleta", telefono.get());
            model.addAttribute("atleta", telefono.get().getAtleta());
            return "updateTelefono";
        }
        return "noFound";
    }
    @RequestMapping(value = "/updateTelefono/{id}", method = RequestMethod.POST)
    public String updateTelefono(Telefono telefono, @PathVariable long id) {
        Optional<Telefono> record = telefonoService.getTelefonoById(id);
        if (record.isPresent()) {
            telefono.setAtleta(record.get().getAtleta());
            telefono.setIdTelefono(record.get().getIdTelefono());
            telefonoService.updateTelefono(telefono);
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
    public String guardarIMC(IndiceMasaMuscular indiceMasaMuscular,
                             Model model, @PathVariable long id) {
        Optional<Atleta> atleta = atletaService.getAtletaById(id);
        if(atleta.isPresent()) {
            indiceMasaMuscular.setAtleta(atleta.get());
            indiceMasaMuscularService.saveIMC(indiceMasaMuscular);
            return "index";
        }
        return "error";
    }

    @RequestMapping("/updateIMC/{id}")
    public String cargarIMC(Model model, @PathVariable long id) {
        Optional<IndiceMasaMuscular> indiceMasaMuscular = indiceMasaMuscularService
                .getIndiceMasaMuscularById(id);
        if (indiceMasaMuscular.isPresent()) {
            model.addAttribute("imcAtleta", indiceMasaMuscular.get());
            model.addAttribute("atleta", indiceMasaMuscular.get().getAtleta());
            return "updateIMC";
        }
        return "noFound";
    }

    @RequestMapping(value = "/updateIMC/{id}", method = RequestMethod.POST)
    public String updateDireccion(IndiceMasaMuscular indiceMasaMuscular,
                                  @PathVariable long id) {
        Optional<IndiceMasaMuscular> record = indiceMasaMuscularService
                .getIndiceMasaMuscularById(id);
        if (record.isPresent()) {
            indiceMasaMuscular.setAtleta(record.get().getAtleta());
            indiceMasaMuscular.setIdIMC(record.get().getIdIMC());
            indiceMasaMuscular.setEstatura(record.get().getEstatura());
            indiceMasaMuscularService.updateIMC(indiceMasaMuscular);
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
    @RequestMapping("/updateDireccion/{id}")
    public String cargarDireccion(Model model, @PathVariable long id) {
        Optional<Direccion> direccion = direccionService.getDireccionById(id);
        if (direccion.isPresent()) {
            model.addAttribute("direccionAtleta", direccion.get());
            model.addAttribute("atleta", direccion.get().getAtleta());
            return "updateDireccion";
        }
        return "noFound";
    }
    @RequestMapping(value = "/updateDireccion/{id}", method = RequestMethod.POST)
    public String updateDireccion(Direccion direccion, @PathVariable long id) {
        Optional<Direccion> record = direccionService.getDireccionById(id);
        if (record.isPresent()) {
            direccion.setAtleta(record.get().getAtleta());
            direccion.setIdDireccion(record.get().getIdDireccion());
            direccionService.updateDireccion(direccion);
            return "index";
        }
        return "error";
    }
}
