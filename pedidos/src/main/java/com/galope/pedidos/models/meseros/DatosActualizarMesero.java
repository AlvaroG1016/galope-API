package com.galope.pedidos.models.meseros;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarMesero(@NotNull Long id_mesero, String nombre, String documento) {
}
