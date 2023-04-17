package rf.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rf.tienda.dominio.Categoria;
import rf.tienda.interfaces.daos.ICategoria;
import rf.tienda.servicios.ICategoriaServicio;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	@Autowired
	private ICategoriaServicio cDao;
	
	@GetMapping
		public List<Categoria> listCategoria(){
		return cDao.leertodo();
	}
	
	@PostMapping
		public Categoria crearCategoria(@RequestBody Categoria categoria) {
			categoria.setId_categoria(0);
			return cDao.crear(categoria);
	}
	
	
	
}
