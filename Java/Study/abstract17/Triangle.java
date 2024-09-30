package abstract17;

public class Triangle extends Figure {

	public Triangle(int width, int height) {
		super(width, height);
		System.out.println("Triangle의 인자 생성자");
	}
	
	@Override
	void area(String figureName) {
		System.out.println(figureName + "의 면적 = "+(int)(width*height*0.5));
		
	}
}
