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

import rf.tienda.dominio.PedidoCarrito;
import rf.tienda.servicios.IPedidoCarritoServicio;



@RestController
@RequestMapping("/pedidosCarrito")
public class PedidoCarritoController {
	@Autowired
	private IPedidoCarritoServicio pedidoCarritoServicio;

	@GetMapping
	public List<PedidoCarrito> listPedidoCarrito() {
		return pedidoCarritoServicio.leertodo();
	}

	@PostMapping
	public PedidoCarrito crearPedidoCarrito(@RequestBody PedidoCarrito pedidoCarrito) {
		pedidoCarrito.setId_pedido(0);
		return pedidoCarritoServicio.crearPedidoCarrito(pedidoCarrito);
	}
	
	@PutMapping
	public PedidoCarrito actualizarPedidoCarrito(@RequestBody PedidoCarrito pedidoCarrito) {
		return pedidoCarritoServicio.actualizarPedidoCarrito(pedidoCarrito, pedidoCarrito.getId_pedido());
		
	}
	
	@DeleteMapping
	public void borrarUsuario(@RequestBody PedidoCarrito pedidoCarrito) {
		pedidoCarritoServicio.borrarPedidoCarrito(pedidoCarrito, pedidoCarrito.getId_pedido());
	}
	
	
}
