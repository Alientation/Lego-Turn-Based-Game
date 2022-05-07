package com.alientation.legogame;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
	
	
	public static Path currentRelativePath = Paths.get("");
	public static String path = currentRelativePath.toAbsolutePath().toString() + "\\saves";
	public static String savePath = null, gameName = null;
	public static Scanner console = new Scanner(System.in);
	public static Game game;
	public static String lineSeparator = "------------------------------------------------------------------------------------------------------------------------------";
	public static JSONObject data = null;
	
	public static void main(String[] args) {
		System.out.print("Welcome to the Lego Turn Based Game\n" + lineSeparator + "\n(1) New Game\n(2) Load Previous Saved Game\n(3) Help\n(4) Settings\n" + lineSeparator + "\n>>> ");
		int input = console.nextInt();
		console.nextLine();
		switch (input) {
		case 1:
			data = new JSONObject();
			GameFileHandler.init(data);
			Game.addBlankLines();
			System.out.print("Enter Game Name (no spaces)\n" + lineSeparator + "\n>>> ");
			gameName = console.next();
			GameFileHandler.save("name", gameName);
			savePath = path + "\\" + gameName + ".json";
			GameFileHandler.save("savePath", savePath);
			console.nextLine();
			startGame();
			break;
		case 2:
			openSaves();
			break;
		case 3:
			help();
			break;
		case 4:
			settings();
			break;
		default:
			break;
		}
	}
	private static void openSaves() {
		Game.addBlankLines();
		System.out.print("Choose a game save file\n" + lineSeparator + "\n");
		File f = new File(path);
		String[] pathnames = f.list();
		for (int i = 0; i < pathnames.length; i++) {
			System.out.println("(" + i + ") " + pathnames[i]);
		}
		System.out.println("(-1) Exit");
		System.out.print(lineSeparator + "\n>>> ");
		int input = console.nextInt();
		if (input < 0) {
			console.nextLine();
			return;
		} else if (input >= pathnames.length) {
			console.nextLine();
			openSaves();
		} else {
			console.nextLine();
			Object obj = null;
			try {
				savePath = path + "\\" + pathnames[input];
				gameName = pathnames[input].replaceAll(".json", "");
				System.out.println(savePath);
				FileReader reader = new FileReader(savePath);
				JSONParser parser = new JSONParser();
				obj = parser.parse(reader);
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}
			if (obj != null) {
				data = (JSONObject) obj;
				GameFileHandler.init(data);
			} else {
				openSaves();
			}
		}
		if (((String) GameFileHandler.load("note", "")).length() == 0) {
			
		} else {
			Game.addBlankLines();
			System.out.println(Main.lineSeparator + "\nHere is your note from the previous time you played this save\n" + Main.lineSeparator + "\n\"" + GameFileHandler.load("note", "No Notes Found!") + "\"");
			Main.hold();
		}
		Game.initGame();
		Game.initData();
		game = new Game();
	}
	
	public static void help() {
		
	}
	
	public static void settings() {
		
	}

	private static void startGame() {
		Game.initGame();
		Quests.generateNewQuests();
		game = new Game();
	}

	public static void hold() {
		System.out.println(Main.lineSeparator + "\nPRESS ENTER TO CONTINUE\n" + Main.lineSeparator);
		console.nextLine();
	}
}
