package controleMovimentacao.controller;

import java.util.List;

import controleMovimentacao.beans.Funcionario;
import controleMovimentacao.model.FuncionarioDAO;

public class FuncionarioRN {
	FuncionarioDAO funcionarioDAO;
	
	public boolean insertFuncionario(Funcionario funcionario) {
		return funcionarioDAO.insertFuncionario(funcionario);
	}

	public boolean deleteFuncionario(int id) {
		return funcionarioDAO.deleteFuncionario(id);
	}

	public Funcionario getFuncionario(int id) {
		return funcionarioDAO.getFuncionario(id);
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarioDAO.getFuncionarios();
	}
}