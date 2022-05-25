import java.util.List;

import controleMovimentacao.beans.Movimentacao;
import controleMovimentacao.model.MovimentacaoDAO;

public class MovimentacaoRN {
	MovimentacaoDAO movimentacaoDAO;
	
	public boolean insertMovimentacao(Movimentacao movimentacao) {
		return movimentacaoDAO.insertMovimentacao(movimentacao);
	}

	public boolean deleteMovimentacao(int id) {
		return movimentacaoDAO.deleteMovimentacao(id);
	}

	public Movimentacao getMovimentacao(int id) {
		return movimentacaoDAO.getMovimentacao(id);
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacaoDAO.getMovimentacoes();
	}
}