package ja.model.entities;

public class ChemistryLab extends Classroom {
	
	public ChemistryLab(){
		this.type=TYPE_CHEMISTRYLAB;
	}
	
	
	public ChemistryLab(int id, Level lev){
		super(id, lev);
		this.type=TYPE_CHEMISTRYLAB;
	}
	public ChemistryLab(int id, Level lev, int capacity){
		super(id, lev, capacity);
		this.type=TYPE_CHEMISTRYLAB;
	}
	
	
	
}
