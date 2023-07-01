package com.iterator.pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class SongInfo {
	String songName;
	String bandName;
	int yearReleased;

	SongInfo(String newSongName, String newBandName, int newYearReleased) {
		songName = newSongName;
		bandName = newBandName;
		yearReleased = newYearReleased;
	}

	public String getSongName() {
		return songName;
	}

	public String getBandName() {
		return bandName;
	}

	public int getYearReleased() {
		return yearReleased;
	}

}

interface SongIterator {
	public Iterator<SongInfo> createIterator();

}

class SongsOfThe70s implements SongIterator {
	List<SongInfo> bestSongs;

	SongsOfThe70s() {
		bestSongs = new ArrayList<SongInfo>();
		addSong("Imagine", "John Lennon", 1971);
		addSong("American Pie", "Don McLean", 1971);
		addSong("I Will Survive", "Gloria Gaynor", 1979);

	}

	public Iterator<SongInfo> createIterator() {

		return bestSongs.iterator();
	}

	public void addSong(String songName, String bandName, int yearReleased) {
		SongInfo songInfo = new SongInfo(songName, bandName, yearReleased);
		bestSongs.add(songInfo);
	}

	public List<SongInfo> getBestSongs() {
		return bestSongs;
	}
}

class SongsOfThe80s implements SongIterator {
	SongInfo[] bestSongs;

	int arrayValue = 0;

	SongsOfThe80s() {
		bestSongs = new SongInfo[3];
		addSong("Roam", "B 52s", 1989);
		addSong("Cruel Summer", "Bananarama", 1984);
		addSong("Head Over Heels", "Tears For Fears", 1985);
	}

	private void addSong(String songName, String bandName, int yearReleased) {
		SongInfo songInfo = new SongInfo(songName, bandName, yearReleased);
		bestSongs[arrayValue] = songInfo;
		arrayValue++;
	}

	public SongInfo[] getBestSongs() {
		return bestSongs;
	}

	public Iterator<SongInfo> createIterator() {

		return Arrays.asList(bestSongs).iterator();
	}

}

class SongsOfThe90s implements SongIterator {
	Hashtable<Integer, SongInfo> bestSongs;

	int hashKey = 0;

	SongsOfThe90s() {
		bestSongs = new Hashtable<Integer, SongInfo>();
		addSong("Losing My Religion", "REM", 1991);
		addSong("Creep", "Radiohead", 1993);
		addSong("Walk on the Ocean", "Toad The Wet Sprocket", 1991);

	}

	private void addSong(String songName, String bandName, int yearReleased) {
		SongInfo songInfo = new SongInfo(songName, bandName, yearReleased);
		bestSongs.put(hashKey, songInfo);
		hashKey++;
	}

	public Hashtable<Integer, SongInfo> getBestSongs() {
		return bestSongs;
	}

	public Iterator<SongInfo> createIterator() {

		return bestSongs.values().iterator();
	}

}
class SongsOfThe20s implements SongIterator {
	Set<SongInfo> bestSongs;

	SongsOfThe20s() {
		bestSongs = new HashSet<SongInfo>();
		addSong("Imagine1", "John Lennon1", 2001);
		addSong("American Pie1", "Don McLean1", 2003);
		addSong("I Will Survive1", "Gloria Gaynor1", 2009);

	}

	public Iterator<SongInfo> createIterator() {

		return bestSongs.iterator();
	}

	public void addSong(String songName, String bandName, int yearReleased) {
		SongInfo songInfo = new SongInfo(songName, bandName, yearReleased);
		bestSongs.add(songInfo);
	}

	public Set<SongInfo> getBestSongs() {
		return bestSongs;
	}
}
class DiscJockey {

	SongIterator iter70sSongs;
	SongIterator iter80sSongs;
	SongIterator iter90sSongs;
	SongIterator iter20sSongs;
	DiscJockey(SongIterator newSongs70s, SongIterator newSongs80s, SongIterator newSongs90s,SongIterator newSongs20s) {
		iter70sSongs = newSongs70s;
		iter80sSongs = newSongs80s;
		iter90sSongs = newSongs90s;
		iter20sSongs = newSongs20s;
	}

	public void showTheSongs() {
		Iterator<SongInfo> Songs70s = iter70sSongs.createIterator();
		System.out.println("Songs of the 70s\n");
		printTheSongs(Songs70s);

		Iterator<SongInfo> Songs80s = iter80sSongs.createIterator();
		System.out.println("Songs of the 80s\n");
		printTheSongs(Songs80s);

		Iterator<SongInfo> Songs90s = iter90sSongs.createIterator();
		System.out.println("Songs of the 90s\n");
		printTheSongs(Songs90s);
		
		Iterator<SongInfo> Songs20s = iter20sSongs.createIterator();
		System.out.println("Songs of the 20s\n");
		printTheSongs(Songs20s);

	}

	public void printTheSongs(Iterator<SongInfo> iterator) {
		while (iterator.hasNext()) {
			SongInfo songInfo = (com.iterator.pattern.SongInfo) iterator.next();
			System.out.println(songInfo.getSongName());
			System.out.println(songInfo.getBandName());
			System.out.println(songInfo.getYearReleased() + "\n");
		}
	}
}

public class RadioStation {

	public static void main(String[] args) {
		SongIterator songsOfThe70s = new SongsOfThe70s();
		SongIterator songsOfThe80s = new SongsOfThe80s();
		SongIterator songsOfThe90s = new SongsOfThe90s();
		SongIterator songsOfThe20s = new SongsOfThe20s();
		DiscJockey discJockey = new DiscJockey(songsOfThe70s, songsOfThe80s, songsOfThe90s,songsOfThe20s);
		discJockey.showTheSongs();
	}

}
