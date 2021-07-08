package access_interfaces;

import java.util.List;

import model.Usuario;


public interface IUsuarioDAO {
	public List<Usuario> getAllFields() throws Exception;
	
	public void agregar(Usuario unUsuario) throws Exception;
	
	public Usuario findById(Long id);
	public Boolean findByEmail(String email);
	public void delete (Usuario unUsuario);
}
