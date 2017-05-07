package unitconverter;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ConverterWindow extends JFrame {

    private JLabel lblInput;
    private JLabel lblOutput;
    private JFormattedTextField tfSource;
    private JFormattedTextField tfTarget;

    private UnitConverter converter;

    public ConverterWindow()
    {
        Container window = getContentPane();
        
        window.setLayout(new FlowLayout());
        setTitle("Unit Converter");
        setSize(300, 120);

        this.converter = new LengthConverter();
        this.setup();
        setVisible(true);
    }

    private void setup()
    {
        this.lblInput = new JLabel("Enter your value: ");
        this.add(this.lblInput);

        this.lblOutput = new JLabel("Result value: ");
        this.add(this.lblOutput);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt)
            {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args)
    {
        new ConverterWindow();
    }

}
