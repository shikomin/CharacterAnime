import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class MainFrame extends JFrame {

	private static final int MAX_FRAME = 6568;
	private static final int MAX_LINE;

	static {
		MAX_LINE = 35;
	}

	private JTextArea textArea;

	private File file;

	private Reader reader;

	private String[] buffer = new String[MAX_FRAME];

	MainFrame(int x, int y, int width, int height, String path) throws InterruptedException {
		init(x, y, width, height, path);
		mainLoop();
	}

	private void init(int x, int y, int width, int height, String path) {
		Thread t=new Thread(new MusicPlayer("src/BadApple.wav"));
		t.start();
		this.setBounds(x, y, width, height);
		this.setResizable(false); // ���ɸı��С
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // �رշ�ʽ
		this.setTitle("BadApple!!");
		this.setUndecorated(false); // �б߿�

		textArea = new JTextArea();
		this.add(textArea);
		textArea.setBounds(0, 0, width, height);
		textArea.setFont(new Font("Lucida Console", Font.PLAIN, 15));
		file = new File(path);
		textArea.setForeground(Color.white);
		textArea.setBackground(Color.BLACK);
		readBuffer();
		this.setVisible(true);
	}

	private void readBuffer() {
		try {
			reader = new Reader(file);

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < MAX_FRAME; i++) {
				for (int j = 0; j < MAX_LINE; j++) {
					String str = reader.readLine();
					sb.append(str);
					sb.append('\n');
				}
				buffer[i] = sb.toString();
				sb = new StringBuilder("");
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void mainLoop() throws InterruptedException {
		for (int i = 0; i < MAX_FRAME; i++) {
			textArea.setText(buffer[i]);
			Thread.sleep(33);
		}
	}
}
