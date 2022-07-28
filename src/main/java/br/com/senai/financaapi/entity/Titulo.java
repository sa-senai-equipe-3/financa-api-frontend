package br.com.senai.financaapi.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity(name = "Titulo")
@Table(name = "titulo")
public class Titulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "valor")
	@NotNull(message = "O valor do titulo não pode ser nulo")
	private BigDecimal valor;

	@Column(name = "data_vencimento")
	@NotNull(message = "A data de vencimento não pode ser nula")
	private LocalDate dataVencimento;

	@Column(name = "nome_banco")
	@NotEmpty(message = "O nome do banco não pode ser vazio")
	@Size(max = 20, message = "O nome do banco do titulo não deve conter mais que 20 caracteres")
	private String nomeBanco;

	@Column(name = "descricao")
	@NotEmpty(message = "A descricao do titulo não pode ser vazia")
	@Size(max = 1500, message = "A descricao do titulo não deve conter mais que 1500 caracteres")
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "fornecedor_id", nullable = false)
	private Fornecedor fornecedor;

}