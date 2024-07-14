package forohub.challenge_four_forohub_springboot_one.repository;

import forohub.challenge_four_forohub_springboot_one.domain.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface RepositoryUsuario extends JpaRepository<Usuario, Long> {

    UserDetails findByUser(String user);
}
