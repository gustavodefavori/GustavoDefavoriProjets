package controleMovimentacao.model;

import controleMovimentacao.beans.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConteinerDAO {
	private ResultSet res;
	private String SQL;
	private PreparedStatement stm;
	private Connection conexao;
	
	public boolean insertConteiner(Conteiner conteiner) {
		int cont = 1;
		
		try {
			SQL = "INSERT INTO Tipo_Movimentacao (tpm_id, tmp_descricao, tpm_tipo) "
					+ " VALUES (?, ?, ?) ";			
					
			stm = conexao.prepareStatement(SQL);
			res = stm.executeQuery();
			
			stm.setString(cont++, conteiner.getCodigo());
			stm.setInt(cont++, conteiner.getTipo());
			stm.setInt(cont++, conteiner.getStatus());
			stm.setString(cont++, conteiner.getCategoria());
			stm.setInt(cont++, conteiner.getCliente().getId());
			
			
			stm.execute();
			stm.close();
			conexao.close();
			return true;
			
			
		} catch (SQLException ex) {
			
		}
		
		return false;
	}

	public boolean deleteConteiner(String codigo) {
		int cont = 1;
		
		try {
			SQL = "DELETE FROM Conteiner "
					+ " WHERE cnt_num = " + codigo;			
					
			stm = conexao.prepareStatement(SQL);
			res = stm.executeQuery();
			
			stm.setString(cont++, codigo);
			
			stm.execute();
			stm.close();
			conexao.close();
			
			return true;
			
		} catch (SQLException ex) {
		}
		
		return false;
	}

	public Conteiner getConteiner(String codigo) {
		Conteiner ct = new Conteiner();
		
		try {
			SQL = "SELECT cnt_num, cnt_tipo, cnt_status, cnt_cli_id, cnt_categoria"
					+ " FROM Conteiner "
					+ " WHERE cnt_num = " + codigo;
					
			stm = conexao.prepareStatement(SQL);
			res = stm.executeQuery();
			
			while (res.next()) {
				ct.setCodigo(res.getString("cnt_num"));
				ct.setTipo(res.getInt("cnt_tipo"));
				ct.setStatus(res.getInt("cnt_status"));
				ct.getCliente().setId(res.getInt("cnt_cli_id"));
				ct.setCategoria(res.getString("cnt_categoria"));
			}
			stm.close();
			conexao.close();
			
		} catch (SQLException ex) {
		}

		return ct;
	}

	public List<Conteiner> listConteineres (){
		List<Conteiner> listCT;
		listCT = new ArrayList<Conteiner>(); 
		
		SQL = "SELECT cnt_num, cnt_tipo, cnt_status, cnt_cli_id, cnt_categoria"
				+ " FROM Conteiner ";
				
		try {
			stm = conexao.prepareStatement(SQL);
			res = stm.executeQuery();
			
			while (res.next()) {
				Conteiner ct = new Conteiner();
				ct.setCodigo(res.getString("cnt_num"));
				ct.setTipo(res.getInt("cnt_tipo"));
				ct.setStatus(res.getInt("cnt_status"));
				ct.getCliente().setId(res.getInt("cnt_cli_id"));
				ct.setCategoria(res.getString("cnt_categoria"));
				listCT.add(ct);
			}
			stm.close();
			conexao.close();
			
		} catch (SQLException ex) {
		}
		
		return listCT;
	}
}