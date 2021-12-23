package ProductApp.ui;

import ProductApp.entity.ProductEntity;
import ProductApp.manager.ProductEntityManager;
import ProductApp.util.BaseForm;

import javax.swing.*;
import java.sql.SQLException;

public class MainForm extends BaseForm
{
    private JPanel mainPanel;
    private JButton addProductButton;
    private JButton updateProductButton;
    private JButton viewProductButton;

    public MainForm()
    {
        super(800,600);
        setContentPane(mainPanel);
        initButtons();
        setVisible(true);
    }
    private void initButtons()
    {
        viewProductButton.addActionListener(e ->
        {
            dispose();
            new ViewProductForm();

        });
        addProductButton.addActionListener(e ->
        {
            dispose();
            new CreateProductForm();
        });
        updateProductButton.addActionListener(e ->
        {
            String s = JOptionPane.showInputDialog(this,"введите ID","вод",JOptionPane.QUESTION_MESSAGE);
            if(s==null){
                return;
            }
            int id = -1;
            try {
                id = Integer.parseInt(s);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(this,"не введено","",JOptionPane.ERROR_MESSAGE);
                return;
            }

            ProductEntity product = null;
            try {
                product = ProductEntityManager.selectBtId(id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();

            }
            if(product==null){
                JOptionPane.showMessageDialog(this,"не введено","",JOptionPane.ERROR_MESSAGE);
                return;
            }
            dispose();
            new UpdateProductForm(product);
        });
    }
}
