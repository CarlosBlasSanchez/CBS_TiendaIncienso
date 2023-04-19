package rf.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rf.tienda.dominio.PedidoCarrito;

public interface PedidoCarritoRepository extends JpaRepository<PedidoCarrito, Integer> {

}
