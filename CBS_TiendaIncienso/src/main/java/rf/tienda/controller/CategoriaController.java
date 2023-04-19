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

import rf.tienda.dominio.Categoria;
import rf.tienda.exception.DomainException;
import rf.tienda.servicios.ICategoriaServicio;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	@Autowired
	private ICategoriaServicio categoriaServicio;
	
	@GetMapping
		public List<Categoria> listCategoria(){
		return categoriaServicio.leertodo();
	}
	
	@PostMapping
		public Categoria crearCategoria(@RequestBody Categoria categoria) throws DomainException {
			categoria.setId_categoria(0);
			return categoriaServicio.crear(categoria);
	}
	
	@PutMapping
	public Categoria actualizarCategoria(@RequestBody Categoria categoria) throws DomainException {
		return categoriaServicio.actualizarCategoria(categoria, categoria.getId_categoria());
		
	}
	
	@DeleteMapping
	public void borrarCategoria(@RequestBody Categoria categoria) {
		categoriaServicio.borrarCategoria(categoria, categoria.getId_categoria());
	}
	
	
	
	
}
