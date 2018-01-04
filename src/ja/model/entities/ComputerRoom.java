package ja.model.entities;

public class ComputerRoom extends Classroom {
	
	public ComputerRoom(){
		this.type=TYPE_COMPUTERROOM;
	}
	
	
	public ComputerRoom(int id, Level lev){
		super(id, lev);
		this.type=TYPE_COMPUTERROOM;
	}
	public ComputerRoom(int id, Level lev, int capacity){
		super(id, lev, capacity);
		this.type=TYPE_COMPUTERROOM;
	}
	
	
	
}
