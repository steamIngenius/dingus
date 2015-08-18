import net.slashie.libjcsi.wswing.WSwingConsoleInterface;
import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import java.util.Properties;

public class HelloDungeon {

	private static final int SCREEN_WIDTH = 80;
	private static final int SCREEN_HEIGHT = 25;

	public static void main(String[] args) {
		Properties text = new Properties();
		text.setProperty("fontSize", "20");
		text.setProperty("font", "Consolas");

		ConsoleSystemInterface csi = null;
		try {
			csi = new WSwingConsoleInterface("Java roguelike - planting a seed.", text);
		}
		catch (ExceptionInInitializerError eiie) {
			System.out.println("*** Error: Swing Console Box cannot be initialized. Exitting...");
			eiie.printStackTrace();
			System.exit(-1);
		}


		csi.refresh();


		int x = SCREEN_WIDTH / 2;
		int y = SCREEN_HEIGHT / 2;
		boolean stop = false;

		while(!stop) {

			csi.cls();


			csi.print(0,0, "Hello! Welcome to Dingus!", CSIColor.COSMIC_LATTE);

	        csi.print(5,6, "########", CSIColor.GRAY);
	        csi.print(5,7, "#......#", CSIColor.GRAY);
	        csi.print(5,8, "#......#", CSIColor.GRAY);
	        csi.print(5,9, "####/###", CSIColor.GRAY);

	        csi.print(6,7, "......", CSIColor.BLUE);
	        csi.print(6,8, "......", CSIColor.BLUE);

	        csi.print(9,9, "/", CSIColor.BROWN);
	        csi.print(x,y, "@", CSIColor.WHITE);

			csi.refresh();
			CharKey dir = csi.inkey();

			if ((dir.isUpArrow() || dir.code == CharKey.k) && (y - 1 >= 0)) {
				y--;
			}

			if ((dir.code == CharKey.y) && (y - 1 >= 0) && (x - 1 >= 0)) {
				y--;
				x--;
			}

			if ((dir.code == CharKey.u) && (y-1 >=0) && (x + 1 < SCREEN_WIDTH)) {
				y--;
				x++;
			}

			if ((dir.isDownArrow() || dir.code==CharKey.j) && (y + 1 < SCREEN_HEIGHT)) {
				y++;
			}

			if((dir.code == CharKey.b) && (y + 1 < SCREEN_HEIGHT) && (x - 1 >= 0)) {
				y++;
				x--;
			}

			if ((dir.code == CharKey.n) && (y + 1 < SCREEN_HEIGHT) && (x + 1 < SCREEN_WIDTH)) {
				y++;
				x++;
			}

			if ((dir.isLeftArrow() || dir.code==CharKey.h) && (x - 1 >= 0)) {
				x--;
			}

			if ((dir.isRightArrow() || dir.code==CharKey.l) && (x + 1 < SCREEN_WIDTH)) {
				x++;
			}

			if (dir.code == CharKey.Q) {
				stop = true;
			}
		}
	}
}