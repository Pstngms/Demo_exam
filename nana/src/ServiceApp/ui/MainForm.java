package ServiceApp.ui;

import ServiceApp.util.BaseForm;

import javax.swing.*;

public class MainForm extends BaseForm {
    private JPanel mainForm;
    private JButton CreateServiceButton;
    private JButton UpdateSetviceButton;
    private JButton ViewServiceButton;

    public MainForm()
    {
        super(600,500);
        setContentPane(mainForm);
        initButtons();
        setVisible(true);


    }
    private void initButtons()
    {
        CreateServiceButton.addActionListener(e ->
        {
            dispose();
            new CreateServiceForm();

        });
        ViewServiceButton.addActionListener(e ->
        {
            dispose();
            new VIewForm();
        });
    }
}
