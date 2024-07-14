package forohub.challenge_four_forohub_springboot_one.infra.security;

import forohub.challenge_four_forohub_springboot_one.repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationUsers implements UserDetailsService {

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        return repositoryUsuario.findByUser(user);
    }
}
