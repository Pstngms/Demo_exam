package ProductApp.ui;

import ProductApp.entity.ProductEntity;
import ProductApp.manager.ProductEntityManager;
import ProductApp.ui.MainForm;
import ProductApp.util.BaseForm;

import javax.swing.*;
import java.sql.SQLException;

public class UpdateProductForm extends BaseForm {
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
    private JTextField idField;
    private ProductEntity product;

    public UpdateProductForm(ProductEntity product)
    {
        super(600,400);
        this.product = product;
        setContentPane(mainPanel);
        initFields();
        initButtons();

        setVisible(true);
    }
    private void initFields()
    {
        idField.setText(String.valueOf(product.getId()));
        titleField.setText(product.getTitle());
        productTypeField.setText(product.getProductType());
        articleSpinner.setValue(product.getArticleNumber());
        descriptionField.setText(product.getDescription());
        imageField.setText(product.getImage());
        productionPersonCountSpinner.setValue(product.getProductionPersonCount());
        productionWorkshopNumberSpinner.setValue(product.getProductionWorkshopNumber());
        minCostForAgentSpinner.setValue(product.getMinCostForAgent());
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

            product.setTitle(title);
            product.setProductType(productType);
            product.setArticleNumber(article);
            product.setDescription(description);
            product.setImage(image);
            product.setProductionPersonCount(productionPersonCount);
            product.setProductionWorkshopNumber(productionWorkshopNumber);
            product.setMinCostForAgent(minCostForAgent);
            try {
                ProductEntityManager.update(product);
                JOptionPane.showMessageDialog(this,"Добавлен","Информация",JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new MainForm();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                
            }

        });
    }
}
