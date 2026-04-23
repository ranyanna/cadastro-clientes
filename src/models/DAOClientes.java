/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.*;

public class DAOClientes {
    
    private Connection conexao;
    private static DAOClientes instancia;
    
    private DAOClientes() {
        try {
            String url = "jdbc:mysql://localhost:3306/cadastro_clientes";
            String user = "root";
            String pwd = "";

            conexao = DriverManager.getConnection(url, user, pwd);

            System.out.println("SUCESSO NA CONEXAO COM BD!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void save(String nome, String cpf, String email, String telefone) {
        String sql = "INSERT INTO cliente (nome, cpf, email, telefone) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setString(1, nome);
            ps.setString(2, cpf);
            ps.setString(3, email);
            ps.setString(4, telefone);

            ps.executeUpdate();

            System.out.println("Cliente salvo no banco!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static DAOClientes getInstance() {
        if (instancia == null) {
            instancia = new DAOClientes();
        }
        return instancia;
    }
}