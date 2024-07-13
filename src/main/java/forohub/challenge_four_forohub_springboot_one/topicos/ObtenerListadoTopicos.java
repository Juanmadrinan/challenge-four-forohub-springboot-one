package forohub.challenge_four_forohub_springboot_one.topicos;


import java.sql.Date;

public record ObtenerListadoTopicos(String titulo, String mensaje, Date fechaCreacion, Boolean status, String autor, String curso) {


    public ObtenerListadoTopicos(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }

}
