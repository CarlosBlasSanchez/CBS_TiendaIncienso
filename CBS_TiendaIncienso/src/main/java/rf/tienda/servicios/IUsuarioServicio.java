package rf.tienda.servicios;

import java.util.List;
import rf.tienda.dominio.Usuario;

public interface IUsuarioServicio {
	
	List<Usuario> leertodo();
	Usuario crear(Usuario usuario);
	Usuario actualizarUsuario(Usuario usuario, int id_usuario);
	void borrarUsuario(Usuario usuario, int id_usuario);
}
