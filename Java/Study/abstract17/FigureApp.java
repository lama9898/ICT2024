package abstract17;

public class FigureApp {

	public static void main(String[] args) {
		//Figure f= new Figure();	//Cannot instantiate the type Figure
		Figure f = new Rectangle(100,80);
		f.area("사각형");
		f = new Triangle(100,80);
		f.area("삼각형");
		f = new Circle(100);
		f.area("원");

	}

}
