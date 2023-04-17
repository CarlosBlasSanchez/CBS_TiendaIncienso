package rf.tienda.util.test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import rf.tienda.util.Validator;

public class ValidatorTest {

	final String ALFANUMERICO_OK = "99";
	final String ALFANUMERICO_ERROR_1 = "Texto con espacios";
	final String ALFANUMERICO_ERROR_2 = "Texto#ConCaracteres!Especiales";

	final String VACIO_OK = "";
	final String VACIO_ERROR="Hola";
	
	final String NUMERO_TELEFONO_OK = "600.600.600";
	final String NUMERO_TELEFONO_ERROR_1= "600600600";
	final String NUMERO_TELEFONO_ERROR_2= "123456789101112131415202";
	
	final String EMAIL_VALIDO_OK = "correo@gmail.com";
	final String EMAIL_VALIDO_ERROR_1 = "@gmail.com";
	final String EMAIL_VALIDO_ERROR_2 = "correo@gmailcom";
	final String EMAIL_VALIDO_ERROR_3 = "correo@@gmail.com";
	final String EMAIL_VALIDO_ERROR_4 = "correogmail.com";
	
	final String DNI_OK = "02.560.118-B";
	final String DNI_ERROR_1 = "02.560.118-";
	final String DNI_ERROR_2 = "02.560.118B";
	final String DNI_ERROR_3 = "02560118-B";
	final String DNI_ERROR_4 = "2.560.118-B";

	final int VALOR=3;
	final int VALOR_MINIMO=2;
	final int VALOR_MAXIMO=4;
	
	final double VALOR_DOUBLE=3;
	final double VALOR_MINIMO_DOUBLE=2;
	final double VALOR_MAXIMO_DOUBLE=4;

	final String TEXTO_OK = "Hola a todos";
	final String TEXTO_ERROR="";
	final String TEXTO_ERROR_MAX="Hola a todos estamos en España";

	final int TAMANIO_TEXTO_MIN = 4;
	final int TAMANIO_TEXTO_MAX = 13;
	
	final LocalDate FECHA_ACTUAL = LocalDate.now();
	final LocalDate FECHA_MIN = LocalDate.of(2023, 3, 3);
	final LocalDate FECHA_MAX = LocalDate.of(2040, 1, 1);
	
	final String FECHA_STRING_OK = "2020-03-12";
	final String FECHA_STRING_ERROR_1= "2020/03/12";
	final String FECHA_STRING_ERROR_2= "2020/3/12";
	final String FECHA_STRING_ERROR_3= "2020-02-8";
	final String FECHA_STRING_ERROR_4= "20/03/12";
	final String FECHA_STRING_ERROR_5= "2020/3/12";
	final String FECHA_STRING_ERROR_6= "2020/3/2";
	
	final String PASSWORD_OK = "Holahola1@";
	final String PASSWORD_ERROR_1 = "Holahola@";
	final String PASSWORD_ERROR_2 = "Holahola";
	final String PASSWORD_ERROR_3 = "Holahola1";
	final String PASSWORD_ERROR_4 = "AA.1@";
	final String PASSWORD_ERROR_5 = "Aa.1@";
	final String PASSWORD_ERROR_6 = "aa.1@";
	final String PASSWORD_ERROR_7 = "Holahola.1@holaholaHolahola";

	@Test
	public void testAlfanumericos() {
		assertTrue(Validator.isAlfanumeric(ALFANUMERICO_OK));
		assertFalse(Validator.isAlfanumeric(ALFANUMERICO_ERROR_1));
		assertFalse(Validator.isAlfanumeric(ALFANUMERICO_ERROR_2));
	}

	@Test
	public void testIsVacio() {
		assertTrue(Validator.isVacio(VACIO_OK));
		assertFalse(Validator.isVacio(VACIO_ERROR));

	}
	
	@Test
	public void testCumplePhoneNumber() {
		assertTrue(Validator.cumplePhoneNumber(NUMERO_TELEFONO_OK));
		assertFalse(Validator.cumplePhoneNumber(NUMERO_TELEFONO_ERROR_1));
		assertFalse(Validator.cumplePhoneNumber(NUMERO_TELEFONO_ERROR_2));
	}
	
	@Test
	public void testEmailValido() {
		assertTrue(Validator.isEmailValido(EMAIL_VALIDO_OK));
		assertFalse(Validator.isEmailValido(EMAIL_VALIDO_ERROR_1));
		assertFalse(Validator.isEmailValido(EMAIL_VALIDO_ERROR_2));
		assertFalse(Validator.isEmailValido(EMAIL_VALIDO_ERROR_3));
		assertFalse(Validator.isEmailValido(EMAIL_VALIDO_ERROR_4));

	}
	
	@Test
	public void testCumpleDNI() {
		assertTrue(Validator.cumpleDNI(DNI_OK));
		assertFalse(Validator.cumpleDNI(DNI_ERROR_1));
		assertFalse(Validator.cumpleDNI(DNI_ERROR_2));
		assertFalse(Validator.cumpleDNI(DNI_ERROR_3));
		assertFalse(Validator.cumpleDNI(DNI_ERROR_4));
		
	}
	
