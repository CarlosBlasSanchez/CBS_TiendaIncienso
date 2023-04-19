package rf.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rf.tienda.dominio.Producto;

public interface ProductoRepository extends JpaRepository<Producto, String> {

}
