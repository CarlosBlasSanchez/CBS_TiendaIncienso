package rf.tienda.servicios;

import java.util.List;
import rf.tienda.dominio.Producto;

public interface IProductoServicio {

	List<Producto> leertodo();
	Producto crearProducto(Producto producto);
	Producto actualizarProducto(Producto producto, String id_producto);
	void borrarProducto(Producto producto, String id_producto);
}
