package forohub.challenge_four_forohub_springboot_one.controller;

import forohub.challenge_four_forohub_springboot_one.repository.RepositoryTopico;
import forohub.challenge_four_forohub_springboot_one.topicos.ActualizarDatosTopicos;
import forohub.challenge_four_forohub_springboot_one.topicos.DatosTopico;
import forohub.challenge_four_forohub_springboot_one.topicos.ObtenerListadoTopicos;
import forohub.challenge_four_forohub_springboot_one.topicos.Topico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private RepositoryTopico repositoryTopico;

    @PostMapping
    public ResponseEntity registrarTopico(@RequestBody @Valid DatosTopico datosTopico, UriComponentsBuilder uriComponentBuilder){
        var listado = repositoryTopico.findAll().stream().map(ObtenerListadoTopicos::new);
        var listadoMensaje = repositoryTopico.findAll().stream().map(ObtenerListadoTopicos::new);


        Topico topico = null;
        URI url = null;

        var x = listado.anyMatch(revision -> revision.titulo().equalsIgnoreCase(datosTopico.titulo()));
        var y = listadoMensaje.anyMatch(revision -> revision.mensaje().equalsIgnoreCase(datosTopico.mensaje()));

        if(!x || !y){
            topico = repositoryTopico.save(new Topico(datosTopico));
            url = uriComponentBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

            return ResponseEntity.created(url).body(topico);
        } else {
            return ResponseEntity.badRequest().body("Titulo y Mensaje ya se encuentra en FOROHUB");
        }
    }

    @GetMapping
    public ResponseEntity<Page<ObtenerListadoTopicos>> obtenerTopicos(@PageableDefault(size = 3) Pageable pagination){
        return ResponseEntity.ok(repositoryTopico.findAll(pagination).map(ObtenerListadoTopicos::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> obtenerTopico(@PathVariable Long id) {
        Optional<Topico> optional = repositoryTopico.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get().toString());
        } else {
            return ResponseEntity.badRequest().body("No se encontró un tópico con el ID proporcionado");
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarDatos(@RequestBody @Valid ActualizarDatosTopicos actualizarDatosTopicos, DatosTopico datosTopico,@PathVariable Long id) {
        Optional<Topico> optional = repositoryTopico.findById(id);

        if (optional.isPresent()){
            Topico topicos = optional.get();

            var listando = repositoryTopico.findAll().stream().map(ObtenerListadoTopicos::new);
            var listandoMensaje = repositoryTopico.findAll().stream().map(ObtenerListadoTopicos::new);

            var x = listando.anyMatch(revision -> revision.titulo().equalsIgnoreCase(actualizarDatosTopicos.titulo()));
            var y = listandoMensaje.anyMatch(revision -> revision.mensaje().equalsIgnoreCase(actualizarDatosTopicos.mensaje()));

            if(!x || !y) {
                topicos.actualizarDatos(actualizarDatosTopicos);
                return ResponseEntity.ok(topicos);
            } else {
                return ResponseEntity.badRequest().body("Titulo y Mensaje ya se encuentra en FOROHUB");
            }

        } else{
            return ResponseEntity.badRequest().body("No se encontró un tópico con el ID proporcionado para Editar");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTopico(@PathVariable Long id) {
        Optional<Topico> topico = repositoryTopico.findById(id);
        if (topico.isPresent()){
            repositoryTopico.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().body("No se encuestra el ID a eliminar en la Base de Datos");
        }
    }
}
