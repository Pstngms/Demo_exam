package ServiceApp.ui;

import ServiceApp.entity.ServiceEntity;
import ServiceApp.manager.ServiceEntityManager;
import ServiceApp.util.BaseForm;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class VIewForm extends BaseForm {
    private JTextArea textArea;
    private JButton BackButton;
    private JPanel mainPane;

    public VIewForm()
    {
        super(1000,800);
        setContentPane(mainPane);
        initButton();
        initTextArea();
        setVisible(true);
    }

    private void initButton()
    {
        BackButton.addActionListener(e ->
        {
            dispose();
            new MainForm();
        });
    }
    private void initTextArea()
    {
        try {
            List<ServiceEntity> list = ServiceEntityManager.selectAll();
            String s ="";
            for (ServiceEntity c:list){
                s+=c;
                s+="\n";
            }
            textArea.setText(s);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
