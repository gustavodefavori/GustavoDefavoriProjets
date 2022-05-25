package controleMovimentacao.beans;

import java.util.Date;

public class Movimentacao {
	private int id;
	private Date dtInicio;
	private Date dtFim;
	private Conteiner conteiner;
	private TipoMovimentacao tipoMovimentacao;
	private Funcionario funcionario;
	
	public Movimentacao () {
		this.conteiner = new Conteiner();
		this.tipoMovimentacao = new TipoMovimentacao();
		this.funcionario = new Funcionario();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Date getDtFim() {
		return dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	public Conteiner getConteiner() {
		return conteiner;
	}

	public void setConteiner(Conteiner conteiner) {
		this.conteiner = conteiner;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
