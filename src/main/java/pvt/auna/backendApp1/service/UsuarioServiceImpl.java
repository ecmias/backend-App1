package pvt.auna.backendApp1.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import pvt.auna.backendApp1.modelo.Usuario;
import pvt.auna.backendApp1.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	protected UsuarioRepository usuarioRepository;

	@Override
	public void save(Usuario usuario) {
		// TODO Auto-generated method stub
		
		this.usuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return this.usuarioRepository.findAll();
	}

	@Override
	public void deleteUsuario(long id) {
		// TODO Auto-generated method stub
		this.usuarioRepository.deleteById(id);
		
	}

	
	
	

}
