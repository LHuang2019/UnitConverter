package unitconverter;

import java.awt.*;

@SuppressWarnings("serial")
public class ConverterWindow extends Frame {

    private Button btnConvert;
    
    private Label lblInput;
    private Label lblOutput;
    
    private TextField tfSource;
    private TextField tfTarget;
    
    private LengthConverter converter;
    
    public ConverterWindow()
    {
        setLayout(new FlowLayout());
        setTitle("Unit Converter");
        setSize(300, 120);
        
        this.setup();
        
        setVisible(true);
    }
    
    private void setup()
    {
        this.lblInput = new Label("Enter your value: ");
        this.add(this.lblInput);
        
        this.tfSource = new TextField(10);
        this.add(this.tfSource);
        
        this.lblOutput = new Label("Result value: ");
        this.add(this.lblOutput);
        
        this.tfTarget = new TextField(10);
        this.tfTarget.setEditable(false);
        this.add(this.tfTarget);
    }
    
    public static void main(String[] args)
    {
        new ConverterWindow();
    }

}
 