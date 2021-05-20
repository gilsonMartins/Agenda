package ui;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {
    private JPanel rootPanel;
    private JButton buttonNewContact;
    private JButton buttonCancelAccount;
    private JTable tableContact;

    public MainForm() {
        /*configurações iniciais do programa*/
        setContentPane(rootPanel);
        setSize(550, 250);
        setVisible(true);

        /*reidimencionar o tamanho da tela do programa*/
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dimension.width / 2 - getSize().width / 2, dimension.height / 2 - getSize().height / 2);

        /*função para fechar o programa*/
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        setListeners();
    }

    private void setListeners() {
        buttonNewContact.addActionListener(e -> {

            /*
            metodo invocar nova classe
            */
            new ContactForm();

            /*
            realizar a invocação da nova tela
            */
            dispose();
        });
        buttonCancelAccount.addActionListener(e -> setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE));
    }
}
