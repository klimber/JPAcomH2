package br.com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.demo.model.Usuario;
import br.com.example.demo.repository.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	

	@GetMapping("/usuarios")
	public List<Usuario> buscarTodos() {
		Usuario usuario = new Usuario();
		usuario.setEmail("klimber.mail@gmail.com");
		usuario.setNome("Allan Krueger");
		usuario.setSenha("hahaha");
		usuarioRepository.save(usuario);
		Iterable<Usuario> todos = usuarioRepository.findAll();
		return toList(todos);
	}

	public <E> List<E> toList(Iterable<E> iterable) {
		return StreamSupport
				.stream(iterable.spliterator(), false)
				.collect(Collectors.toList());

	}

}
