import java.awt.*;

/**
 * BadApple
 * @author ������
 *
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("���|��Project����ʼ�ޤä�������");
		int width = 645;
		int height = 600;
		int x = Toolkit.getDefaultToolkit().getScreenSize().width - width >> 1;
		int y = Toolkit.getDefaultToolkit().getScreenSize().height - height >> 1;
		try {
			new MainFrame(x, y, width, height, "src/BadApple.dat");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("���|��Project���K�ˣ�����");
	}
}
