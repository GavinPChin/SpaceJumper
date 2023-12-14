package Games;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class Audio {
	
	public static Map<String, Music> musicMap = new HashMap<String, Music>();
	public static Map<String, Sound> soundMap = new HashMap<String, Sound>();
	public static Map<String, Sound> clickMap = new HashMap<String, Sound>();
	public static Map<String, Sound> pauseMap = new HashMap<String, Sound>();
	
	public static void load() {
		try {
		musicMap.put("music", new Music("resource/SpaceJumpersMusic.wav"));
		soundMap.put("jump", new Sound("resource/jump.wav"));
		clickMap.put("click", new Sound("resource/click.wav"));
		pauseMap.put("pause", new Sound("resource/pause.wav"));
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
	}
	public static Music getMusic(String key) {
		return musicMap.get(key);
	}
	
	public static Sound getSound(String key) {
		return soundMap.get(key);
	}
	
	public static Sound getClick(String key) {
		return clickMap.get(key);
	}
	
	public static Sound getPause(String key) {
		return pauseMap.get(key);
	}
}
