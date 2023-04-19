package rf.tienda.dominio;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import rf.tienda.exception.DomainException;
import rf.tienda.util.Validator;

@Entity
@Table(name = "Pedido_Carrito", schema = "CBS_ALUMNO")
public class PedidoCarrito {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "Id_pedido")
	private int id_pedido;

	@Column(name = "Id_cliente", nullable = false)
	private int id_cliente;

	@Column(name = "Código_producto_pedido", nullable = false)
	private String codigo_producto_cliente;

	@Column(name = "Cantidad_producto", nullable = false)
	private int cantidad_producto;

	@Column(name = "Precio_linea_de_pedido")
	private double precio_linea_de_pedido;

	@Column(name = "Numero_tarjeta_credito")
	private String numero_tarjeta_credito;

	@Column(name = "Fecha_caducidad_tarjeta")
	private LocalDate fecha_caducidad_tarjeta;

	@Column(name = "CCV_tarjeta_credito")
	private int ccv_tarjeta_credito;

	@Column(name = "Nombre_titular_tarjeta")
	private String nombre_titular_tarjeta;

	@Column(name = "Estado_carrito")
	private int estado_carrito;

	@Column(name = "Fechas_cambio")
	private String[] fechas_cambio;

	public PedidoCarrito() {

	}

	public int getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getCodigo_producto_cliente() {
		return codigo_producto_cliente;
	}

	public void setCodigo_producto_cliente(String codigo_producto_cliente) {
		this.codigo_producto_cliente = codigo_producto_cliente;
	}

	public int getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(int cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}

	public double getPrecio_linea_de_pedido() {
		return precio_linea_de_pedido;
	}

	public void setPrecio_linea_de_pedido(double precio_linea_de_pedido) {
		this.precio_linea_de_pedido = precio_linea_de_pedido;
	}

	public Direccion getDatos_envio() {
		return datos_envio;
	}

	public void setDatos_envio(Direccion datos_envio) {
		this.datos_envio = datos_envio;
	}

	public Direccion getDatos_pago() {
		return datos_pago;
	}

	public void setDatos_pago(Direccion datos_pago) {
		this.datos_pago = datos_pago;
	}

	public String getNumero_tarjeta_credito() {
		return numero_tarjeta_credito;
	}

	public void setNumero_tarjeta_credito(String numero_tarjeta_credito) throws DomainException {
		if (Validator.cumpleLongitud(numero_tarjeta_credito, 16, 16))
			this.numero_tarjeta_credito = numero_tarjeta_credito;
		else
			throw new DomainException("Error");
	}

	public LocalDate getFecha_caducidad_tarjeta() {
		return fecha_caducidad_tarjeta;
	}

	public void setFecha_caducidad_tarjeta(LocalDate fecha_caducidad_tarjeta) throws DomainException {
		if (Validator.valDateMin(fecha_caducidad_tarjeta, LocalDate.now()))
			this.fecha_caducidad_tarjeta = fecha_caducidad_tarjeta;
		else
			throw new DomainException("Error");
	}

	public int getCcv_tarjeta_credito() {
		return ccv_tarjeta_credito;
	}

	public void setCcv_tarjeta_credito(int ccv_tarjeta_credito) throws DomainException {
		if (Validator.cumpleLongitud(codigo_producto_cliente, 3, 3))
			this.ccv_tarjeta_credito = ccv_tarjeta_credito;
		else
			throw new DomainException("Error");
	}

	public String getNombre_titular_tarjeta() {
		return nombre_titular_tarjeta;
	}

	public void setNombre_titular_tarjeta(String nombre_titular_tarjeta) {
		this.nombre_titular_tarjeta = nombre_titular_tarjeta;
	}

	public int getEstado_carrito() {
		return estado_carrito;
	}

	public void setEstado_carrito(int estado_carrito) {
		this.estado_carrito = estado_carrito;
	}

	public String[] getFechas_cambio() {
		return fechas_cambio;
	}

	public void setFechas_cambio(String[] fechas_cambio) {
		this.fechas_cambio = fechas_cambio;
	}

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "dir_nombre", column = @Column(name = "dir_nombre_pago")),
			@AttributeOverride(name = "dir_direccion", column = @Column(name = "dir_direccion_pago")),
			@AttributeOverride(name = "dir_poblacion", column = @Column(name = "dir_poblacion_pago")),
			@AttributeOverride(name = "dir_cPostal", column = @Column(name = "dir_cPostal_pago")),
			@AttributeOverride(name = "dir_provincia", column = @Column(name = "dir_provincia_pago")),
			@AttributeOverride(name = "dir_pais", column = @Column(name = "dir_pais_pago")),
			@AttributeOverride(name = "dir_correo", column = @Column(name = "dir_correo_pago")) })
	private Direccion datos_pago;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "dir_nombre", column = @Column(name = "dir_nombre_envio")),
			@AttributeOverride(name = "dir_direccion", column = @Column(name = "dir_direccion_envio")),
			@AttributeOverride(name = "dir_poblacion", column = @Column(name = "dir_poblacion_envio")),
			@AttributeOverride(name = "dir_cPostal", column = @Column(name = "dir_cPostal_envio")),
			@AttributeOverride(name = "dir_provincia", column = @Column(name = "dir_provincia_envio")),
			@AttributeOverride(name = "dir_pais", column = @Column(name = "dir_pais_envio")),
			@AttributeOverride(name = "dir_correo", column = @Column(name = "dir_correo_envio")) })
	private Direccion datos_envio;
}
