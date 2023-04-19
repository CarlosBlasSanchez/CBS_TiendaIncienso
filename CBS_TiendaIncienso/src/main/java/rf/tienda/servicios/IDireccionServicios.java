package rf.tienda.servicios;

import java.util.List;

import rf.tienda.dominio.Direccion;
public interface IDireccionServicios {
	
	List<Direccion> leerTodo();
	Direccion crear(Direccion direccion);
	
	
}
