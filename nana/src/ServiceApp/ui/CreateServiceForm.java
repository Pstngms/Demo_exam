package ServiceApp.ui;

import ServiceApp.entity.ServiceEntity;
import ServiceApp.manager.ServiceEntityManager;
import ServiceApp.util.BaseForm;

import javax.swing.*;
import java.sql.SQLException;

public class CreateServiceForm extends BaseForm {
    private JTextField titleField;
    private JSpinner durationSpinner;
    private JTextField coastField;
    private JTextField discountField;
    private JTextField imagePathField;
    private JPanel mainPane;
    private JButton BackButton;
    private JButton AddButton;

    public CreateServiceForm()
    {
        super(600,500);
        setContentPane(mainPane);
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

        AddButton.addActionListener(e ->
        {
            String title = titleField.getText();
            if (title.isEmpty()||title.length()>100){
                JOptionPane.showMessageDialog(this,"Название не введено или слишком длинное","Ошибка",JOptionPane.ERROR_MESSAGE);
                return;
            }
            double coast = Double.parseDouble(coastField.getText());
            int duration = (int) durationSpinner.getValue();
            double discount = Double.parseDouble(discountField.getText());
            String imagePath = imagePathField.getText();
            ServiceEntity service = new ServiceEntity(
                    title,
                    coast,
                    duration,
                    discount,
                    imagePath
            );
            try {
                ServiceEntityManager.insert(service);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            JOptionPane.showMessageDialog(this,"Сервис добавлен","Информация",JOptionPane.INFORMATION_MESSAGE);
            dispose();
            new MainForm();


        });
    }
}
