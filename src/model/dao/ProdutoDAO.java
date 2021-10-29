/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Produto;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author William Alefe <alefewilliam@gmail.com>
 */
public class ProdutoDAO {
    public void create(Produto p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO etiquetas(codprod, logixprod, descprod, tipo, pesoprod, embalagem, pesopalete, paletizacao, logixetiqueta, descetiqueta, versao, vigencia, DataDeInsercao, imagem) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, p.getCodprod());
            stmt.setString(2, p.getLogixprod());
            stmt.setString(3, p.getDescprod());
            stmt.setString(4, p.getTipo());
            stmt.setString(5, p.getPesoprod());
            stmt.setString(6, p.getEmbalagem());
            stmt.setString(7, p.getPesopalete());
            stmt.setString(8, p.getPaletizacao());
            stmt.setString(9, p.getLogixetiqueta());
            stmt.setString(10, p.getDescetiqueta());
            stmt.setString(11, p.getVersao());
            stmt.setString(12, p.getVigencia());
            stmt.setString(13, p.getDataDeInsercao());
            stmt.setString(14, p.getImagem());
            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ ex);
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    }
    public void update(Produto p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE etiquetas SET Codprod = ?, Logixprod = ?, Descprod = ?, Tipo = ?, Pesoprod = ?, Embalagem = ?, Pesopalete = ?, Paletizacao = ?, Logixetiqueta = ?, Logixetiqueta = ?, descetiqueta = ?, versao = ?, DataDeInsercao = ?, imagem = ? WHERE id = ?");
            stmt.setString(1, p.getCodprod());
            stmt.setString(2, p.getLogixprod());
            stmt.setString(3, p.getDescprod());
            stmt.setString(4, p.getTipo());
            stmt.setString(5, p.getPesoprod());
            stmt.setString(6, p.getEmbalagem());
            stmt.setString(7, p.getPesopalete());
            stmt.setString(8, p.getPaletizacao());
            stmt.setString(9, p.getLogixetiqueta());
            stmt.setString(10, p.getDescetiqueta());
            stmt.setString(11, p.getVersao());
            stmt.setString(12, p.getVigencia());
            stmt.setString(13, p.getDataDeInsercao());
            stmt.setString(14, p.getImagem());
            stmt.setInt(15, p.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ ex);
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    }
    
    public List<Produto> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM etiquetas");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Produto produto = new Produto();
                
                produto.setId(rs.getInt("id"));
                produto.setCodprod(rs.getString("codprod"));
                produto.setLogixprod(rs.getString("logixprod"));
                produto.setDescprod(rs.getString("descprod"));
                produto.setTipo(rs.getString("tipo"));
                produto.setPesoprod(rs.getString("pesoprod"));
                produto.setEmbalagem(rs.getString("embalagem"));
                produto.setPesopalete(rs.getString("pesopalete"));
                produto.setPaletizacao(rs.getString("paletizacao"));
                produto.setLogixetiqueta(rs.getString("logixetiqueta"));
                produto.setDescetiqueta(rs.getString("descetiqueta"));
                produto.setVersao(rs.getString("versao"));
                produto.setVigencia(rs.getString("vigencia"));
                produto.setDataDeInsercao(rs.getString("DataDeInsercao"));
                produto.setImagem(rs.getString("imagem"));
                                                                
                produtos.add(produto);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return produtos;
        
    }
    
    public List<Produto> readForLogix(String log) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM etiquetas WHERE logixprod LIKE ?");
            stmt.setString(1,"%"+log+"%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
                produto.setCodprod(rs.getString("codprod"));
                produto.setLogixprod(rs.getString("logixprod"));
                produto.setDescprod(rs.getString("descprod"));
                produto.setTipo(rs.getString("tipo"));
                produto.setPesoprod(rs.getString("pesoprod"));
                produto.setEmbalagem(rs.getString("embalagem"));
                produto.setPesopalete(rs.getString("pesopalete"));
                produto.setPaletizacao(rs.getString("paletizacao"));
                produto.setLogixetiqueta(rs.getString("logixetiqueta"));
                produto.setDescetiqueta(rs.getString("descetiqueta"));
                produto.setVersao(rs.getString("versao"));
                produto.setVigencia(rs.getString("vigencia"));
                produto.setDataDeInsercao(rs.getString("DataDeInsercao"));
                produto.setImagem(rs.getString("imagem"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

    }
    
    public List<Produto> readForDesc(String desc) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM etiquetas WHERE descprod LIKE ?");
            stmt.setString(1,"%"+desc+"%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
                produto.setCodprod(rs.getString("codprod"));
                produto.setLogixprod(rs.getString("logixprod"));
                produto.setDescprod(rs.getString("descprod"));
                produto.setTipo(rs.getString("tipo"));
                produto.setPesoprod(rs.getString("pesoprod"));
                produto.setEmbalagem(rs.getString("embalagem"));
                produto.setPesopalete(rs.getString("pesopalete"));
                produto.setPaletizacao(rs.getString("paletizacao"));
                produto.setLogixetiqueta(rs.getString("logixetiqueta"));
                produto.setDescetiqueta(rs.getString("descetiqueta"));
                produto.setVersao(rs.getString("versao"));
                produto.setVigencia(rs.getString("vigencia"));
                produto.setDataDeInsercao(rs.getString("DataDeInsercao"));
                produto.setImagem(rs.getString("imagem"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

    }
    
    public List<Produto> readForTipo(String tipo) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM etiquetas WHERE tipo LIKE ?");
            stmt.setString(1,"%"+tipo+"%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
                produto.setCodprod(rs.getString("codprod"));
                produto.setLogixprod(rs.getString("logixprod"));
                produto.setDescprod(rs.getString("descprod"));
                produto.setTipo(rs.getString("tipo"));
                produto.setPesoprod(rs.getString("pesoprod"));
                produto.setEmbalagem(rs.getString("embalagem"));
                produto.setPesopalete(rs.getString("pesopalete"));
                produto.setPaletizacao(rs.getString("paletizacao"));
                produto.setLogixetiqueta(rs.getString("logixetiqueta"));
                produto.setDescetiqueta(rs.getString("descetiqueta"));
                produto.setVersao(rs.getString("versao"));
                produto.setVigencia(rs.getString("vigencia"));
                produto.setDataDeInsercao(rs.getString("DataDeInsercao"));
                produto.setImagem(rs.getString("imagem"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

    }
}
