package Util;

import org.apache.log4j.Logger;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Ryan on 11/23/2015.
 */
public class Sounds {
    private static final Logger log = Logger.getLogger(Sounds.class);
    public static void main(String[] args) {

        String soundName = "chaching.wav";
        try{
            AudioInputStream aIS = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(aIS);
            clip.start();

        } catch (LineUnavailableException e) {
            log.error(e);
            e.printStackTrace();
        } catch (IOException e) {
            log.error(e);
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            log.error(e);
            e.printStackTrace();
        }
    }
}
