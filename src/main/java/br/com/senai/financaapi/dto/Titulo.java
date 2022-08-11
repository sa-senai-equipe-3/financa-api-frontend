package br.com.senai.financaapi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Titulo {

	@EqualsAndHashCode.Include
	private Integer id;
	
	private BigDecimal valor;
	
	private LocalDate dataVencimento;
	
	private String nomeBanco;
	
	private String descricao;
	
	private Fornecedor fornecedor;
	
}
