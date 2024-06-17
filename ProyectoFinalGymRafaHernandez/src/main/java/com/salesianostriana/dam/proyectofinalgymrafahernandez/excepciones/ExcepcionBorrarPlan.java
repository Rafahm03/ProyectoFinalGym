package com.salesianostriana.dam.proyectofinalgymrafahernandez.excepciones;

public class ExcepcionBorrarPlan extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExcepcionBorrarPlan() {
        super("No se puede eliminar un plan que tiene cuotas o socios asociados");
    }

    public ExcepcionBorrarPlan(String mensaje) {
        super(mensaje);
    }
}