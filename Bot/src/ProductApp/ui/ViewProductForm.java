package ProductApp.ui;

import ProductApp.entity.ProductEntity;
import ProductApp.manager.ProductEntityManager;
import ProductApp.util.BaseForm;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class ViewProductForm extends BaseForm {
    private JTextField textField;
    private JButton backButton;
    private JPanel mainPanel;
    private JTextArea textArea;

    public ViewProductForm()
    {
        super(1000,800);
        setContentPane(mainPanel);
        initButton();
        initTextField();
        setVisible(true);
    }
    private void initButton()
    {
        backButton.addActionListener(e ->
        {
            dispose();
            new MainForm();
        });
    }
    private void initTextField()
    {
        try {
            List<ProductEntity> list =ProductEntityManager.selectAll();
            String s = "";
            for (ProductEntity p : list){
                s+=p;
                s+="\n";
            }
            textArea.setText(s);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
