package com.galope.pedidos.Proyecciones;

import java.time.LocalDateTime;

public interface PedidoResumen {
    String getDescripcion();
    String getObservacionesPedido();
    LocalDateTime getFecha();
    String getNombreMesa();
    String getNombreMesero();
}
