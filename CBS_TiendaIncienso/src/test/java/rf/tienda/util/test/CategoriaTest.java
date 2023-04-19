package rf.tienda.util.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import rf.tienda.dominio.Categoria;
import rf.tienda.exception.DomainException;

public class CategoriaTest {

	final String NOMBRE_OK = "Carlos";
	final String NOMBRE_ERROR_1 = "CBS";
	final String NOMBRE_ERROR_2 = "CarlosCarlosCarlosCarlosCarlosCarlosCarlosCarlosCarlosCarlosC";
	final String NOMBRE_ERROR_3 = "";

	final String DESCRIPCION_CATEGORIA_OK_1 = "Esto es la descripción de una categoria";
	final String DESCRIPCION_CATEGORIA_OK_2 = "";
	final String DESCRIPCION_CATEGORIA_ERROR_1 = "123456789112345678911234567891123456789112345678911234567891123456789112345678911234567891123456789112345678911234567891123456789112345678911234567891123456789112345678911234567891123456789112345678912";

	private static Categoria categoria;

	@BeforeAll
	static void inicio() {
		categoria = new Categoria();
	}

	@Test
	void testCat_nombre() throws DomainException {
		categoria.setCat_nombre(NOMBRE_OK);
		assertEquals(NOMBRE_OK, categoria.getCat_nombre());
		Assertions.assertThrows(DomainException.class, () -> {
			categoria.setCat_nombre(NOMBRE_ERROR_1);
		});
		Assertions.assertThrows(DomainException.class, () -> {
			categoria.setCat_nombre(NOMBRE_ERROR_2);
		});
		Assertions.assertThrows(DomainException.class, () -> {
			categoria.setCat_nombre(NOMBRE_ERROR_3);
		});
		
	}
	
	
}
