package rf.tienda.servicios;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rf.tienda.dominio.Usuario;
import rf.tienda.repository.UsuarioRepository;

@Service
public class UsuarioServicio implements IUsuarioServicio {
	@Autowired
	UsuarioRepository usuarioRepo;
	@Override
	public List<Usuario> leertodo() {
		return usuarioRepo.findAll();
	}
	
	@Override
	public Usuario crear(Usuario usuario) {
		return usuarioRepo.save(usuario);
	}
	@Override
	public Usuario actualizarUsuario(Usuario usuario, int id_usuario) {
		Usuario aux = usuarioRepo.findById(id_usuario).get();
		if (Objects.nonNull(usuario.getUser_nombre()) && !"".equalsIgnoreCase(usuario.getUser_nombre())) {
			aux.setUser_nombre(usuario.getUser_nombre());
		}
		if (Objects.nonNull(usuario.getUser_email()) && !"".equalsIgnoreCase(usuario.getUser_email())) {
			aux.setUser_email(usuario.getUser_email());
		}
		if (Objects.nonNull(usuario.getUser_pass()) && !"".equalsIgnoreCase(usuario.getUser_pass())) {
			aux.setUser_pass(usuario.getUser_pass());
		}
		if (Objects.nonNull(usuario.getId_tipo())) {
			aux.setId_tipo(usuario.getId_tipo());
		}
		if (Objects.nonNull(usuario.getUser_dni()) && !"".equalsIgnoreCase(usuario.getUser_dni())) {
			aux.setUser_dni(usuario.getUser_dni());
		}
		if (Objects.nonNull(usuario.getUser_fecAlta())) {
			aux.setUser_fecAlta(usuario.getUser_fecAlta());
		}
		if (Objects.nonNull(usuario.getUser_fecConfirmacion())) {
			aux.setUser_fecConfirmacion(usuario.getUser_fecConfirmacion());
		}
		if (Objects.nonNull(usuario.getUser_pago())) {
			aux.setUser_pago(usuario.getUser_pago());
		}
		if (Objects.nonNull(usuario.getUser_envio())) {
			aux.setUser_envio(usuario.getUser_envio());
		}
		return usuarioRepo.save(aux);
	}
	@Override
	public void borrarUsuario(Usuario usuario, int id_usuario) {
		Usuario aux = usuarioRepo.findById(id_usuario).get();
		usuarioRepo.delete(aux);
	}
	
	
}
