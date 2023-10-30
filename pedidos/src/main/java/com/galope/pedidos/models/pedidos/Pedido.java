package com.galope.pedidos.models.pedidos;

import com.galope.pedidos.models.mesas.Mesa;
import com.galope.pedidos.models.meseros.Mesero;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_mesero")
    private Mesero mesero;

    @ManyToOne
    @JoinColumn(name = "id_mesa")
    private Mesa mesa;

    private String descripcion;
    private String observaciones;
    private LocalDateTime fecha;

    public Pedido(DatosRegistroPedido datosRegistroPedido, Mesero mesero, Mesa mesa) {
        this.mesero = mesero;
        this.mesa = mesa;
        this.descripcion = datosRegistroPedido.descripcion();
        this.fecha = datosRegistroPedido.fecha();
        this.observaciones = datosRegistroPedido.observaciones();
    }
}


