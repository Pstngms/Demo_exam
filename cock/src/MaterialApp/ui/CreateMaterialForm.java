package MaterialApp.ui;

import MaterialApp.entity.MaterialEntity;
import MaterialApp.manager.MaterialEntityManager;
import MaterialApp.util.BaseForm;

import javax.swing.*;
import java.sql.SQLException;

public class CreateMaterialForm extends BaseForm {
    private JTextField titleField;
    private JSpinner countInPackSpinner;
    private JComboBox<String> unitBox;
    private JButton addButton;
    private JButton backButton;
    private JPanel mainPanel;
    private JSpinner countInStockSpinner;
    private JSpinner minCountSpinner;
    private JTextField descriptionField;
    private JSpinner costSpinner;
    private JTextField imageField;
    private JTextField matTypeFiled;

    public CreateMaterialForm()
    {
        super(800,600);
        setContentPane(mainPanel);
        initButtons();
        initComboBox();
        setVisible(true);

    }

    private void initButtons()
    {
        backButton.addActionListener(e ->
        {
            dispose();
            new MainForm();
        });
        addButton.addActionListener(e ->
        {
            String title = titleField.getText();
            int countInPack = (int) countInPackSpinner.getValue();
            String unit = String.valueOf(unitBox.getSelectedItem());
            int countInStock = (int)countInStockSpinner.getValue();
            int minCount = (int)minCountSpinner.getValue();
            String description = descriptionField.getText();
            int cost = (int)costSpinner.getValue();
            String image = imageField.getText();
            String matType = matTypeFiled.getText();

            MaterialEntity material = new MaterialEntity(
                    title,
                    countInPack,
                    unit,
                    countInStock,
                    minCount,
                    description,
                    cost,
                    image,
                    matType
            );
            try {
                MaterialEntityManager.insert(material);
                dispose();
                new MainForm();
                JOptionPane.showMessageDialog(this,"Добавлен","Информация",JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException throwables) {
                throwables.printStackTrace();

            }
        });
    }
    private void initComboBox()
    {
        unitBox.addItem("м");
        unitBox.addItem("кг");
    }

}
