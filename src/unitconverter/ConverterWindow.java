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
        this.converter = new LengthConverter();
        this.setup();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Unit Converter");
        setSize(300, 120);
        setVisible(true);
    }

    private void setup()
    {
        this.lblInput = new JLabel("Enter your value: ");
        this.add(this.lblInput);

        this.lblOutput = new JLabel("Result value: ");
        this.add(this.lblOutput);

        setupConversion();
        
    }

    private void setupConversion()
    {
        this.tfSource = new JFormattedTextField(10);
        this.tfTarget = new JFormattedTextField(10);
        
        this.tfTarget.setEditable(false);

        this.tfSource.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) 
            {
            }
        });

        this.add(this.tfSource);
        this.add(this.tfTarget);
    }

    public static void main(String[] args)
    {
        new ConverterWindow();
    }

}
