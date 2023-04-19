package rf.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rf.tienda.dominio.Usuario;
import rf.tienda.servicios.IUsuarioServicio;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private IUsuarioServicio usuarioServicio;

	@GetMapping
	public List<Usuario> listUsuario() {
		return usuarioServicio.leertodo();
	}

	@PostMapping
	public Usuario crearUsuario(@RequestBody Usuario usuario) {
		usuario.setId_usuario(0);
		return usuarioServicio.crear(usuario);
	}
	
	@PutMapping
	public Usuario actualizarUsuario(@RequestBody Usuario usuario) {
		return usuarioServicio.actualizarUsuario(usuario, usuario.getId_usuario());
	}
	
	@DeleteMapping
	public void borrarUsuario(@RequestBody Usuario usuario) {
		usuarioServicio.borrarUsuario(usuario, usuario.getId_usuario());
	}	
}
