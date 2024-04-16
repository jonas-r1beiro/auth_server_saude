package br.com.magnasistemas.auth_server_saude.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.auth_server_saude.dto.usuario.DadosCadastroUsuario;
import br.com.magnasistemas.auth_server_saude.dto.usuario.DadosDetalhamentoUsuario;
import br.com.magnasistemas.auth_server_saude.entity.Usuario;
import br.com.magnasistemas.auth_server_saude.repository.PapelRepository;
import br.com.magnasistemas.auth_server_saude.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	PapelRepository papelRepository;
	
	public DadosDetalhamentoUsuario cadastro(DadosCadastroUsuario dados) {
		
		String senhaCrip = criarSenha(dados.senha());
		
		Usuario usuario = new Usuario(dados.login(), senhaCrip, dados.idExterno(), papelRepository.getReferenceById(dados.idPapel()));
		
		usuarioRepository.save(usuario);
		
		return new DadosDetalhamentoUsuario(usuario);
	}
	
	private String criarSenha(String senha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
		
		return encoder.encode(senha);
	}

}
