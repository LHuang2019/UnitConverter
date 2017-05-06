package unitconverter;

import java.awt.*;

public class ConverterWindow extends Frame {

    private Button convert;
    
    private Label lbInput;
    private Label lbOutput;
    
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
        this.lbInput = new Label("Enter your value: ");
        this.add(this.lbInput);
        
        this.tfSource = new TextField(10);
        this.add(this.tfSource);
        
        this.lbOutput = new Label("Result value: ");
        this.add(this.lbOutput);
        
        this.tfTarget = new TextField(10);
        this.tfTarget.setEditable(false);
        this.add(this.tfTarget);
    }
    
    public static void main(String[] args)
    {
        new ConverterWindow();
    }

}
 