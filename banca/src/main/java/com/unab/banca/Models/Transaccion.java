package com.unab.banca.Models;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="transaccion")
public class Transaccion  implements Serializable{
    @Id
    @Column(name="id_transaccion")
    private String id_transaccion;
    @Column(name="fecha_transaccion")
    private String fecha_transaccion;
    @Column(name="valor_transaccion")
    private String valor_transaccion;
    @Column(name="tipo_transaccion")
    private String tipo_transaccion;
    @Column(name="id_cuenta")
    private String id_cuenta;
    
    @Override
    public String toString() {
        return "Transaccion [id_transaccion=" + id_transaccion + ", fecha_transaccion=" + fecha_transaccion 
        + ", valor_transaccion=" + valor_transaccion + ", tipo_transaccion=" + tipo_transaccion 
        + ", id_cuenta=" + id_cuenta + "]";
    }
}