package br.com.magnasistemas.auth_server_saude.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.auth_server_saude.entity.Usuario;
import br.com.magnasistemas.auth_server_saude.repository.UsuarioRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		final Usuario user = usuarioRepository.findByLogin(login);
		
		
		
		return new User(
				user.getUsername(), 
				user.getPassword(), 
				user.getAuthorities());
	}

}