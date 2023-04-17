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

@Entity
@Table ( name = "usuario", schema = "CBS_ALUMNO")
public class Usuario implements Serializable{

@Id

@GeneratedValue(strategy=GenerationType.AUTO)

@Column(name = "id_usuario")
private int id_usuario;

@Column(name = "user_nombre")
private String user_nombre;

@Column(name = "user_email")
private String user_email;

@Column(name = "user_pass")
private String user_pass;

@Column(name = "id_tipo")
private int id_tipo;//tipo_usuario;

@Column(name = "user_dni")
private String user_dni;//numero_dni;

@Column(name = "user_fecAlta")
private LocalDate user_fecAlta;//user fecha de alta

@Column(name = "user_fecConfirmacion")
private LocalDate user_fecConfirmacion;

@Embedded
@Column

//datos de pago y datos de direccion envio

private Direccion user_pago;

@AttributeOverrides({

@AttributeOverride(name ="dir_nombre", column= @Column(name="dir_nombre_pago")),

@AttributeOverride(name ="dir_nombre", column= @Column(name="dir_nombre_envio")),

})

private Direccion user_envio;
}
