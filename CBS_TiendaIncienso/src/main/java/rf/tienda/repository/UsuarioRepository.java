package rf.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rf.tienda.dominio.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
