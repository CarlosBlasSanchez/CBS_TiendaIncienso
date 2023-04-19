package rf.tienda.dominio;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import rf.tienda.util.Validator;

@Entity
@Table(name = "Producto", schema = "CBS_ALUMNO")
public class Producto {

	@Id
	@Column(name = "Id_producto", nullable = false)
	private String id_producto;

	@Column(name = "Descripción_corta", nullable = false)
	private String descripcion_corta;

	@Column(name = "Explicaión")
	private String explicacion;

	@Column(name = "Precio", nullable = false)
	private double precio;

	@Column(name = "Stock")
	private int stock;

	@Column(name = "Fecha_prevista_reposición")
	private LocalDate fecha_prevista_reposición;

	@Column(name = "Fecha_activación")
	private LocalDate fecha_activacion;

	@Column(name = "Fecha_desactivación")
	private LocalDate fecha_desactivación;

	@Column(name = "Unidad_venta", nullable = false)
	private String unidad_venta;

	@Column(name = "Cantidad_unidades_ultimas")
	private double cantidad_unidades_ultimas;

	@Column(name = "Unidad_ultima")
	private String unidad_ultima;

	@Column(name = "Pais_origen", nullable = false)
	private int pais_origen;

	@Column(name = "Uso_recomendado")
	private String uso_recomendado;

	@Column(name = "Categoria", nullable = false)
	private int Categoria;

	@Column(name = "Stock_reservado")
	private int stock_reservado;

	@Column(name = "Stock_nivel_alto")
	private int stock_nivel_alto;

	@Column(name = "Stock_nivel_bajo")
	private int stock_nivel_bajo;

	@Column(name = "Estado")
	private char estado;

	public Producto() {

	}

	public String getId_producto() {
		return id_producto;
	}

	public void setId_producto(String id_producto) {
		if (Validator.cumpleLongitud(id_producto, 5, 5))
			this.id_producto = id_producto;
	}

	public String getDescripcion_corta() {
		return descripcion_corta;
	}

	public void setDescripcion_corta(String descripcion_corta) {
		if (Validator.cumpleLongitud(descripcion_corta, 5, 100))
			this.descripcion_corta = descripcion_corta;
	}

	public String getExplicacion() {
		return explicacion;
	}

	public void setExplicacion(String explicacion) {
		if (Validator.cumpleLongitud(explicacion, 5, 2000))
			this.explicacion = explicacion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		if (Validator.cumpleRango(precio, 100, 0))
			this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public LocalDate getFecha_prevista_reposición() {
		return fecha_prevista_reposición;
	}

	public void setFecha_prevista_reposición(LocalDate fecha_prevista_reposición) {
		if (Validator.valDateMin(LocalDate.now(), fecha_prevista_reposición))
			this.fecha_prevista_reposición = fecha_prevista_reposición;
	}

	public LocalDate getFecha_activacion() {
		return fecha_activacion;
	}

	public void setFecha_activacion(LocalDate fecha_activacion) {
		if (Validator.valDateMin(LocalDate.now(), fecha_activacion))
			this.fecha_activacion = fecha_activacion;
	}

	public LocalDate getFecha_desactivación() {
		return fecha_desactivación;
	}

	public void setFecha_desactivación(LocalDate fecha_desactivación) {
		if (Validator.valDateMin(LocalDate.now(), fecha_desactivación))
		this.fecha_desactivación = fecha_desactivación;
	}

	public String getUnidad_venta() {
		return unidad_venta;
	}

	public void setUnidad_venta(String unidad_venta) {
		if(Validator.cumpleLongitud(unidad_venta, 1, 10))
			this.unidad_venta = unidad_venta;
	}

	public double getCantidad_unidades_ultimas() {
		return cantidad_unidades_ultimas;
	}

	public void setCantidad_unidades_ultimas(double cantidad_unidades_ultimas) {
		this.cantidad_unidades_ultimas = cantidad_unidades_ultimas;
	}

	public String getUnidad_ultima() {
		return unidad_ultima;
	}

	public void setUnidad_ultima(String unidad_ultima) {
		this.unidad_ultima = unidad_ultima;
	}

	public int getPais_origen() {
		return pais_origen;
	}

	public void setPais_origen(int pais_origen) {
		this.pais_origen = pais_origen;
	}

	public String getUso_recomendado() {
		return uso_recomendado;
	}

	public void setUso_recomendado(String uso_recomendado) {
		if (Validator.cumpleLongitud(uso_recomendado, 0, 2000))
			this.uso_recomendado = uso_recomendado;
	}

	public int getCategoria() {
		return Categoria;
	}

	public void setCategoria(int categoria) {
		Categoria = categoria;
	}

	public int getStock_reservado() {
		return stock_reservado;
	}

	public void setStock_reservado(int stock_reservado) {
		this.stock_reservado = stock_reservado;
	}

	public int getStock_nivel_alto() {
		return stock_nivel_alto;
	}

	public void setStock_nivel_alto(int stock_nivel_alto) {
		this.stock_nivel_alto = stock_nivel_alto;
	}

	public int getStock_nivel_bajo() {
		return stock_nivel_bajo;
	}

	public void setStock_nivel_bajo(int stock_nivel_bajo) {
		this.stock_nivel_bajo = stock_nivel_bajo;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		if (Validator.cumpleLongitud(descripcion_corta, 1, 1))
		this.estado = estado;
	}

}
