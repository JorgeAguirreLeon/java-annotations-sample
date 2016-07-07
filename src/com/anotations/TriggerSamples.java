package com.anotations;

public class TriggerSamples {

	private TriggerSamples() {
	};

	@Trigger("hello")
	public static boolean hello() {
		System.out.println("Hello world!");
		return true;
	}

	@Trigger("bye")
	public static boolean goodbye() {
		System.out.println("Goodbye");
		return false;
	}

}
