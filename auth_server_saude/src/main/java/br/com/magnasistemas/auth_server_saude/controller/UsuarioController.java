package br.com.magnasistemas.auth_server_saude.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magnasistemas.auth_server_saude.dto.usuario.DadosCadastroUsuario;
import br.com.magnasistemas.auth_server_saude.dto.usuario.DadosDetalhamentoUsuario;
import br.com.magnasistemas.auth_server_saude.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;

	@Operation(description = "Cadastrar um usuário")
	@PostMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoUsuario> cadastrar(@RequestBody @Valid DadosCadastroUsuario dados){
		return ResponseEntity.status(201).body(usuarioService.cadastro(dados));
	}
}
