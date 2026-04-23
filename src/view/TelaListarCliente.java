/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import entidade.Cliente;
import models.DAOClientes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TelaListarCliente extends JFrame {

    private JTable tabela;
    private JScrollPane scroll;

    private DefaultTableModel model;
    private DAOClientes dao;

    private JPanel panel;
    private JPanel panel_botoes;

    private JLabel label_title;

    private JButton bt_novo;
    private JButton bt_atualizar;
    private JButton bt_sair;

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem item_cadastro;
    private JMenuItem item_sair;

    public TelaListarCliente() {
        this.dao = DAOClientes.getInstance();
        initialize();
    }

    public void initialize() {

        label_title = new JLabel("Listagem de Clientes");

        bt_novo = new JButton("Novo");
        bt_atualizar = new JButton("Atualizar");
        bt_sair = new JButton("Sair");

        menuBar = new JMenuBar();
        menu = new JMenu("Programa");

        item_cadastro = new JMenuItem("Cadastrar Cliente");
        item_sair = new JMenuItem("Sair");

        menu.add(item_cadastro);
        menu.addSeparator();
        menu.add(item_sair);

        menuBar.add(menu);
        setJMenuBar(menuBar);

        panel = new JPanel();
        panel.setLayout(new BorderLayout(5, 5));

        panel_botoes = new JPanel();
        panel_botoes.setLayout(new GridLayout(1, 3, 10, 10));

        model = new DefaultTableModel();

        model.addColumn("Nome");
        model.addColumn("CPF");
        model.addColumn("Email");
        model.addColumn("Telefone");

        tabela = new JTable(model);
        scroll = new JScrollPane(tabela);

        carregarDados();

        item_sair.addActionListener(e -> {
            dispose();
            System.exit(0);
        });

        item_cadastro.addActionListener(e -> {
            new TelaCadastroCliente();
        });

        bt_sair.addActionListener(e -> {
            dispose();
            System.exit(0);
        });

        bt_novo.addActionListener(e -> {
            new TelaCadastroCliente();
        });

        bt_atualizar.addActionListener(e -> {
            carregarDados();
        });

        panel.add(label_title, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);

        panel_botoes.add(bt_novo);
        panel_botoes.add(bt_atualizar);
        panel_botoes.add(bt_sair);

        panel.add(panel_botoes, BorderLayout.SOUTH);

        add(panel);

        setTitle("Listagem de Clientes");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void carregarDados() {

        model.setRowCount(0);

        List<Cliente> lista = dao.list();

        if (lista != null) {
            for (Cliente c : lista) {

                model.addRow(new Object[]{
                        c.getNome(),
                        c.getCpf(),
                        c.getEmail(),
                        c.getTelefone()
                });
            }
        }
    }
}