package ui;

import business.ContactBusiness;

import javax.swing.*;
import java.awt.*;

public class ContactForm extends JFrame {

    private JPanel rootPanel;
    private JTextField textFieldPhone;
    private JButton buttonSave;
    private JButton buttonCancel;
    private JTextField textFieldName;
    private ContactBusiness mContactBusiness;
    public ContactForm() {
        setContentPane(rootPanel);
        setSize(550, 250);
        setVisible(true);


        /*reidimencionar o tamanho da tela do programa*/
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dimension.width / 2 - getSize().width / 2, dimension.height / 2 - getSize().height / 2);

        /*função para fechar o programa*/
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mContactBusiness = new ContactBusiness();
        setListeners();
    }

    private void setListeners() {
        buttonSave.addActionListener(e -> {
            try{
                String name = textFieldName.getText();
                String phone = textFieldPhone.getText();

                mContactBusiness.save(name, phone);
            /*
            metodo invocar nova classe
            */
                new MainForm();

            /*
            realizar a invocação da nova tela
            */
                dispose();
            }catch (Exception exception){
                JOptionPane.showMessageDialog(new JFrame(), exception.getMessage());
            }

        });
        buttonCancel.addActionListener(e -> {
            new MainForm();
            dispose();
        });
    }

}
