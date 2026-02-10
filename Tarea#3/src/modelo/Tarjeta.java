/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author Mauricio León Bermúdez C5G444
 */
public class Tarjeta {
    private String tipoTarjeta;
    private LocalDate fechaAmonestacion;
    
    /**
     * Crea una tarjeta con el tipo especificado y asigna
     * automáticamente la fecha actual como fecha de amonestación.
     *
     * @param tipoTarjeta tipo de tarjeta
     */
    public Tarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
        this.fechaAmonestacion = LocalDate.now();
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public LocalDate getFechaAmonestacion() {
        return fechaAmonestacion;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public void setFechaAmonestacion(LocalDate fechaAmonestacion) {
        this.fechaAmonestacion = fechaAmonestacion;
    }
}
