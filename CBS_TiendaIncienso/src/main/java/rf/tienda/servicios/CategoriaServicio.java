package rf.tienda.servicios;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rf.tienda.dominio.Categoria;
import rf.tienda.exception.DomainException;
import rf.tienda.repository.CategoriaRepository;

@Service
public class CategoriaServicio implements ICategoriaServicio {
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

	@Override
	public Categoria actualizarCategoria(Categoria categoria, int id_categoria) throws DomainException {
		Categoria aux = categoriaRepo.findById(id_categoria).get();
		if (Objects.nonNull(categoria.getCat_nombre()) && !"".equalsIgnoreCase(categoria.getCat_nombre())) {
			aux.setCat_nombre(categoria.getCat_nombre());
		}
		if (Objects.nonNull(categoria.getCat_descripcion()) && !"".equalsIgnoreCase(categoria.getCat_descripcion())) {
			aux.setCat_descripcion(categoria.getCat_descripcion());
		}
		return categoriaRepo.save(aux);
	}

	@Override
	public void borrarCategoria(Categoria categoria, int id_categoria) {
		Categoria aux = categoriaRepo.findById(id_categoria).get();
		categoriaRepo.delete(aux);
	}

}
