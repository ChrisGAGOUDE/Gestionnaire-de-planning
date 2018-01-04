package ja.model.entities;

public class LectureRoom extends Classroom {
	
	public LectureRoom(){
		this.type=TYPE_LECTUREROOM;
	}
	
	
	public LectureRoom(int id, Level lev){
		super(id, lev);
		this.type=TYPE_LECTUREROOM;
	}
	public LectureRoom(int id, Level lev, int capacity){
		super(id, lev, capacity);
		this.type=TYPE_LECTUREROOM;
	}
	
	
	
}
