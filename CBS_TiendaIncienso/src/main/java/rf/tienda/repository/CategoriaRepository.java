package rf.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rf.tienda.dominio.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	//acceder a la bbdd
	
	
}
