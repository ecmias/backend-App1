package pvt.auna.backendApp1.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pvt.auna.backendApp1.modelo.Usuario;
import pvt.auna.backendApp1.service.UsuarioService;
import pvt.auna.backendApp1.util.RestResponse;

@RestController
public class UsuarioController {

	@Autowired
	protected UsuarioService usuarioService;

	protected ObjectMapper mapper;

	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String usuarioJson)
			throws JsonParseException, JsonMappingException, IOException {
		this.mapper=new ObjectMapper();
		Usuario usuario = this.mapper.readValue(usuarioJson, Usuario.class);
		if (!this.validate(usuario)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Verifique los datos enviados");
		}
		usuarioService.save(usuario);
		return new RestResponse(HttpStatus.OK.value(),"Operacion Existosa");
	}

	private boolean validate(Usuario usuario) {
		boolean isValid = true;
		if (usuario.getNombres() == null || usuario.getNombres().isEmpty()) {
			isValid = false;
		} else if (usuario.getApellidoPaterno() == null || usuario.getApellidoPaterno().isEmpty()) {
			isValid = false;
		} else if (usuario.getApellidoMaterno() == null || usuario.getApellidoPaterno().isEmpty()) {
			isValid = false;
		}
		return isValid;
	}
}
