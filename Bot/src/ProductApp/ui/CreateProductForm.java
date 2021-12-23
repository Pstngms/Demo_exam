package ProductApp.ui;

import ProductApp.entity.ProductEntity;
import ProductApp.manager.ProductEntityManager;
import ProductApp.util.BaseForm;

import javax.swing.*;
import java.sql.SQLException;

public class CreateProductForm extends BaseForm {
    private JPanel mainPanel;
    private JTextField titleField;
    private JTextField productTypeField;
    private JSpinner articleSpinner;
    private JTextField descriptionField;
    private JTextField imageField;
    private JSpinner productionPersonCountSpinner;
    private JSpinner productionWorkshopNumberSpinner;
    private JSpinner minCostForAgentSpinner;
    private JButton SaveButton;
    private JButton BackButton;

    public CreateProductForm()
    {
        super(600,400);
        setContentPane(mainPanel);
        initButtons();
        setVisible(true);
    }
    private void initButtons()
    {
        BackButton.addActionListener(e ->
        {
            dispose();
            new MainForm();
        });
        SaveButton.addActionListener(e ->
        {
            String title = titleField.getText();
            String productType = productTypeField.getText();

            int article = -1;
            try {
                article = Integer.getInteger("article", (int) articleSpinner.getValue());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"ss","",JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (article<0){
                JOptionPane.showMessageDialog(this,"ss","",JOptionPane.ERROR_MESSAGE);
                return;
            }


            String description = descriptionField.getText();
            String image = imageField.getText();
            int productionPersonCount = (int) productionPersonCountSpinner.getValue();
            int productionWorkshopNumber = (int) productionWorkshopNumberSpinner.getValue();
            int minCostForAgent = (int) minCostForAgentSpinner.getValue();

            ProductEntity product = new ProductEntity(
                    title,
                    productType,
                    article,
                    description,
                    image,
                    productionPersonCount,
                    productionWorkshopNumber,
                    minCostForAgent
            );
            try {
                ProductEntityManager.insert(product);
                JOptionPane.showMessageDialog(this,"Добавлен","Информация",JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new MainForm();
            } catch (SQLException throwables) {
                throwables.printStackTrace();

            }

        });
    }
}
