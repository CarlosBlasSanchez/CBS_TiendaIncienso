package rf.tienda.util;

public class dd {

	public static void main(String[] args) {
		String fecha="12-12-2012";
		String dia = fecha.substring(0, 2);
		String mes = fecha.substring(3, 5);
		String anio= fecha.substring(6, 10);
		System.out.println(dia+" "+mes+" "+anio);
	}

}
