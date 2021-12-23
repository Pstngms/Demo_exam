package MaterialApp.ui;

import MaterialApp.entity.MaterialEntity;
import MaterialApp.manager.MaterialEntityManager;
import MaterialApp.util.BaseForm;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class ViewMaterialForm extends BaseForm {
    private JTextArea textArea;
    private JButton backButton;
    private JPanel mainPanel;

    public ViewMaterialForm()
    {
        super(1000,800);
        setContentPane(mainPanel);
        initButton();
        initField();
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
    private void initField()
    {

        try {
            List<MaterialEntity> list = MaterialEntityManager.selectAll();
            String s = "";
            for (MaterialEntity m:list){
                s+=m;
                s+="\n";
            }
            textArea.setText(s);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
