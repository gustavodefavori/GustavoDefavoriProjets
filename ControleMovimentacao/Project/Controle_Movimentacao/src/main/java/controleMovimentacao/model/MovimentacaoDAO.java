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

public class MovimentacaoDAO {
	private ResultSet res;
	private String SQL;
	private PreparedStatement stm;
	private Connection conexao;
	
	public boolean insertMovimentacao(Movimentacao movimentacao) {
		int cont = 1;
		
		try {
			SQL = "INSERT INTO Movimentacao (mvt_id, mvt_tpm_id, mvt_dtinicio, mvt_dtfim, mvt_cnt_num, mvt_fun_id) "
					+ " VALUES (?, ?, ?, ?, ?, ?) ";			
					
			stm = conexao.prepareStatement(SQL);
			res = stm.executeQuery();
			
			stm.setInt(cont++, movimentacao.getId());
			stm.setInt(cont++, movimentacao.getTipoMovimentacao().getId());
			stm.setDate(cont++, (Date) movimentacao.getDtInicio());
			stm.setDate(cont++, (Date) movimentacao.getDtFim());
			stm.setString(cont++, movimentacao.getConteiner().getCodigo());
			stm.setInt(cont++, movimentacao.getFuncionario().getId());
			
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
			SQL = "DELETE FROM Movimentacao "
					+ " WHERE mvt_id = " + id;			
					
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

	public Movimentacao getMovimentacao(int id) {
		Movimentacao mv = new Movimentacao();
		
		try {
			SQL = "SELECT mvt_id, mvt_tmp_id, mvt_tipo, mvt_dtinicio, mvt_dtfim, mvt_cnt_num, mvt_fun_id"
					+ " FROM Movimentacao "
					+ " WHERE mvt_id = " + id;
					
			stm = conexao.prepareStatement(SQL);
			res = stm.executeQuery();
			
			while (res.next()) {
				mv.setId(res.getInt("mvt_id"));
				mv.getTipoMovimentacao().setId(res.getInt("mvt_tipo"));
				mv.setDtInicio(res.getDate("mvt_dtinicio"));
				mv.setDtFim(res.getDate("mvt_dtfim"));
				mv.getConteiner().setCodigo(res.getString("mvt_fun_id"));
				mv.getFuncionario().setId(res.getInt("mvt_fun_id"));
			}
			stm.close();
			conexao.close();
			
		} catch (SQLException ex) {
			
		}

		return mv;
	}

	public List<Movimentacao> listMovimentacao (){
		List<Movimentacao> listMV;
		listMV = new ArrayList<Movimentacao>(); 
		
		SQL = "SELECT mvt_tmp_id, mvt_tipo, mvt_dtinicio, mvt_dtfim, mvt_cnt_num, mvt_fun_id"
				+ " FROM Tipo_Movimentacao ";
				
		try {
			stm = conexao.prepareStatement(SQL);
			res = stm.executeQuery();
			
			while (res.next()) {
				Movimentacao mv = new Movimentacao();
				mv.setId(res.getInt("mvt_id"));
				mv.getTipoMovimentacao().setId(res.getInt("mvt_tipo"));
				mv.setDtInicio(res.getDate("mvt_dtinicio"));
				mv.setDtFim(res.getDate("mvt_dtfim"));
				mv.getConteiner().setCodigo(res.getString("mvt_fun_id"));
				mv.getFuncionario().setId(res.getInt("mvt_fun_id"));
				
				listMV.add(mv);
			}
			stm.close();
			conexao.close();
			
		} catch (SQLException ex) {
			
		}
		
		return listMV;
	}
}