package com.galope.pedidos.models.pedidos;

import com.galope.pedidos.Proyecciones.PedidoResumen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("SELECT p.descripcion AS descripcion, " +
            "p.observaciones AS observacionesPedido, " +
            "p.fecha AS fecha, " +
            "m.nombre AS nombreMesa, " +
            "m.observaciones AS observacionesMesa, " +
            "me.nombre AS nombreMesero " +
            "FROM Pedido p " +
            "JOIN p.mesa m " +
            "JOIN p.mesero me")
    List<PedidoResumen> getAllPedidos();
}
