/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 *
 * @author Chema
 */
@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String clave;
    @OneToMany(mappedBy = "usuario" , fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Rol> roles = new HashSet<>();

    public Usuario() {
    }

    public Usuario(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
     public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.nombre != other.nombre && (this.nombre == null || !this.nombre.equals(other.nombre))) {
            return false;
        }
        return !(this.clave != other.clave && (this.clave == null || !this.clave.equals(other.clave)));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.nombre != null ? this.nombre.hashCode() : 0);
        hash = 67 * hash + (this.clave != null ? this.clave.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return String.format("La clave del usuario %s es %s y su id es %d", getNombre(), getClave(), getId());
    }
}
