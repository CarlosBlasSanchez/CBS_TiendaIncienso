package rf.tienda.servicios;

import java.util.List;
import rf.tienda.dominio.Categoria;
import rf.tienda.exception.DomainException;

public interface ICategoriaServicio {
	
	List<Categoria> leertodo();
	Categoria crear(Categoria categoria);
	Categoria actualizarCategoria(Categoria categoria, int id_categoria) throws DomainException;
	void borrarCategoria(Categoria categoria, int id_categoria);
	
}
