package rf.tienda.servicios;

import java.util.List;
import rf.tienda.dominio.Categoria;

public interface ICategoriaServicio {
	
	List<Categoria> leertodo();
	Categoria crear(Categoria categoria);
	Categoria actualizarCategoria(Categoria categoria, int id_categoria);
	void borrarCategoria(Categoria categoria, int id_categoria);
	
}
