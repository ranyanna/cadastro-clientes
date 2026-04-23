/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.*;

public class TelaPrincipal extends JFrame {

    private JMenuBar barraMenu;
    private JMenu menuArquivo;
    private JMenuItem menuCadastro;
    private JMenuItem menuSair;

    public TelaPrincipal() {
        setTitle("Sistema de Clientes");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        barraMenu = new JMenuBar();

        menuArquivo = new JMenu("Clientes");

        menuCadastro = new JMenuItem("Cadastrar Cliente");
        menuSair = new JMenuItem("Sair");

        menuArquivo.add(menuCadastro);
        menuArquivo.add(menuSair);

        barraMenu.add(menuArquivo);
        setJMenuBar(barraMenu);

        menuCadastro.addActionListener(e -> {
            new TelaCadastroCliente();
        });

        menuSair.addActionListener(e -> {
            System.exit(0);
        });

        setVisible(true);
    }
}