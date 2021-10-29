/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import model.bean.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author William Alefe <alefewilliam@gmail.com>
 */
public class UsuarioDAO {
    public boolean checkLogin(String login, String senha){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        int i = 0;
       

        //Cria DB se não existir ainda
        try{     
        Statement st = con.createStatement();
	System.out.println("Começo");
	//Toda operação que não for consulta, use executeUpdate, só assim
	//você poderá alterar algo no banco de dados
            i = st.executeUpdate("CREATE DATABASE IF NOT EXISTS helice");
        int y = st.executeUpdate("use helice");
        int x = st.executeUpdate("CREATE TABLE IF NOT EXISTS etiquetas(id int(6) AUTO_INCREMENT, codprod varchar(30) NOT NULL, logixprod varchar(30) NOT NULL, descprod varchar(40) NOT NULL, tipo varchar(30) NOT NULL, pesoprod varchar(10) NOT NULL, embalagem varchar(40) NOT NULL, pesopalete varchar(10), paletizacao varchar(30), logixetiqueta varchar(30) NOT NULL, descetiqueta varchar(40) NOT NULL, versao varchar(10), vigencia varchar(30), datadeinsercao varchar(20), imagem varchar(200), PRIMARY KEY (id)) ");
	System.out.println("Resultado: "+i + y + x);// Se criar uma nova base de dados, o retorno será 1
	System.out.println("Final");
       
   }catch(SQLException ex){
       System.out.println("Erro: "+ ex);
   }

    //Cria tabela usuario se não existir ainda
        try{     
        Statement st = con.createStatement();
	st.executeUpdate("CREATE TABLE IF NOT EXISTS usuario(id int(4) AUTO_INCREMENT, login varchar(20) NOT NULL, senha varchar(20),PRIMARY KEY (id)) ");	
   }catch(SQLException ex){
       System.out.println("Erro: "+ ex);
       
   }
            //cria usuário incial
            if(i==1){
            try{
                System.out.println("Passou!!");
            stmt = con.prepareStatement("INSERT INTO usuario(login,senha) VALUES(?,?)");            
            stmt.setString(1, "admin");
            stmt.setString(2, "142536");
            stmt.executeUpdate();
            }catch(SQLException ex){
            System.out.println("Erro: "+ ex);
       
            }
            }
            
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE login = ? and senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
              check = true;
              
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return check;
        
    }
     
     public void create(Usuario u){
         Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO usuario(login, senha) VALUES(?,?)");
            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getSenha());
                        
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ ex);
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    }
    public void update(Usuario u){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE etiquetas SET login = ?, senha = ? WHERE id = ?");
            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getSenha());
            stmt.setInt(3, u.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ ex);
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    }
}
