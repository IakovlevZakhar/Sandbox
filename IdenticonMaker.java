import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class IdenticonMaker {

	public static void main(String[] args) throws IOException {
		PrintWriter out = new PrintWriter(new File("identicon.html"));
		int number = 100;
		int width = 140;
		int height = 140;
		int size = 4;
		out.println("\r\n" + "<!DOCTYPE html>\r\n" + "<body>\r\n" + " \r\n" + "<!-- SVG code -->");
		out.println("<svg width=\"" + width + "\" height=\"" + height * 11 / 10 * number + "\">");
		for (int i = 0; i < number; i++) {
			Random random = new Random();
			int x0 = 0;
			int y0 = height * 11 / 10 * i;
			int red = random.nextInt(256);
			int green = random.nextInt(256);
			int blue = random.nextInt(256);
			out.println("    <rect width=\"" + width + "\" height=\"" + height + "\" x = " + x0 + " y = " + y0
					+ " fill=\"rgb(" + (255 - red) + ", " + (25 - green) + ", " + (255 - blue) + ")\"/>");
			boolean[][] identicon = new boolean[2 * size - 1][2 * size - 1];
			for (int x = 0; x < size; x++) {
				for (int y = 0; y < 2 * size - 1; y++) {
					identicon[x][y] = random.nextBoolean();
				}
			}
			for (int x = 2 * size - 2; x >= size; x--) {
				for (int y = 0; y < 2 * size - 1; y++) {
					identicon[x][y] = identicon[2 * size - 2 - x][y];
				}
			}
			for (int x = 0; x < identicon.length; x++) {
				for (int y = 0; y < identicon[0].length; y++) {
					if (identicon[x][y]) {
						out.println("    <rect width=\"" + width / (2 * size - 1) + "\" height=\""
								+ height / (2 * size - 1) + "\" x = " + (x0 + x * width / (2 * size - 1)) + " y = "
								+ (y0 + y * height / (2 * size - 1)) + " fill=\"rgb(" + red + ", " + green + ", " + blue
								+ ")\"/>");
					}
				}
			}
		}
		out.println("</svg>\r\n" + " \r\n" + "</body>\r\n" + "</html>");
		out.close();
	}

}
