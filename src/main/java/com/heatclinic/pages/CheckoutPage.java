package com.heatclinic.pages;

import com.heatclinic.framework.PropertyReader;

public class CheckoutPage {

	private void sleeper(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void delay(int time) {
		String tbrowser=PropertyReader.BROWSER_TO_RUN;
		switch (tbrowser) {
		
		case "chrome":
			sleeper(time-time);
			break;
		
		case "ch-grid":
			sleeper(time-time);
			break;
			
		case "ch-cloud":
			sleeper(time-time);
			break;
			
		case "":
			sleeper(time-time);
			break;
			
		default:
			sleeper(time);
			break;
	}
	
	
}

	
	
	
}
