package rf.tienda.servicios;

import java.util.List;

import rf.tienda.dominio.PedidoCarrito;
import rf.tienda.exception.DomainException;


public interface IPedidoCarritoServicio {

	List<PedidoCarrito> leertodo();
	PedidoCarrito crearPedidoCarrito(PedidoCarrito pedidoCarrito);
	PedidoCarrito actualizarPedidoCarrito(PedidoCarrito pedidoCarrito, int id_pedidoCarrito) throws DomainException;
	void borrarPedidoCarrito(PedidoCarrito pedidoCarrito, int id_pedidoCarrito);
	
}