	@Test
	public void testCumpleRangoInt() {
		assertTrue(Validator.cumpleRango(VALOR, VALOR_MAXIMO, VALOR_MINIMO));
		assertFalse(Validator.cumpleRango((VALOR-1), VALOR_MAXIMO, VALOR_MINIMO));
		assertFalse(Validator.cumpleRango(VALOR, (VALOR_MAXIMO-1), VALOR_MINIMO));
		assertFalse(Validator.cumpleRango(VALOR, VALOR_MAXIMO, (VALOR_MINIMO+1)));
		assertFalse(Validator.cumpleRango(VALOR, (VALOR_MAXIMO-1), (VALOR_MINIMO+1)));
		assertFalse(Validator.cumpleRango((VALOR-2), VALOR_MAXIMO, VALOR_MINIMO));

	}
	
	@Test
	public void testCumpleRangoDouble() {
		assertTrue(Validator.cumpleRango(VALOR_DOUBLE, VALOR_MAXIMO_DOUBLE, VALOR_MINIMO_DOUBLE));
		assertFalse(Validator.cumpleRango((VALOR_DOUBLE-1), VALOR_MAXIMO_DOUBLE, VALOR_MINIMO_DOUBLE));
		assertFalse(Validator.cumpleRango(VALOR_DOUBLE, (VALOR_MAXIMO_DOUBLE-1), VALOR_MINIMO_DOUBLE));
		assertFalse(Validator.cumpleRango(VALOR_DOUBLE, VALOR_MAXIMO_DOUBLE, (VALOR_MINIMO_DOUBLE+1)));
		assertFalse(Validator.cumpleRango(VALOR_DOUBLE, (VALOR_MAXIMO_DOUBLE-1), (VALOR_MINIMO_DOUBLE+1)));
		assertFalse(Validator.cumpleRango((VALOR_DOUBLE-2), VALOR_MAXIMO_DOUBLE, VALOR_MINIMO_DOUBLE));
	}
	
	@Test
	public void testcumpleLongitudMin() {
		assertTrue(Validator.cumpleLongitudMin(TEXTO_OK, TAMANIO_TEXTO_MIN));
		assertFalse(Validator.cumpleLongitudMin(TEXTO_ERROR, TAMANIO_TEXTO_MIN));
	}
	
	@Test
	public void testcumpleLongitudMax() {
		assertTrue(Validator.cumpleLongitudMax(TEXTO_OK, TAMANIO_TEXTO_MAX));
		assertFalse(Validator.cumpleLongitudMax(TEXTO_ERROR_MAX, TAMANIO_TEXTO_MAX));
	}
	
	@Test 
	public void testCumpleLongitud() {
		assertTrue(Validator.cumpleLongitud(TEXTO_OK, TAMANIO_TEXTO_MIN, TAMANIO_TEXTO_MAX));
		assertFalse(Validator.cumpleLongitud(TEXTO_ERROR, TAMANIO_TEXTO_MIN, TAMANIO_TEXTO_MAX));
		assertFalse(Validator.cumpleLongitud(TEXTO_ERROR_MAX, TAMANIO_TEXTO_MIN, TAMANIO_TEXTO_MAX));
	}
	
	@Test 
	public void testValDateMin() {
		assertTrue(Validator.valDateMin(FECHA_ACTUAL, FECHA_MIN));
		assertFalse(Validator.valDateMin(FECHA_ACTUAL, FECHA_MAX));
		assertFalse(Validator.valDateMin(FECHA_ACTUAL, FECHA_ACTUAL));

	}
	
	@Test
	public void testValDateMax() {
		assertTrue(Validator.valDateMax(FECHA_ACTUAL, FECHA_MAX));
		assertFalse(Validator.valDateMax(FECHA_ACTUAL, FECHA_MIN));
		assertFalse(Validator.valDateMax(FECHA_ACTUAL, FECHA_ACTUAL));

	}
	
	@Test 
	public void testFechaValida() {
		assertTrue(Validator.esFechaValida(FECHA_STRING_OK));
		assertFalse(Validator.esFechaValida(FECHA_STRING_ERROR_1));
		assertFalse(Validator.esFechaValida(FECHA_STRING_ERROR_2));
		assertFalse(Validator.esFechaValida(FECHA_STRING_ERROR_3));
		assertFalse(Validator.esFechaValida(FECHA_STRING_ERROR_4));
		assertFalse(Validator.esFechaValida(FECHA_STRING_ERROR_5));
		assertFalse(Validator.esFechaValida(FECHA_STRING_ERROR_6));
	}
	
	@Test 
	public void testEsPasswordValida() {
		assertTrue(Validator.esPasswordValida(PASSWORD_OK));
		assertFalse(Validator.esPasswordValida(PASSWORD_ERROR_1));
		assertFalse(Validator.esPasswordValida(PASSWORD_ERROR_2));
		assertFalse(Validator.esPasswordValida(PASSWORD_ERROR_3));
		assertFalse(Validator.esPasswordValida(PASSWORD_ERROR_4));
		assertFalse(Validator.esPasswordValida(PASSWORD_ERROR_5));
		assertFalse(Validator.esPasswordValida(PASSWORD_ERROR_6));
		assertFalse(Validator.esPasswordValida(PASSWORD_ERROR_7));

	}
}
