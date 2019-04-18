package source;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class MusicPlayer extends Thread {

	private File file;
	
	MusicPlayer(String path) {
		file = new File(path);
	}

	@Override
	public void run() {
		try {
			URI uri = file.toURI();
			URL url = uri.toURL();
			AudioClip clip = Applet.newAudioClip(url);
			clip.play();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
