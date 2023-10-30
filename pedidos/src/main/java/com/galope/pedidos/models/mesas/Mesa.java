package com.galope.pedidos.models.mesas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mesas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_mesa")
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_mesa;
    private String nombre;
    private String observaciones;

    public Mesa(DatosRegistroMesa datosRegistroMesa) {
        this.nombre = datosRegistroMesa.nombre();
        this.observaciones = datosRegistroMesa.observaciones();
    }

}


