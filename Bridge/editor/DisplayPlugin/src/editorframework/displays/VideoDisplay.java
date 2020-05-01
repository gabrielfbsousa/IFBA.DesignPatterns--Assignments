/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.displays;

import javax.swing.JFrame;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import editorframework.interfaces.IDisplay;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

/**
 *
 * @author gabriel
 */
public class VideoDisplay implements IDisplay {

    private String name;

    public VideoDisplay() {
        this.name = "Video";
    }

    @Override
    public JPanel show(final String address) {
        NativeLibrary.addSearchPath("libvlc", "/usr/lib/");
        Native.loadLibrary("libvlc", LibVlc.class);

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());

        javax.swing.JButton button = buildButton("media-playback-start");
        painel.add(button);

        if (button != null) {
            button.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    play(address);
                }
            });
        }

        return painel;

    }

    @Override
    public String getName() {
        return this.name;
    }

    public JButton buildButton(String iconName) {
        javax.swing.JButton newButton = new javax.swing.JButton();
        newButton.setIcon(new javax.swing.ImageIcon("/usr/share/icons/oxygen/48x48/actions/" + iconName + ".png"));
        newButton.setFocusable(false);
        newButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        return newButton;
    }

    public void play(String address) {
        JFrame frame = new JFrame("Frame from video");

        MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();

        Canvas canvas = new Canvas();
        canvas.setBackground(Color.black);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(canvas, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.CENTER);

        EmbeddedMediaPlayer mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();
        mediaPlayer.setVideoSurface(mediaPlayerFactory.newVideoSurface(canvas));
        frame.setLocation(100, 100);
        frame.setSize(1050, 600);
        frame.setVisible(true);

        mediaPlayer.playMedia(address + ".mp4");
    }
}
