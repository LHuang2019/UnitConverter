package unitconverter;

/**
 * Length converter class
 * @author Li Huang
 * @version 4.30.2017
 */
public class LengthConverter implements UnitConverter {

    // variable for conversion
    final static private double KM_TO_METER = 1000;
    final static private double CM_TO_METER = 0.01;
    final static private double MM_TO_METER = 0.001;
    final static private double MILE_TO_METER = 1609.34;
    final static private double YARD_TO_METER = 0.9144;
    final static private double FOOT_TO_METER = 0.3048;
    final static private double INCH_TO_METER = 0.0254;
    final static private double NAUTICAL_MILE_TO_METER = 0.3048;

    private String sourceUnit;
    private String targetUnit;
    private double source;
    private double target;

    // default constructor
    public LengthConverter()
    {
        this.sourceUnit = "";
        this.targetUnit = "";
        this.source = 0;
        this.target = 0;
    }

    // Parameterized constructor
    public LengthConverter(String sourceUnit, String targetUnit, double source)
    {
        this.sourceUnit = sourceUnit;
        this.targetUnit = targetUnit;
        this.source = source;
        this.target = 0;
    }

    /**
     * return source unit
     */
    @Override
    public String getSourceUnit() {
        return this.sourceUnit;
    }

    /**
     * return target unit
     */
    @Override
    public String getTargetUnit() {
        return this.targetUnit;
    }

    /**
     * return source value
     */
    @Override
    public double getSource() {
        return this.source;
    }

    /**
     * return target value
     */
    @Override
    public double getTarget() {
        return this.target;
    }

    /**
     * set source unit
     */
    @Override
    public void setSourceUnit(String sourceUnit) {
        this.sourceUnit = sourceUnit;
    }

    /**
     * set target unit
     */
    @Override
    public void setTargetUnit(String targetUnit) {
        this.targetUnit = targetUnit;
    }

    /**
     * set source value
     */
    @Override
    public void setSource(double source) {
        this.source = source;
    }

    /**
     * set target value
     */
    @Override
    public void setTarget() {
        this.target = this.convert();
    }

    /**
     * method which does the conversion from source to target for the object
     * @return the converted value
     */
    private double convert()
    {
        double value = 0;

        if (this.sourceUnit.equals(this.target))
            return this.source;
        else if (this.source == 0)
            return 0;

        switch (this.sourceUnit) {
        case "Meter" :
            value = this.source;
        case "Kilometer" :
            value = this.source * KM_TO_METER;
        case "Centimeter" :
            value = this.source * CM_TO_METER;
        case "Millimeter" :
            value = this.source * MM_TO_METER;
        case "Mile" :
            value = this.source * MILE_TO_METER;
        case "Yard" :
            value = this.source * YARD_TO_METER;
        case "Foot" :
            value = this.source * FOOT_TO_METER;
        case "Inch" :
            value = this.source * INCH_TO_METER;
        case "Nautical mile" :
            value = this.source * NAUTICAL_MILE_TO_METER;
        }

        switch (this.targetUnit) {
        case "Kilometer" :
            value /= KM_TO_METER;
        case "Centimeter" :
            value /= CM_TO_METER;
        case "Millimeter" :
            value /= MM_TO_METER;
        case "Mile" :
            value /= MILE_TO_METER;
        case "Yard" :
            value /= YARD_TO_METER;
        case "Foot" :
            value /= FOOT_TO_METER;
        case "Inch" :
            value /= INCH_TO_METER;
        case "Nautical mile" :
            value /= NAUTICAL_MILE_TO_METER;
        }

        return value;
    }

    /**
     * method which resets the converter to initial state
     */
    @Override
    public void reset() {
        this.sourceUnit = "";
        this.targetUnit = "";
        this.source = 0;
        this.target = 0;
    }

    /**
     * toString method for lengthConverter object
     * returns the state of the object
     */
    @Override
    public String toString()
    {
        String message = "Current state:\n"
                + "source: " + this.source + " " + this.sourceUnit + "\n"
                + "target: " + this.target + " " + this.targetUnit;
        return message;

    }

}
