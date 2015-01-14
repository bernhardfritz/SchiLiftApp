package controllers;

public class Tool {
	public static int StringToInt(String s) {
		return s.equals("")?0:Integer.parseInt(s.replace(".", " ").replace(" ", ""));
	}
	
	public static float StringToFloat(String s) {
		return s.equals("")?0f:Float.parseFloat(s);
	}
}
