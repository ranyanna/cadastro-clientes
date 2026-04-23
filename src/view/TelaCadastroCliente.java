package view;

import java.awt.GridLayout;
import javax.swing.*;
import models.DAOClientes;

public class TelaCadastroCliente extends JFrame {

    private JPanel panel;

    private JLabel label_nome;
    private JLabel label_cpf;
    private JLabel label_email;
    private JLabel label_telefone;

    private JTextField text_nome;
    private JTextField text_cpf;
    private JTextField text_email;
    private JTextField text_telefone;

    private JButton bt_salvar;
    private JButton bt_cancelar;

    public TelaCadastroCliente() {
        initialize();
    }

    public void initialize() {

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        label_nome = new JLabel("Nome:");
        label_cpf = new JLabel("CPF:");
        label_email = new JLabel("Email:");
        label_telefone = new JLabel("Telefone:");

        text_nome = new JTextField();
        text_cpf = new JTextField();
        text_email = new JTextField();
        text_telefone = new JTextField();

        bt_salvar = new JButton("Salvar");
        bt_cancelar = new JButton("Cancelar");

        panel.add(label_nome);
        panel.add(text_nome);
        panel.add(label_cpf);
        panel.add(text_cpf);
        panel.add(label_email);
        panel.add(text_email);
        panel.add(label_telefone);
        panel.add(text_telefone);
        panel.add(bt_salvar);
        panel.add(bt_cancelar);

        bt_salvar.addActionListener(e -> {

            DAOClientes dao = DAOClientes.getInstance();

            dao.save(
                    text_nome.getText(),
                    text_cpf.getText(),
                    text_email.getText(),
                    text_telefone.getText()
            );

            JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");

            text_nome.setText("");
            text_cpf.setText("");
            text_email.setText("");
            text_telefone.setText("");
        });

        bt_cancelar.addActionListener(e -> dispose());

        add(panel);

        setTitle("Cadastro de Cliente");
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}