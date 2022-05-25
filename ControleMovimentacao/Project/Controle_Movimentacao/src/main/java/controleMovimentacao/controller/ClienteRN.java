package controleMovimentacao.controller;

import java.util.List;

import controleMovimentacao.beans.Cliente;
import controleMovimentacao.model.ClienteDAO;

public class ClienteRN {
	ClienteDAO clienteDAO;
	
	public boolean insertCliente(Cliente cliente) {
		return clienteDAO.insertCliente(cliente);
	}

	public boolean deleteCliente(int id) {
		return clienteDAO.deleteCliente(id);
	}

	public Cliente getCliente(int id) {
		return clienteDAO.getCliente(id);
	}

	public List<Cliente> getClientes() {
		return clienteDAO.getClientes();
	}
}