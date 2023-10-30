package com.galope.pedidos.controller;

import com.galope.pedidos.models.meseros.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/mesero")
public class MeseroController {

    @Autowired
    private IMeseroRepository MeseroRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaMesero> registrarMesero(@RequestBody @Valid DatosRegistroMesero datosRegistroMesero, UriComponentsBuilder uriComponentsBuilder){
        Mesero mesero = MeseroRepository.save(new Mesero(datosRegistroMesero));
        DatosRespuestaMesero datosRespuestaMesero = new DatosRespuestaMesero(mesero.getId_mesero(), mesero.getNombre(),mesero.getDocumento() );

        URI url = uriComponentsBuilder.path("/meseros/{id}").buildAndExpand(mesero.getId_mesero()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaMesero);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoMesero>> ListarMesero(@PageableDefault(size = 10) Pageable pageable){
        return  ResponseEntity.ok(MeseroRepository.findAll(pageable).map(DatosListadoMesero::new));
    }
}
