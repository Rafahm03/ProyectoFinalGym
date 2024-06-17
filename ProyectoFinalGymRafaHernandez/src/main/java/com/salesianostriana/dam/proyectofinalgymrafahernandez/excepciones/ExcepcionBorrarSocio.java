package com.salesianostriana.dam.proyectofinalgymrafahernandez.excepciones;

public class ExcepcionBorrarSocio  extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExcepcionBorrarSocio() {
        super("No se puede eliminar un cliente que tiene  planes o cuotas asocioados");
    }

    public ExcepcionBorrarSocio(String mensaje) {
        super(mensaje);
    }
}
