package com.galope.pedidos.models.pedidos;

public record DatosListadoPedido(Long id, Long id_mesero, Long id_mesa, String descripcion, String observaciones) {

   /* public DatosListadoPedido(Pedido pedido){
        this(pedido.getId(), pedido.getId_mesero(),pedido.getId_mesa() , pedido.getDescripcion(),  pedido.getObservaciones());
    }*/

}
