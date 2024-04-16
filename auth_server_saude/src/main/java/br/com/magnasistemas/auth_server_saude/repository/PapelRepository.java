package br.com.magnasistemas.auth_server_saude.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magnasistemas.auth_server_saude.entity.Papel;

public interface PapelRepository extends JpaRepository<Papel, Long> {

}