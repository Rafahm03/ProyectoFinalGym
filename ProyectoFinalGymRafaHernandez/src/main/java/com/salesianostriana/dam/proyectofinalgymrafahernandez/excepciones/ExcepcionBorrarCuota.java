package com.salesianostriana.dam.proyectofinalgymrafahernandez.excepciones;

public class ExcepcionBorrarCuota extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExcepcionBorrarCuota() {
        super("No se puede eliminar una cuota que tiene planes o socios asociados");
    }

    public ExcepcionBorrarCuota(String mensaje) {
        super(mensaje);
    }
}