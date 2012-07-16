//SoundClip encapsulates the Java Sound API classes needed to
//load and play a sound file (AIFF, AU, or WAV). The sound file
//is not streamed or tracked so this class should only be used for
//smallish sound files that can be quickly loaded by an applet.

import javax.sound.sampled.*;
import java.io.*;
import java.net.*;

public class SoundClip {
    //the source for audio data
    private AudioInputStream sample;

    //sound clip property is read-only here
    private Clip clip;
    public Clip getClip() { return clip; }

    //looping property for continuous playback
    private boolean looping = false;
    public void setLooping(boolean _looping) { looping = _looping; }
    public boolean getLooping() { return looping; }

    //repeat property used to play sound multiple times
    private int repeat = 0;
    public void setRepeat(int _repeat) { repeat = _repeat; }
    public int getRepeat() { return repeat; }

    //filename property
    private String filename = "";
    public void setFilename(String _filename) { filename = _filename; }
    public String getFilename() { return filename; }

    //property to verify when sample is ready
    public boolean isLoaded() {
        return (boolean)(sample != null);
    }

    //constructor
    public SoundClip() {
        try {
            //create a sound buffer
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
        }
    }
    //this overloaded constructor takes a sound file as a parameter
    public SoundClip(String audiofile) {
        this();  //call default constructor first
        load(audiofile); //now load the audio file
    }

//***************
    private URL getURL(String filename) {
    URL url = null;
    try {
        url = this.getClass().getResource(filename);
    }
    catch (Exception e) { }

    return url;
}

    //load sound file
    public boolean load(String audiofile) {
        try {

            //prepare the input stream for an audio file
            setFilename(audiofile);
//***************
            sample = AudioSystem.getAudioInputStream(getURL(filename));
            //load the audio file
            clip.open(sample);
            return true;

        } catch (IOException e) {
            return false;
        } catch (UnsupportedAudioFileException e) {
            return false;
        } catch (LineUnavailableException e) {
            return false;
        }
    }

    public void play() {
        //exit if the sample hasn't been loaded
        if (!isLoaded()) return;

        //reset the sound clip
        clip.setFramePosition(0);

        //play sample with optional looping
        if (looping)
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        else
            clip.loop(repeat);
    }

}
