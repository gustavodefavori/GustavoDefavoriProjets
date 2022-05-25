package controleMovimentacao.beans;

import java.util.Date;

public class Funcionario {
	private int id;
	private String nome;
	private String cpf;
	private Date dtnascimento;
	
	public Funcionario () {
		this.nome ="";
		this.cpf = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDtnascimento() {
		return dtnascimento;
	}

	public void setDtnascimento(Date dtnascimento) {
		this.dtnascimento = dtnascimento;
	}
}
