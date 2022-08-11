package br.com.senai.financaapi.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.senai.financaapi.dto.Titulo;

@Component
public class TituloClient {

	@Value("${endpoint}")
	private String urlEndpoint;
	
	@Autowired
	private ObjectMapper mapper;
	
	private final String resource = "/titulo";
	
	@Autowired
	private RestTemplateBuilder builder;
	
	public Titulo inserir(
			Titulo novoTitulo) {
		
		RestTemplate httpClient = builder.build();
		
		URI uri = httpClient.postForLocation(
				urlEndpoint + resource, novoTitulo);
		
		Titulo tituloSalvo = httpClient
				.getForObject(urlEndpoint + uri.getPath(),
						Titulo.class);
		
		return novoTitulo;
	}
	
	public void alterar(Titulo tituloSalvo) {
		RestTemplate httpClient = builder.build();
		httpClient.put(urlEndpoint + resource, 
				tituloSalvo);
	}
	
	public List<Titulo> listar() {
		RestTemplate httpClient = builder.build();
		List<LinkedHashMap<String, Object>> response = httpClient.getForObject(urlEndpoint + resource, 
				List.class);
		
		List<Titulo> titulos = new ArrayList<Titulo>();
		
		for (LinkedHashMap<String, Object> item : response) {
			Titulo titulo = mapper.convertValue(item, Titulo.class);
			titulos.add(titulo);
		}
		
		return titulos;
	}
	
	public void excluir(Titulo tituloSalvo) {
		RestTemplate httpClient = builder.build();
		httpClient.delete(urlEndpoint + resource 
				+ "/id/" + tituloSalvo.getId());
	}
	
	@GetMapping
	public List<Titulo> buscarPor(Integer id) {
		RestTemplate httpClient = builder.build();
		
		List<LinkedHashMap<String, Object>> response = httpClient.getForObject(
				urlEndpoint + resource + "/id/" + id, List.class);
		
		List<Titulo> titulos = new ArrayList<Titulo>();
		
		for (LinkedHashMap<String, Object> item : response) {
			Titulo titulo = mapper.convertValue(item, Titulo.class);
			titulos.add(titulo);
		}
		
		return titulos;
	}
	
	@SuppressWarnings("unchecked")
	public List<Titulo> listarPor(String descricaoTitulo) {
		
		RestTemplate httpClient = builder.build();
		
		List<LinkedHashMap<String, Object>> response = httpClient.getForObject(
				urlEndpoint + resource + "/descricao/" + descricaoTitulo, List.class);
		
		List<Titulo> titulos = new ArrayList<Titulo>();
		
		for (LinkedHashMap<String, Object> item : response) {
			Titulo titulo = mapper.convertValue(item, Titulo.class);
			titulos.add(titulo);
		}
		
		return titulos;
	}

}


