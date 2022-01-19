package GettingStarted;

import com.phidget22.*;

public class TugOfWar {
	public static void main(String[] args) throws Exception {
		DigitalInput redButton = new DigitalInput();
		DigitalOutput redLED = new DigitalOutput();
		DigitalInput greenButton = new DigitalInput();
		DigitalOutput greenLED = new DigitalOutput();
		boolean checkRed = redButton.getState();
		boolean checkGreen = greenButton.getState();
		int countRed = 0, countGreen = 0;

		redButton.setHubPort(0);
		redButton.setIsHubPortDevice(true);
		redLED.setHubPort(1);
		redLED.setIsHubPortDevice(true);
		greenButton.setHubPort(5);
		greenButton.setIsHubPortDevice(true);
		greenLED.setHubPort(4);
		greenLED.setIsHubPortDevice(true);

	}
}
