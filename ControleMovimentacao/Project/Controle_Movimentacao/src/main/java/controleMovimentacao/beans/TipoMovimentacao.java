package controleMovimentacao.beans;

public class TipoMovimentacao {
	private int id;
	private String descricao;
	private String tipo;
	
	public TipoMovimentacao () {
		this.descricao = "";
		this.tipo = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
