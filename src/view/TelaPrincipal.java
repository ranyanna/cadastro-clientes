/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.*;

public class TelaPrincipal extends JFrame {

    private JMenuBar barraMenu;
    private JMenu menuClientes;

    private JMenuItem menuCadastrar;
    private JMenuItem menuListar;
    private JMenuItem menuSair;

    public TelaPrincipal() {

        setTitle("Sistema de Clientes");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        barraMenu = new JMenuBar();

        menuClientes = new JMenu("Clientes");

        menuCadastrar = new JMenuItem("Cadastrar Cliente");
        menuListar = new JMenuItem("Listar Clientes");
        menuSair = new JMenuItem("Sair");

        menuClientes.add(menuCadastrar);
        menuClientes.add(menuListar);
        menuClientes.add(menuSair);

        barraMenu.add(menuClientes);
        setJMenuBar(barraMenu);

        menuCadastrar.addActionListener(e -> new TelaCadastroCliente());

        menuListar.addActionListener(e -> new TelaListarCliente());

        menuSair.addActionListener(e -> System.exit(0));

        setVisible(true);
    }
}