package com.galope.pedidos.models.pedidos;

import java.time.LocalDateTime;

public record DatosRespuestaPedido(Long id, Long id_mesero, Long id_mesa, String descripcion, LocalDateTime fecha, String observaciones) {
}
