package unitconverter;

public interface UnitConverter {

	//Getter methods
	String getSourceUnit();
	String getTargetUnit();
	double getSource();
	double getTarget();
	
	//Setter methods
	void setSourceUnit();
	void setTargetUnit();
	void setSource();
	void setTarget();
	
	//Conversion
	double convert();
	
	//useful methods
	void clear();
	String toString();
}
