package com.forohub.api.domain.topico;

public record DatosActualizacionTopico(

        String titulo,
        String mensaje,
        String status,
        String autor,
        String curso
) {
}