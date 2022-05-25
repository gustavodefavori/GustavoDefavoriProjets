package controleMovimentacao.model;

import controleMovimentacao.beans.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TipoMovimentacaoDAO {
	private ResultSet res;
	private String SQL;
	private PreparedStatement stm;
	private Connection conexao;
	
	public boolean insertTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		int cont = 1;
		
		try {
			SQL = "INSERT INTO Tipo_Movimentacao (tpm_id, tmp_descricao, tpm_tipo) "
					+ " VALUES (?, ?, ?) ";			
					
			stm = conexao.prepareStatement(SQL);
			res = stm.executeQuery();
			
			stm.setInt(cont++, tipoMovimentacao.getId());
			stm.setString(cont++, tipoMovimentacao.getDescricao());
			stm.setString(cont++, tipoMovimentacao.getTipo());
			
			stm.execute();
			stm.close();
			conexao.close();
			
			return true;
			
		} catch (SQLException ex) {
			
		}
		
		return false;
	}

	public boolean deleteMovimentacao(int id) {
		int cont = 1;
		
		try {
			SQL = "DELETE FROM Tipo_Movimentacao "
					+ " WHERE tpm_id = " + id;			
					
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

	public TipoMovimentacao getTipoMovimentacao(int id) {
		TipoMovimentacao tm = new TipoMovimentacao();
		
		try {
			SQL = "SELECT tpm_id, tmp_descricao, tpm_tipo"
					+ " FROM Tipo_Movimentacao "
					+ " WHERE tpm_id = " + id;
					
			stm = conexao.prepareStatement(SQL);
			res = stm.executeQuery();
			
			while (res.next()) {
				tm.setId(res.getInt("tpm_id"));
				tm.setDescricao(res.getString("tmp_descricao"));
				tm.setTipo(res.getString("tmp_tipo"));
			}
			stm.close();
			conexao.close();
			
		} catch (SQLException ex) {
			
		}

		return tm;
	}

	public List<TipoMovimentacao> listTipoMovimentacao (){
		List<TipoMovimentacao> listTM;
		listTM = new ArrayList<TipoMovimentacao>(); 
		
		SQL = "SELECT tpm_id, tmp_descricao, tpm_tipo"
				+ " FROM Tipo_Movimentacao ";
				
		try {
			stm = conexao.prepareStatement(SQL);
			res = stm.executeQuery();
			
			while (res.next()) {
				TipoMovimentacao tm = new TipoMovimentacao();
				tm.setId(res.getInt("tpm_id"));
				tm.setDescricao(res.getString("tmp_descricao"));
				tm.setTipo(res.getString("tmp_tipo"));
				listTM.add(tm);
			}
			stm.close();
			conexao.close();
			
		} catch (SQLException ex) {
			
		}
		
		return listTM;
	}
}