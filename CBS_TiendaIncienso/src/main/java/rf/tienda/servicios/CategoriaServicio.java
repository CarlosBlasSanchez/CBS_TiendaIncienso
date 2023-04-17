package rf.tienda.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rf.tienda.dominio.Categoria;
import rf.tienda.repository.CategoriaRepository;
@Service
public class CategoriaServicio implements ICategoriaServicio  {
	@Autowired
	CategoriaRepository categoriaRepo;
	@Override
	public List<Categoria> leertodo() {
		return categoriaRepo.findAll();
	}
	@Override
	public Categoria crear(Categoria categoria) {
		return categoriaRepo.save(categoria);
	}

}
