package controleMovimentacao.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import controleMovimentacao.beans.Funcionario;

public class FuncionarioDAO {
	private ResultSet res;
	private String SQL;
	private PreparedStatement stm;
	private Connection conexao;
	
	public boolean insertFuncionario(Funcionario funcionario) {
		int cont = 1;
		
		try {
			SQL = "INSERT INTO Funcionario (fun_id, fun_nome, fun_cpf, fun_dtnasc) "
										+ " VALUES (?, ?, ?,?) ";	
								
			stm = conexao.prepareStatement(SQL);
			res = stm.executeQuery();
			
			stm.setInt(cont++, funcionario.getId());
			stm.setString(cont++, funcionario.getNome());
			stm.setString(cont++, funcionario.getCpf());
			stm.setDate(cont++, (java.sql.Date) funcionario.getDtnascimento());
			
			stm.execute();
			stm.close();
			conexao.close();
			return true;
			
		} catch (SQLException ex) {
			
		}
		
		return false;
	}

	public boolean deleteFuncionario(int id) {
		int cont = 1;
		
		try {
			SQL = "DELETE FROM Funcionario "
					+ " WHERE fun_id = " + id;			
					
			stm = conexao.prepareStatement(SQL);
			res = stm.executeQuery();
			
			stm.setInt(cont++,id);
			
			stm.execute();
			stm.close();
			conexao.close();
		
			return true;
			
		} catch (SQLException ex) {
			}
		
		return false;
	}

	public Funcionario Funcionario(int id) {
		Funcionario fc = new Funcionario();
		
		try {
			SQL = "SELECT fun_id, fun_nome, fun_cpf, fun_dtnasc"
					+ " FROM Funcionario "
					+ " WHERE fun_id = " + id;
					
			stm = conexao.prepareStatement(SQL);
			res = stm.executeQuery();
			
			while (res.next()) {
				fc.setId(res.getInt("fun_id"));
				fc.setNome(res.getString("fun_nome"));
				fc.setCpf(res.getString("fun_cpf"));
				fc.setDtnascimento(res.getDate("fun_dtnasc"));
			}
			stm.close();
			conexao.close();
			
		} catch (SQLException ex) {
			
		}

		return fc;
	}

	public List<Funcionario> listFuncionario (){
		List<Funcionario> listFC;
		listFC = new ArrayList<Funcionario>(); 
		
		SQL = "SELECT fun_id, fun_nome, fun_cpf, fun_dtnasc"
				+ " FROM Funcionario ";
				
		try {
			stm = conexao.prepareStatement(SQL);
			res = stm.executeQuery();
			
			while (res.next()) {
				Funcionario fc = new Funcionario();
				fc.setId(res.getInt("fun_id"));
				fc.setNome(res.getString("fun_nome"));
				fc.setCpf(res.getString("fun_cpf"));
				fc.setDtnascimento(res.getDate("fun_dtnasc"));
				listFC.add(fc);
			}
			stm.close();
			conexao.close();
			
		} catch (SQLException ex) {
			
		}
		
		return listFC;
	}
}


