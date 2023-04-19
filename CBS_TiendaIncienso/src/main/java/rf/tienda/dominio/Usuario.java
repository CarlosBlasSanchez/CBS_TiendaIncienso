package rf.tienda.dominio;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import rf.tienda.util.Validator;

@Entity
@Table(name = "Usuario", schema = "CBS_ALUMNO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "Id_usuario", nullable = false)
	private int id_usuario;

	@Column(name = "Usuario_nombre", nullable = false)
	private String user_nombre;

	@Column(name = "Usuario_email", nullable = false)
	private String user_email;

	@Column(name = "Usuario_pass", nullable = false)
	private String user_pass;

	@Column(name = "Id_tipo", nullable = false)
	private int id_tipo;// tipo_usuario;

	@Column(name = "Usuario_dni")
	private String user_dni;// numero_dni;

	@Column(name = "Usuario_fecAlta")
	private LocalDate user_fecAlta;// user fecha de alta

	@Column(name = "Usuario_fecConfirmacion")
	private LocalDate user_fecConfirmacion;

	public Usuario() {

	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUser_nombre() {
		return user_nombre;
	}

	public void setUser_nombre(String user_nombre) {
		if (Validator.cumpleLongitud(user_nombre, 5, 100))
			this.user_nombre = user_nombre;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		if (Validator.cumpleLongitud(user_email, 6, 100) && Validator.isEmailValido(user_email))
			this.user_email = user_email;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		if (Validator.cumpleLongitud(user_pass, 8, 20) && Validator.esPasswordValida(user_pass))
			this.user_pass = user_pass;
	}

	public int getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}

	public String getUser_dni() {
		return user_dni;
	}

	public void setUser_dni(String user_dni) {
		if (Validator.cumpleLongitud(user_dni, 12, 12) && Validator.cumpleDNI(user_dni))
			this.user_dni = user_dni;
	}

	public LocalDate getUser_fecAlta() {
		return user_fecAlta;
	}

	public void setUser_fecAlta(LocalDate user_fecAlta) {
		if (Validator.valDateMin(user_fecAlta, LocalDate.now()))
			this.user_fecAlta = user_fecAlta;
	}

	public LocalDate getUser_fecConfirmacion() {
		return user_fecConfirmacion;
	}

	public void setUser_fecConfirmacion(LocalDate user_fecConfirmacion) {
		if (Validator.valDateMin(user_fecConfirmacion, LocalDate.now()))
			this.user_fecConfirmacion = user_fecConfirmacion;
	}

	public Direccion getUser_pago() {
		return user_pago;
	}

	public void setUser_pago(Direccion user_pago) {
		this.user_pago = user_pago;
	}

	public Direccion getUser_envio() {
		return user_envio;
	}

	public void setUser_envio(Direccion user_envio) {
		this.user_envio = user_envio;
	}

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "dir_nombre", column = @Column(name = "dir_nombre_pago")),
			@AttributeOverride(name = "dir_direccion", column = @Column(name = "dir_direccion_pago")),
			@AttributeOverride(name = "dir_poblacion", column = @Column(name = "dir_poblacion_pago")),
			@AttributeOverride(name = "dir_cPostal", column = @Column(name = "dir_cPostal_pago")),
			@AttributeOverride(name = "dir_provincia", column = @Column(name = "dir_provincia_pago")),
			@AttributeOverride(name = "dir_pais", column = @Column(name = "dir_pais_pago")),
			@AttributeOverride(name = "dir_correo", column = @Column(name = "dir_correo_pago")) })
	private Direccion user_pago;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "dir_nombre", column = @Column(name = "dir_nombre_envio")),
			@AttributeOverride(name = "dir_direccion", column = @Column(name = "dir_direccion_envio")),
			@AttributeOverride(name = "dir_poblacion", column = @Column(name = "dir_poblacion_envio")),
			@AttributeOverride(name = "dir_cPostal", column = @Column(name = "dir_cPostal_envio")),
			@AttributeOverride(name = "dir_provincia", column = @Column(name = "dir_provincia_envio")),
			@AttributeOverride(name = "dir_pais", column = @Column(name = "dir_pais_envio")),
			@AttributeOverride(name = "dir_correo", column = @Column(name = "dir_correo_envio")) })
	private Direccion user_envio;
}