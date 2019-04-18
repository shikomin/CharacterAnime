import java.awt.*;

/**
 * BadApple
 * @author 胥珂铭
 *
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("「東方Project」が始まった！！！");
		int width = 645;
		int height = 600;
		int x = Toolkit.getDefaultToolkit().getScreenSize().width - width >> 1;
		int y = Toolkit.getDefaultToolkit().getScreenSize().height - height >> 1;
		try {
			new MainFrame(x, y, width, height, "src/BadApple.dat");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("「東方Project」終了！！！");
	}
}
