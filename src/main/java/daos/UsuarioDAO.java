package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;


import model.Usuario;
import access_interfaces.IUsuarioDAO;

public class UsuarioDAO implements IUsuarioDAO{
	@PersistenceContext(unitName = "per")
	private static EntityManager manager;
	private static EntityManagerFactory emf ;
	@Override
	public void agregar(Usuario user) throws Exception {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("per");
		}
		manager = emf.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(user); 
		manager.getTransaction().commit();
		manager.close();
	}
	public List<Usuario> getAllFields() throws Exception {
    	if (emf == null) {
    	emf = Persistence.createEntityManagerFactory("per");
    	}
    	manager = emf.createEntityManager();
    	manager.getTransaction().begin();
		List<Usuario> usuarios=(List<Usuario>)(manager.createQuery("from model.Usuario u")).getResultList();
		manager.close();
	
		return usuarios;
	}
	
	public Usuario findById(Long id) {
		if (emf == null) {
	    	emf = Persistence.createEntityManagerFactory("per");
	    	}
	    manager = emf.createEntityManager();
        return manager.find(Usuario.class, id);
    }
	
	
	public Boolean findByEmail(String email) {
		if (emf == null) {
	    	emf = Persistence.createEntityManagerFactory("per");
	    	}
	    manager = emf.createEntityManager();
	    Boolean existe = false;
	    List<Usuario> usuarios=(List<Usuario>)(manager.createQuery("from model.Usuario u WHERE u.email = '" + email + "'")).getResultList();
	  //  (List<Usuario>) user = (List<Usuario>)(manager.createQuery("from model.Usuario u WHERE u.email = '" + email + "'"));
	    
	    if (usuarios.isEmpty()) {
	    	existe = true;
	    }
	return existe;
			  
	}
	
	
	public void delete (Usuario unUsuario) {
		if (emf == null) {
	    	emf = Persistence.createEntityManagerFactory("per");
	    	}
	    manager = emf.createEntityManager();
	    
	    
	   Usuario usuario = manager.find(Usuario.class, unUsuario.getId());

	    manager.getTransaction().begin();
	    manager.remove(usuario);
	    manager.getTransaction().commit();
	}
	
	public void update(Usuario usuario) {
		if (emf == null) {
	    	emf = Persistence.createEntityManagerFactory("per");
	    	}
	    manager = emf.createEntityManager();
	    manager.getTransaction().begin();
	    manager.merge(usuario);
	  //modify person if you wish.
	    manager.getTransaction().commit();
	}
}
