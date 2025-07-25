package com.topicos.topicos.models.payload;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {

    private Date hora = new Date();
    private String mensaje;
    private boolean exito;
    private Object data;

    public ApiResponse() {
    }

    public ApiResponse(String mensaje, boolean exito, Object data) {
        this.mensaje = mensaje;
        this.exito = exito;
        this.data = data;
    }

    public ApiResponse(String mensaje, boolean exito) {
        this.mensaje = mensaje;
        this.exito = exito;
    }

    public Date getHora() {
        return hora;
    }

    public String getMensaje() {
        return mensaje;
    }

    public boolean isExito() {
        return exito;
    }

    public Object getData() {
        return data;
    }

}
