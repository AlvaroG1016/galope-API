package com.galope.pedidos.models.pedidos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Date;

public record DatosRegistroPedido(
        @NotNull
        Long id_mesero,
        @NotNull
        Long id_mesa,
        @NotBlank
        String descripcion,
        @NotNull
        LocalDateTime fecha,

        String observaciones

) {
}
