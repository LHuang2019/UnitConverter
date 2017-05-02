package unitconverter;

public interface UnitConverter {

	//Getter methods
	String getSourceUnit();
	String getTargetUnit();
	double getSource();
	double getTarget();
	
	//Setter methods
	String setSourceUnit();
	String setTargetUnit();
	double setSource();
	double setTarget();
	
	//Conversion
	double convert();
	
	//useful methods
	void clear();
	String toString();
}
