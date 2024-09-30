package interface18;

public class Triangle extends FigureData implements Figure, Drawable{

	public Triangle(int width, int height) {
		super(width, height);
	}

	@Override
	public void draw(String figureName) {
		System.out.println(figureName+"을 하나의 선으로 그리다.");
	}

	@Override
	public void area(String figureName) {
		System.out.println(figureName + "의 면적 = "+(int)(width*height*0.5));
	}
	

}
