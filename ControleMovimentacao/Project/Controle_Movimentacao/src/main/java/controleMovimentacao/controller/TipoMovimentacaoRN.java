package controleMovimentacao.controller;

import java.util.List;

import controleMovimentacao.beans.TipoMovimentacao;
import controleMovimentacao.model.TipoMovimentacaoDAO;

public class TipoMovimentacaoRN {
	TipoMovimentacaoDAO tipoMovimentacaoDAO;
	
	public boolean insertTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		return tipoMovimentacaoDAO.insertTipoMovimentacao(tipoMovimentacao);
	}
	
	public boolean deleteTipoMovimentacao(int codigo) {
		return tipoMovimentacaoDAO.deleteTipoMovimentacao(tipoMovimentacao);
	}
	
	public TipoMovimentacao getTipoMovimentacao(int codigo) {
		return tipoMovimentacaoDAO.getTipoMovimentacao(codigo);
	}
	
	public List<TipoMovimentacao> getTiposMovimentacao() {
		return tipoMovimentacaoDAO.getTiposMovimentacao();
	}

}