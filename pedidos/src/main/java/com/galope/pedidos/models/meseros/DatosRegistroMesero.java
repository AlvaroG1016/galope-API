package com.galope.pedidos.models.meseros;


import jakarta.validation.constraints.NotBlank;

public record DatosRegistroMesero(
    @NotBlank
    String nombre,
    @NotBlank
    String documento

    ){}