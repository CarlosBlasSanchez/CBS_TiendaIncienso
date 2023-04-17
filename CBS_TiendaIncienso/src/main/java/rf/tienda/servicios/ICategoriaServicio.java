package rf.tienda.servicios;

import java.util.List;
import rf.tienda.dominio.Categoria;

public interface ICategoriaServicio {
	
	List<Categoria> leertodo();
	Categoria crear(Categoria categoria);
}
