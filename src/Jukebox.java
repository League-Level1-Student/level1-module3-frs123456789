/*
 *    Copyright (c) The League of Amazing Programmers 2013-2018
 *    Level 1
 */

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import javazoom.jl.player.advanced.AdvancedPlayer;

/* 1. Download the JavaZoom jar from here: http://bit.ly/javazoom
 * 2. Right click your project and add it as an External JAR (Under Java Build Path > Libraries).*/

public class Jukebox implements Runnable, ActionListener {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Jukebox());
	}

	Song lemon = new Song("lemonknifefight.mp3");
	Song mount = new Song("MountainAtMyGates.mp3");
	Song happy = new Song("Happier.mp3");
	Song bohrhap = new Song("BohRhap.mp3");
	Song walkinginla = new Song("WalkInLA.mp3");
	Song ourhouse = new Song("OurHouse.mp3");
	Song walkoflife = new Song("walkoflife.mp3");
	Song seether = new Song("seether.mp3");
	Song zombie = new Song("zom.mp3");
	Song ussr = new Song("ussr.mp3");
	JButton jbl = new JButton("Lemon to a Knife Fight, The Wombats");
	JButton jbm = new JButton("Mountain at my Gates, Foals");
	JButton jbh = new JButton("Happier, Marshmallow and Bastille");
	JButton jbb = new JButton("Bohemian Rhapsody, Queen");
	JButton jbw = new JButton("Walking in LA, Missing Persons");
	JButton jbo = new JButton("Our House, Madness");
	JButton jbwo = new JButton("Walk of Life, Dire Straights");
	JButton jbs = new JButton("Seether, Veruca Salt");
	JButton jbz = new JButton("Zombie, Bad Wolves");
	JButton jbu = new JButton("SOVIET ANTHEM");

	public void run() {

		// 3. Find an mp3 on your computer or on the Internet.

		// 4. Create a Song

		// 5. Play the Song

		/*
		 * 6. Create a user interface for your Jukebox so that the user can to choose
		 * which song to play. You can use can use a different button for each song, or
		 * a picture of the album cover. When the button or album cover is clicked, stop
		 * the currently playing song, and play the one that was selected.
		 */
		JPanel jp = new JPanel();
		JFrame jf = new JFrame();

		jp.add(jbh);
		jp.add(jbm);
		jp.add(jbl);
		jp.add(jbb);
		jp.add(jbw);
		jp.add(jbo);
		jp.add(jbwo);
		jp.add(jbs);
		jp.add(jbz);
		jp.add(jbu);
		jf.add(jp);
		
		jf.setVisible(true);
		jbl.addActionListener(this);
		jbh.addActionListener(this);
		jbm.addActionListener(this);
		jbb.addActionListener(this);
		jbw.addActionListener(this);
		jbo.addActionListener(this);
		jbwo.addActionListener(this);
		jbs.addActionListener(this);
		jbz.addActionListener(this);
		jbu.addActionListener(this);
		jf.setPreferredSize(new Dimension(500,200));
		jf.pack();
		

	}

	/* Use this method to add album covers to your Panel. */
	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton pressed = (JButton) e.getSource();
		happy.stop();
		mount.stop();
		lemon.stop();
		bohrhap.stop();
		ourhouse.stop();
		walkinginla.stop();
		walkoflife.stop();
		seether.stop();
		zombie.stop();
		ussr.stop();
		if (pressed == jbh) {
			happy.play();
		} else if (pressed == jbm) {
			mount.play();
		} else if (pressed == jbl) {
			lemon.play();
		}
		else if(pressed == jbb) {
			bohrhap.play();
		}
		else if(pressed ==jbo) {
			ourhouse.play();
		}
		else if(pressed ==jbw) {
			walkinginla.play();
		}
		else if(pressed == jbwo) {
			walkoflife.play();
		}
		else if(pressed == jbs) {
			seether.play();
		}
		else if(pressed == jbz) {
			zombie.play();
		}
		else if(pressed == jbu) {
			ussr.play();
		}

	}

}

class Song {

	private int duration;
	private String songAddress;
	private AdvancedPlayer mp3Player;
	private InputStream songStream;

	/**
	 * Songs can be constructed from files on your computer or Internet addresses.
	 * 
	 * Examples: <code> 
	 * 		new Song("everywhere.mp3"); 	//from default package 
	 * 		new Song("/Users/joonspoon/music/Vampire Weekend - Modern Vampires of the City/03 Step.mp3"); 
	 * 		new	Song("http://freedownloads.last.fm/download/569264057/Get%2BGot.mp3"); 
	 * </code>
	 */
	public Song(String songAddress) {
		this.songAddress = songAddress;
	}

	public void play() {
		loadFile();
		if (songStream != null) {
			loadPlayer();
			startSong();
		} else
			System.err.println("Unable to load file: " + songAddress);
	}

	public void setDuration(int seconds) {
		this.duration = seconds * 100;
	}

	public void stop() {
		if (mp3Player != null)
			mp3Player.close();
	}

	private void startSong() {
		Thread t = new Thread() {
			public void run() {
				try {
					if (duration > 0)
						mp3Player.play(duration);
					else
						mp3Player.play();
				} catch (Exception e) {
				}
			}
		};
		t.start();
	}

	private void loadPlayer() {
		try {
			this.mp3Player = new AdvancedPlayer(songStream);
		} catch (Exception e) {
		}
	}

	private void loadFile() {
		if (songAddress.contains("http"))
			this.songStream = loadStreamFromInternet();
		else
			this.songStream = loadStreamFromComputer();
	}

	private InputStream loadStreamFromInternet() {
		try {
			return new URL(songAddress).openStream();
		} catch (Exception e) {
			return null;
		}
	}

	private InputStream loadStreamFromComputer() {
		try {
			return new FileInputStream(songAddress);
		} catch (FileNotFoundException e) {
			return this.getClass().getResourceAsStream(songAddress);
		}
	}
}
