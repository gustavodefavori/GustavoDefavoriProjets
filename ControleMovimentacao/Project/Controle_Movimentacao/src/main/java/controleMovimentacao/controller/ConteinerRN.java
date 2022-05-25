package controleMovimentacao.controller;

import java.util.List;

import controleMovimentacao.beans.Conteiner;
import controleMovimentacao.model.ConteinerDAO;

public class ConteinerRN {
	ConteinerDAO conteinerDAO;
	public boolean insertConteiner(Conteiner conteiner) {
		return conteinerDAO.insertConteiner(conteiner);
	}

	public boolean deleteConteiner(String numero) {
		return conteinerDAO.deleteConteiner(numero);
	}

	public Conteiner getTipoMovimentacao(String numero) {
		return conteinerDAO.getTipoMovimentacao(numero);
	}

	public List<Conteiner> getTiposMovimentacao() {
		return conteinerDAO.getTiposMovimentacao();
	}
}
