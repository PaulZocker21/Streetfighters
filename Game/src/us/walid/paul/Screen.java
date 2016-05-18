package us.walid.paul;

public class Screen {

	private int width, height;
	private int[] pixels;
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		this.pixels = new int[width * height];
	}
	
}
