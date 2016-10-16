package lab1;

public class Tools {
	static int int2RGB(int red, int green, int blue) {
		red %= 256;
		green %= 256;
		blue %= 256;
		return (red << 16) + (green << 8) + blue;
	}

	static int RGB2red(int rgb) {
		return rgb >> 16;
	}

	static int RGB2green(int rgb) {
		return (rgb >> 8) % 256;
	}

	static int RGB2blue(int rgb) {
		return rgb & 0x000000FF;
	}
}
