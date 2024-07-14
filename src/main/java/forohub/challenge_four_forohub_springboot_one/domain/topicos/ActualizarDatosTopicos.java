package forohub.challenge_four_forohub_springboot_one.domain.topicos;

import java.sql.Date;

public record ActualizarDatosTopicos(String titulo, String mensaje, Date fechaCreacion, Boolean status, String autor, String curso) {

    public ActualizarDatosTopicos(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}
