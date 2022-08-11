package br.com.senai.financaapi.client;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.senai.financaapi.dto.Usuario;

@Component
public class UsuarioClient {
	
	@Value("${endpoint}")
	private String urlEndpoint;
	
	@Autowired
	private ObjectMapper mapper;
	
	private final String resource = "/usuario";
	
	@Autowired
	private RestTemplateBuilder builder;
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {
		RestTemplate httpClient = builder.build();
		List<LinkedHashMap<String, Object>> response = httpClient.getForObject(
				urlEndpoint + resource, List.class);
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		for (LinkedHashMap<String, Object> item : response) {
			Usuario usuario = mapper.convertValue(item, Usuario.class);
			usuarios.add(usuario);
		}
		
		return usuarios;
	}

}
