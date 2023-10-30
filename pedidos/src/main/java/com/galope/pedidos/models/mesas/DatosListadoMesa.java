package com.galope.pedidos.models.mesas;

public record DatosListadoMesa(Long id_mesa, String nombre, String observaciones) {

    public DatosListadoMesa(Mesa mesa){
        this(mesa.getId_mesa(), mesa.getNombre(), mesa.getObservaciones());
    }
}
