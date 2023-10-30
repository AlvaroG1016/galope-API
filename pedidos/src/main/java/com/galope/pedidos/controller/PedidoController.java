package com.galope.pedidos.controller;

import com.galope.pedidos.Proyecciones.PedidoResumen;
import com.galope.pedidos.models.mesas.IMesaRepository;
import com.galope.pedidos.models.mesas.Mesa;
import com.galope.pedidos.models.meseros.IMeseroRepository;
import com.galope.pedidos.models.meseros.Mesero;
import com.galope.pedidos.models.pedidos.*;
import jakarta.validation.Valid;
import org.hibernate.sql.exec.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private IPedidoRepository pedidoRepository;

    @Autowired
    private IMeseroRepository meseroRepository;

    @Autowired
    private IMesaRepository mesaRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaPedido> registrarPedido(@RequestBody @Valid DatosRegistroPedido datosRegistroPedido, UriComponentsBuilder uriComponentsBuilder) {

        Mesero mesero = meseroRepository.findById(datosRegistroPedido.id_mesero())
                .orElseThrow(() -> new ExecutionException("Mesero no encontrado"));
        Mesa mesa = mesaRepository.findById(datosRegistroPedido.id_mesa())
                .orElseThrow(() -> new ExecutionException("Mesa no encontrada"));

        Pedido pedido = pedidoRepository.save(new Pedido(datosRegistroPedido, mesero, mesa));

        DatosRespuestaPedido datosRespuestaPedido = new DatosRespuestaPedido(pedido.getId(), pedido.getMesero().getId_mesero(), pedido.getMesa().getId_mesa(), pedido.getDescripcion(), pedido.getFecha(), pedido.getObservaciones());

        URI url = uriComponentsBuilder.path("/pedidos/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaPedido);
    }


    /*@GetMapping
    public ResponseEntity<Page<DatosListadoPedido>> listarPedido(@PageableDefault(size = 10)Pageable pageable){
        return ResponseEntity.ok(pedidoRepository.findAll(pageable).map(DatosListadoPedido::new));
    }*/

    @GetMapping("/consultaPersonalizada")
    public ResponseEntity<List<PedidoResumen>> getDatosPersonalizados() {
        return ResponseEntity.ok(pedidoRepository.getAllPedidos());
    }


}
