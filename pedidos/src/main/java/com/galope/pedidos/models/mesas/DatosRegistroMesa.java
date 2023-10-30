package com.galope.pedidos.models.mesas;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroMesa(
        @NotBlank
        String nombre,
        @NotBlank
        String observaciones

) {
}
