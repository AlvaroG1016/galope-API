package com.galope.pedidos.controller;

import com.galope.pedidos.models.mesas.*;
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
@RequestMapping("/mesas")
public class MesaController {
    @Autowired
    private IMesaRepository MesaRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaMesa> registrarMesa(@RequestBody @Valid DatosRegistroMesa datosRegistroMesa, UriComponentsBuilder uriComponentsBuilder){
        Mesa mesa = MesaRepository.save(new Mesa(datosRegistroMesa));
        DatosRespuestaMesa datosRespuestaMesa = new DatosRespuestaMesa(mesa.getId_mesa(), mesa.getNombre(), mesa.getObservaciones());
        URI url = uriComponentsBuilder.path("mesas/{id}").buildAndExpand(mesa.getId_mesa()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaMesa);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoMesa>> listarMesas(@PageableDefault(size = 10)Pageable pageable){
        return ResponseEntity.ok(MesaRepository.findAll(pageable).map(DatosListadoMesa::new));
    }
}
