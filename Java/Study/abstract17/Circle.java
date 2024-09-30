package abstract17;

public class Circle extends Figure {

	
	
	public Circle(int radius) {
		super(radius);
		System.out.println("Circle의 인자 생성자");
	}

	@Override
	void area(String figureName) {
		System.out.println(figureName + "의 면적 = "+(int)(radius*radius*Math.PI));
		
	}
	

}
