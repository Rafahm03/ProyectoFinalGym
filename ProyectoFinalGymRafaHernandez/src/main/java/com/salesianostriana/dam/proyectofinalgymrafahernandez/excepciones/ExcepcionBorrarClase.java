package com.salesianostriana.dam.proyectofinalgymrafahernandez.excepciones;

public class ExcepcionBorrarClase extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExcepcionBorrarClase() {
        super("No se puede eliminar una clase que tiene reservas con socios");
    }

    public ExcepcionBorrarClase(String mensaje) {
        super(mensaje);
    }
}