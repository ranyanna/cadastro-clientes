/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entidade.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOClientes {

    private Connection conexao;
    private static DAOClientes instancia;

    private DAOClientes() {
        try {
            String url = "jdbc:mysql://localhost:3306/cadastro_clientes";
            String user = "root";
            String pwd = "#R4ny4y4nn4";

            conexao = DriverManager.getConnection(url, user, pwd);

            System.out.println("SUCESSO NA CONEXAO COM BD!");

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

    public void save(String nome, String cpf, String email, String telefone) {

        String sql = "INSERT INTO cliente (nome, cpf, email, telefone) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setString(1, nome);
            ps.setString(2, cpf);
            ps.setString(3, email);
            ps.setString(4, telefone);

            ps.executeUpdate();

            System.out.println("Cliente salvo!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Cliente> list() {

        List<Cliente> lista = new ArrayList<>();

        try {

            String sql = "SELECT * FROM cliente";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                lista.add(new Cliente(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getString("telefone")
                ));
            }

            return lista;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}