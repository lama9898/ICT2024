package abstract17;

abstract public class Figure {
	int width,height,radius;

	public Figure() {	System.out.println("추상 클래스(Figure)의 기본 생성자");		}

	public Figure(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public Figure(int radius) {
		this.radius = radius;
	}
	
	//추상 메소드
	// 도형의 면적을 구하는 추상 메소드
	abstract void area(String figureName); 
	
	
	
}
