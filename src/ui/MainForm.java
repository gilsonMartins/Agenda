package ui;

import business.ContactBusiness;
import repository.entity.ContactEntity;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class MainForm extends JFrame {
    private JPanel rootPanel;
    private JButton buttonNewContact;
    private JButton buttonCancelAccount;
    private JTable tableContact;
    private JLabel labelContactCount;
    private String name= "";
    private String phone = "";

    private ContactBusiness mContactBusiness;
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
        loadContacts();
    }

    private void loadContacts() {
        mContactBusiness = new ContactBusiness();
        List<ContactEntity> contactEntityList = mContactBusiness.getList();

        mContactBusiness.getList();
        String[] columnames = {"name", "telefone"};
        DefaultTableModel mode =new DefaultTableModel(new Object[0][0], columnames);

        for (ContactEntity i : contactEntityList) {
            Object[] o = new Object[2];
            o[0] = i.getName();
            o[1] = i.getPhone();
            mode.addRow(o);
        }
        tableContact.clearSelection();
        tableContact.setModel(mode);

        labelContactCount.setText(mContactBusiness.contactDescription() );
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
        tableContact.getSelectionModel().addListSelectionListener(e1 -> {
            if (e1.getValueIsAdjusting()){
                if (tableContact.getSelectedRow() != -1 ){
                    name =tableContact.getValueAt(tableContact.getSelectedRow(), 0 ).toString();
                    phone =tableContact.getValueAt(tableContact.getSelectedRow(), 1).toString();
                }
            }
        });
        buttonCancelAccount.addActionListener(e -> {
            try {

                mContactBusiness.delete(name, phone);
                loadContacts();
                name = "";
                phone = "";
            }catch (Exception exception){
                JOptionPane.showMessageDialog(new JFrame(), exception.getMessage());
            }
        });
    }
}
