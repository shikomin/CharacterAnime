package source;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class VPlayer {

	static final int MAX_LINE = 39;

	public static void main(String[] args) {
		BufferedReader br = null;
		//Thread t = new Thread(new MusicPlayer("src/cxk.wav"));
		//t.start();
		try {
			br = new BufferedReader(new FileReader("src/DataF.txt"));
			String s = null;
			int line = 1;
			while ((s = br.readLine()) != null) {
				System.out.println(s);
				line++;
				if (line > MAX_LINE) {
					line = 1;
					Thread.sleep(38);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
