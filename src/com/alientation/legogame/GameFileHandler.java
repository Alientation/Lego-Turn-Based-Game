package com.alientation.legogame;

import org.json.simple.JSONObject;

public class GameFileHandler {
	public static JSONObject dataFile = null;
	
	public static void init(JSONObject df) {
		dataFile = df;
	}
	
	
	@SuppressWarnings("unchecked")
	public static void save(String attributeName, Object obj) {
		dataFile.put(attributeName, obj);
	}
	
	@SuppressWarnings("unchecked")
	public static Object load(String attributeName, Object defaultValue) {
		return dataFile.getOrDefault(attributeName, defaultValue);
	}
}
