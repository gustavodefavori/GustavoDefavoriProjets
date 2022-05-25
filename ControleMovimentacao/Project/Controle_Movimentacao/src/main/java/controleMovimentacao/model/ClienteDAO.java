package controleMovimentacao.model;

import controleMovimentacao.beans.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxSql.StmtExecute;

public class ClienteDAO {
	private ResultSet res;
	private String SQL;
	private PreparedStatement stm;
	private Connection conexao;

	public boolean insertCliente(Cliente cliente) {
			int cont = 1;
			
			try {
				SQL = "INSERT INTO Cliente (cli_id, cli_cnpj, cli_razaosocial, cli_endereco, cli_bairro, cli_cidade, cli_estado, cli_cep, cli_responsavel, cli_email) "
						+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";			
						
				stm = conexao.prepareStatement(SQL);
				res = stm.executeQuery();
				
				stm.setInt(cont++, cliente.getId());
				stm.setString(cont++, cliente.getCnpj());
				stm.setString(cont++, cliente.getRazaoSocial());
				stm.setString(cont++, cliente.getEndereco());
				stm.setString(cont++, cliente.getBairro());
				stm.setString(cont++, cliente.getCidade());
				stm.setString(cont++, cliente.getEstado());
				stm.setString(cont++, cliente.getCep());
				stm.setString(cont++, cliente.getResponsavel());
				stm.setString(cont++, cliente.getEmail());
				
				
				stm.execute();
				stm.close();
				conexao.close();
				
				return true;
				
			} catch (SQLException ex) {
				
			}
			
			return false;
		}

	public boolean deleteCliente(int id) {
		int cont = 1;

		try {
			SQL = "DELETE FROM Cliente " + " WHERE cliente_id = " + id;

			stm = conexao.prepareStatement(SQL);
			res = stm.executeQuery();

			stm.setInt(cont++, id);

			stm.execute();
			stm.close();
			conexao.close();
			return true;

		} catch (SQLException ex) {

		}

		return false;
	}

	public Cliente getCliente(int id) {
		Cliente cl = new Cliente();

		try {
			SQL = "SELECT cli_id, cli_cnpj, cli_razaosocial, cli_endereco, cli_bairro, cli_cidade, cli_estado, cli_cep, cli_responsavel, cli_email"
					+ " FROM Cliente " + " WHERE cli_id = " + id;

			stm = conexao.prepareStatement(SQL);
			res = stm.executeQuery();

			while (res.next()) {
				cl.setId(res.getInt("cli_id"));
				cl.setCnpj(res.getString("cli_cnpj"));
				cl.setRazaoSocial(res.getString("cli_razaosocial"));
				cl.setEndereco(res.getString("cli_endereco"));
				cl.setBairro(res.getString("cli_bairro"));
				cl.setCidade(res.getString("cli_cidade"));
				cl.setEstado(res.getString("cli_estado"));
				cl.setCep(res.getString("cli_cep"));
				cl.setResponsavel(res.getString("cli_responsavel"));
				cl.setEmail(res.getString("cli_email"));
			}
			stm.close();
			conexao.close();

		} catch (SQLException ex) {

		}

		return cl;
	}

	public List<Cliente> listCliente() {
		List<Cliente> listCL;
		listCL = new ArrayList<Cliente>();

		SQL = "SELECT mvt_tmp_id, mvt_tipo, mvt_dtinicio, mvt_dtfim, mvt_cnt_num, mvt_fun_id" + " FROM Cliente ";

		try {
			stm = conexao.prepareStatement(SQL);
			res = stm.executeQuery();

			while (res.next()) {
				Cliente cl= new Cliente();
				cl.setId(res.getInt("cli_id"));
				cl.setCnpj(res.getString("cli_cnpj"));
				cl.setRazaoSocial(res.getString("cli_razaosocial"));
				cl.setEndereco(res.getString("cli_endereco"));
				cl.setBairro(res.getString("cli_bairro"));
				cl.setCidade(res.getString("cli_cidade"));
				cl.setEstado(res.getString("cli_estado"));
				cl.setCep(res.getString("cli_cep"));
				cl.setResponsavel(res.getString("cli_responsavel"));
				cl.setEmail(res.getString("cli_email"));
				
				listCL.add(cl);
			}
			stm.close();
			conexao.close();

		} catch (SQLException ex) {

		}

		return listCL;
	}
}