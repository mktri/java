/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernatenuevo;
//import beans.Usuario;
import org.hibernate.SessionFactory;


/**
 *
 * @author Chema
 */
public class NewMain {

    private SessionFactory sessionFactory;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewMain nm = new NewMain();
        nm.inicializarHibernate();
//        Usuario usuario = p.crearUsuario();
//        p.mostrarUsuarios();
//        p.actualizarUsuario(usuario.getId());
//        p.mostrarUsuarios();
//        p.borrarUsuario(usuario.getId());
//        p.mostrarUsuarios();
    }

//    private void actualizarUsuario(Long id) {
//        Session session = null;
//        try {
//            session = sessionFactory.getCurrentSession();
//            session.getTransaction().begin();
//            Usuario usuario = (Usuario) session.load(Usuario.class, id);
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
//
//    private void borrarUsuario(Long id) {
//        Session session = null;
//        try {
//            session = sessionFactory.getCurrentSession();
//            session.getTransaction().begin();
//            Usuario usuario = (Usuario) session.load(Usuario.class, id);
//            session.delete(usuario);
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
//
//    private Usuario crearUsuario() {
//        Session session = null;
//        Usuario usuario = null;
//        try {
//            session = sessionFactory.getCurrentSession();
//            session.getTransaction().begin();
//            usuario = new Usuario("Uno", "clave uno");
//            session.persist(usuario);
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
//        return usuario;
//    }
//
//    private void mostrarUsuarios() {
//        Session session = null;
//        try {
//            session = sessionFactory.getCurrentSession();
//            session.getTransaction().begin();
//            Query query = session.createQuery("from Usuario");
//            List<Usuario> usuarios = query.list();
//            if (usuarios.isEmpty()) {
//                System.out.println("No hay usuarios que mostrar");
//            } else {
//                usuarios.forEach((usuario) -> {
//                    System.out.println(usuario);
//                });
//            }
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

    private void inicializarHibernate() {
        Runtime.getRuntime().addShutdownHook(new HibernateHook());
        sessionFactory = HibernateUtil.getSessionFactory();
    }
}
