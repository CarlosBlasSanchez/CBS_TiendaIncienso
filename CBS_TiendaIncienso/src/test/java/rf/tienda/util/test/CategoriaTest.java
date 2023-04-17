package rf.tienda.util.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import rf.tienda.dominio.Categoria;

public class CategoriaTest {

	final int ID_OK = 1;
	final int ID_ERROR_1 = 0;
	final String ID_ERROR_2 = "1";
	final char ID_ERROR_3 = '2';
	final int ID_ERROR_4 = -2;

	final String NOMBRE_OK = "Carlos";
	final String NOMBRE_ERROR_1 = "CBS";
	final String NOMBRE_ERROR_2 = "CarlosCarlosCarlosCarlosCarlosCarlosCarlosCarlosCarlosCarlosC";
	final String NOMBRE_ERROR_3 = "";
	final String NOMBRE_ERROR_4 = null;

	final String DESCRIPCION_CATEGORIA_OK_1 = "Esto es la descripción de una categoria";
	final String DESCRIPCION_CATEGORIA_OK_2 = "";
	final String DESCRIPCION_CATEGORIA_ERROR_1 = "123456789112345678911234567891123456789112345678911234567891123456789112345678911234567891123456789112345678911234567891123456789112345678911234567891123456789112345678911234567891123456789112345678912";

	@Test
	public void testID_isValid() {
		//assertTrue(Categoria);
	}
}
