package com.anotations;

import java.lang.reflect.Method;
import java.util.Scanner;

public class TriggerExecutor {

	private TriggerExecutor() {};

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		// Testing method level annotation
		boolean active = true;
		while (active) {
			System.out.print("Trigger a specific method based on it's annotation (TriggerSamples): ");
			String read_line = scanner.nextLine();
			for (Method method : TriggerSamples.class.getMethods()) {
				Trigger trigger = method.getAnnotation(Trigger.class);
				if (trigger != null && trigger.value().equalsIgnoreCase(read_line)) {
					Object returned = method.invoke(null);
					if (returned != null && returned instanceof Boolean) {
						boolean return_value = (boolean) returned;
						active = return_value;
					}
				}
			}
		}
		scanner.close();
	}

}
