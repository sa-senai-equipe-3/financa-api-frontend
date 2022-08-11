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

import br.com.senai.financaapi.dto.Fornecedor;

@Component
public class FornecedorClient {
	
	@Value("${endpoint}")
	private String urlEndpoint;
	
	@Autowired
	private ObjectMapper mapper;
	
	private final String resource = "/fornecedor";
	
	@Autowired
	private RestTemplateBuilder builder;
	
	public Fornecedor inserir(
			Fornecedor novoFornecedor) {
		
		RestTemplate httpClient = builder.build();
		
		URI uri = httpClient.postForLocation(
				urlEndpoint + resource, novoFornecedor);
		
		Fornecedor fornecedorSalvo = httpClient
				.getForObject(urlEndpoint + uri.getPath(),
						Fornecedor.class);
		
		return fornecedorSalvo;
		
	}
	
	public void alterar(Fornecedor fornecedorSalvo) {
		RestTemplate httpClient = builder.build();
		httpClient.put(urlEndpoint + resource, 
				fornecedorSalvo);
	}
	
	public List<Fornecedor> listar() {
		RestTemplate httpClient = builder.build();
		List<LinkedHashMap<String, Object>> response = httpClient.getForObject(urlEndpoint + resource, 
				List.class);
		
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		
		for (LinkedHashMap<String, Object> item : response) {
			Fornecedor fornecedor = mapper.convertValue(item, Fornecedor.class);
			fornecedores.add(fornecedor);
		}
		
		return fornecedores;
	}
	
	public void excluir(Fornecedor fornecedorSalvo) {
		RestTemplate httpClient = builder.build();
		httpClient.delete(urlEndpoint + resource 
				+ "/id/" + fornecedorSalvo.getId());
	}
	
	@SuppressWarnings("unchecked")
	public List<Fornecedor> listarPor(String nomeFantasia){
		
		RestTemplate httpClient = builder.build();
		
		List<LinkedHashMap<String, Object>> response = httpClient.getForObject(
				urlEndpoint + resource + "/nome-fantasia/" + nomeFantasia, List.class);
		
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		
		for (LinkedHashMap<String, Object> item : response) {
			Fornecedor fornecedor = mapper.convertValue(item, Fornecedor.class);
			fornecedores.add(fornecedor);
		}
		
		return fornecedores;
	}
	
	@GetMapping
	public List<Fornecedor> buscarPor(Integer id) {
		RestTemplate httpClient = builder.build();
		
		List<LinkedHashMap<String, Object>> response = httpClient.getForObject(
				urlEndpoint + resource + "/id/" + id, List.class);
		
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		
		for (LinkedHashMap<String, Object> item : response) {
			Fornecedor fornecedor = mapper.convertValue(item, Fornecedor.class);
			fornecedores.add(fornecedor);
		}
		
		return fornecedores;
	}

}

