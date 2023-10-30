package com.galope.pedidos.models.meseros;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "meseros")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_mesero")
public class Mesero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_mesero;
    private String nombre;
    private String documento;

    public Mesero(DatosRegistroMesero datosRegistroMesero) {
        this.documento = datosRegistroMesero.documento();
        this.nombre = datosRegistroMesero.nombre();
    }
    public void actualizarDatos(DatosActualizarMesero datosActualizarMesero){
        if(datosActualizarMesero.nombre() != null){
            this.nombre = datosActualizarMesero.nombre();
        }
        if(datosActualizarMesero.documento() != null){
            this.documento = datosActualizarMesero.documento();
        }
    }

}
