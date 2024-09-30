package interface18;


//이질화 다시보기
public class FigureDrawableApp {

	public static void main(String[] args) {
		Figure f = new Rectangle(100,100);
		f.area("사각형");
		//f.draw("사각형");
		// 형변환(이질화)
		((Rectangle)f).draw("사각형");
		((Drawable)f).draw("사각형");
		
		Drawable d = new Triangle(100,100);
		d.draw("삼각형");
		((Triangle)d).area("삼각형");
		((Figure)d).area("삼각형");
		
		//동질화
		Circle c = new Circle(100);
		c.area("원");
		c.draw("원");
		

	}

}
