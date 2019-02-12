package com.heatclinic.utilities;

import com.heatclinic.framework.DriverFactory;

public class Delayed {

	public void sleeper(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void delay(int time) {
		final String tbrowser = DriverFactory.initialize().getdriver().toString();
		System.out.println(tbrowser.contains("ch"));
		switch (tbrowser) {

		case "chrome":
			sleeper(time - time);
			break;

		case "ch-grid":
			sleeper(time - time);
			break;

		case "ch-cloud":
			sleeper(time - time);
			break;

		case "headless":
			sleeper(time - time);
			break;

		default:
			sleeper(time);
			break;
		}
	}

}
