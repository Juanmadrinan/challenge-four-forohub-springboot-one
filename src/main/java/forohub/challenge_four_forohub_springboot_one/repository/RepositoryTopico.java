package forohub.challenge_four_forohub_springboot_one.repository;

import forohub.challenge_four_forohub_springboot_one.domain.topicos.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryTopico extends JpaRepository<Topico, Long> {

}
