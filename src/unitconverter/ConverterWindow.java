package unitconverter;
import java.awt.Container;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import javax.swing.*;

@SuppressWarnings("serial")
public class ConverterWindow extends JFrame {

    private String[] converterList = { "LengthConverter" };
    private Container window;
    private JLabel lblConverterType;
    private JLabel lblInput;
    private JLabel lblOutput;
    private JFormattedTextField tfSource;
    private JFormattedTextField tfTarget;
    private JComboBox cbConverter;
    private JComboBox cbSourceUnit;
    private JComboBox cbTargetUnit;
    
    private UnitConverter converter;

    public ConverterWindow()
    {
        window = getContentPane();
        window.setLayout(new FlowLayout());
        converter = new LengthConverter();
        
        setup();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Unit Converter");
        setSize(300, 120);
        setVisible(true);
    }

    private void setup()
    {
        setupSource();
        setupTarget();
    }
    
    private void setupSource()
    {
        lblInput = new JLabel("Enter your value: ", JLabel.LEFT);
        window.add(lblInput);
        tfSource = new JFormattedTextField(new DecimalFormat());
        tfSource.setColumns(10);
        window.add(tfSource);
    }

    private void setupTarget()
    {
        lblOutput = new JLabel("Result value: ", JLabel.LEFT);
        window.add(lblOutput);
        
        tfTarget = new JFormattedTextField(new DecimalFormat());
        tfTarget.setColumns(10);
        window.add(tfTarget);
    }
    
    public static void main(String[] args)
    {
        new ConverterWindow();
    }

}
