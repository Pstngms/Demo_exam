package MaterialApp.ui;

import MaterialApp.util.BaseForm;

import javax.swing.*;

public class MainForm extends BaseForm {
    private JButton updateMaterialButton;
    private JButton createMaterialButton;
    private JButton viewMaterialButton;
    private JPanel mainPanel;

    public MainForm()
    {
        super(800,600);
        setContentPane(mainPanel);
        initButtons();
        setVisible(true);
    }
    private void initButtons()
    {
        createMaterialButton.addActionListener(e ->
        {
            dispose();
            new CreateMaterialForm();
        });
        viewMaterialButton.addActionListener(e ->
        {
            dispose();
            new ViewMaterialForm();
        });
    }
}
