package forohub.challenge_four_forohub_springboot_one.domain.topicos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "topicos")
@Entity(name = "Topicos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private Date fechaCreacion;
    private Boolean status;
    private String autor;
    private String curso;

    public Topico(DatosTopico datosTopico){
        this.titulo = datosTopico.titulo();
        this.mensaje = datosTopico.mensaje();
        this.fechaCreacion = Date.valueOf(LocalDate.now());
        this.status = true;
        this.autor = datosTopico.autor();
        this.curso = datosTopico.curso();
    }

    public void actualizarDatos(@Valid ActualizarDatosTopicos topico) {
        if (topico.titulo() != null) {
            this.titulo = topico.titulo();
        }
        if (topico.mensaje() != null) {
            this.mensaje = topico.mensaje();
        }
        if (topico.fechaCreacion() != null) {
            this.fechaCreacion = topico.fechaCreacion();
        }
        if (topico.status() != null) {
            this.status = topico.status();
        }
        if (topico.autor() != null) {
            this.autor = topico.autor();
        }
        if (topico.curso() != null) {
            this.curso = topico.curso();
        }
    }

    @Override
    public String toString() {
        return "Topico {" +
                "\n id=" + id +
                "\n titulo='" + titulo + '\'' +
                "\n mensaje='" + mensaje + '\'' +
                "\n fechaCreacion=" + fechaCreacion +
                "\n status=" + status +
                "\n autor='" + autor + '\'' +
                "\n curso='" + curso + '\'' +
                "\n  }";
    }
}
