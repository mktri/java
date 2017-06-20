/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import beans.Rol;
import beans.Usuario;
import static java.lang.reflect.Array.set;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateHook;
import util.HibernateUtil;

/**
 *
 * @author Chema
 */
public class Principal {

    private SessionFactory sessionFactory;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Principal p = new Principal();
        p.inicializarHibernate();
        p.crearUsuario();
//        p.actualizarRol(1l);
        
        
//        p.mostrarUsuarios();
//        p.actualizarUsuario(usuario.getId());
//        p.mostrarUsuarios();
//        p.borrarUsuario(usuario.getId());
//        p.mostrarUsuarios();

    }
    
//        private void actualizarRol(Long id) {
//        Session session = null;
//        try {
//            session = sessionFactory.getCurrentSession();
//            session.getTransaction().begin();
//            Usuario usuario = (Usuario) session.load(Usuario.class, id);
//            
//            Rol rol1 = new Rol("Programador",1l);
//            Rol rol2 = new Rol("Tecnico",2l);
//            usuario = new Usuario("Usuario1","Clave1");
//            usuario.getRoles().add(rol2);
//            usuario.getRoles().add(rol1);
//            rol2.setUsuario(usuario);
//            
//            usuario.setNombre("Nombre actualizado");
//            session.getTransaction().commit();
//        } catch (HibernateException hibernateException) {
//            if (session != null) {
//                session.getTransaction().rollback();
//            }
//            System.out.println("Ha ocurrido un error " + hibernateException);
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//    }
    

    private void actualizarUsuario(Long id) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.getTransaction().begin();
            Usuario usuario = (Usuario) session.load(Usuario.class, id);
            usuario.setNombre("Nombre actualizado");
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            System.out.println("Ha ocurrido un error " + hibernateException);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    private void borrarUsuario(Long id) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.getTransaction().begin();
            Usuario usuario = (Usuario) session.load(Usuario.class, id);
            session.delete(usuario);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            System.out.println("Ha ocurrido un error " + hibernateException);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    private Usuario crearUsuario() {
        Session session = null;
        Usuario usuario = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.getTransaction().begin();
            usuario = new Usuario("Uno", "clave uno");
            Rol rol1 = new Rol("Programador");
            Rol rol2 = new Rol("Tecnico");
            usuario.getRoles().add(rol2);
            usuario.getRoles().add(rol1);
            rol2.setUsuario(usuario);
            rol1.setUsuario(usuario);
            
            session.persist(usuario);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            System.out.println("Ha ocurrido un error " + hibernateException);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return usuario;
    }

    private void mostrarUsuarios() {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.getTransaction().begin();
            Query query = session.createQuery("from Usuario");
            List<Usuario> usuarios = query.list();
            if (usuarios.isEmpty()) {
                System.out.println("No hay usuarios que mostrar");
            } else {
                for (Usuario usuario : usuarios) {
                    System.out.println(usuario);
                }
            }
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            System.out.println("Ha ocurrido un error " + hibernateException);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    private void inicializarHibernate() {
        Runtime.getRuntime().addShutdownHook(new HibernateHook());
        sessionFactory = HibernateUtil.getSessionFactory();
    }
}
