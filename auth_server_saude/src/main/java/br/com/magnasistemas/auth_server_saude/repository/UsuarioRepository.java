package br.com.magnasistemas.auth_server_saude.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magnasistemas.auth_server_saude.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByLogin(String login);
}
