package com.galope.pedidos.models.meseros;

public record DatosListadoMesero(Long id_mesero, String nombre, String documento) {

    public DatosListadoMesero(Mesero mesero){
        this(mesero.getId_mesero(), mesero.getDocumento(), mesero.getNombre());
    }
}
