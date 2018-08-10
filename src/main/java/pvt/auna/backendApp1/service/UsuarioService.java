package pvt.auna.backendApp1.service;


import java.util.List;

import pvt.auna.backendApp1.modelo.Usuario;

public interface UsuarioService{
	
	void save(Usuario usuario);
	List<Usuario> findAll();
	
}
