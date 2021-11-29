package RoverKit;

import com.phidget22.*;

public class AvoidObstacles {
	public static void main(String[] args) throws Exception {

// Connect to wireless rover
		Net.addServer("", "192.168.100.1", 5661, "", 0);

// Create
		DCMotor leftMotors = new DCMotor();
		DCMotor rightMotors = new DCMotor();

		leftMotors.setHubPort(5);
		leftMotors.setChannel(0);
		rightMotors.setHubPort(5);
		rightMotors.setChannel(1);

		DistanceSensor sonar = new DistanceSensor();

// Open
		leftMotors.open(5000);
		rightMotors.open(5000);
		sonar.open(5000);
		/*
		 * while (true) {
		 *
		 * System.out.println("Distance: " + sonar.getDistance() + " mm");
		 *
		 * if (sonar.getDistance() < 250) { //Object detected! Stop motors
		 * leftMotors.setTargetVelocity(-0.5); rightMotors.setTargetVelocity(-0.5);
		 *
		 * Thread.sleep(1000);
		 *
		 * leftMotors.setTargetVelocity(0); rightMotors.setTargetVelocity(0); } else {
		 * //Move forward slowly (25% max speed) leftMotors.setTargetVelocity(0.25);
		 * rightMotors.setTargetVelocity(0.25); }
		 *
		 * //Wait for 250milliseconds Thread.sleep(250); }
		 */

		int a = 1;

		int b = -1;

		while (true) {

			for (int x = 0; x < 200; x++) {
				System.out.println(sonar.getDistance());
				if (sonar.getDistance() > 250) {
					leftMotors.setTargetVelocity(-0.5);
					rightMotors.setTargetVelocity(-0.5);

					Thread.sleep(10);
				}
			}
			if (sonar.getDistance() < 250) {
				Thread.sleep(100);
				leftMotors.setTargetVelocity(1);
				rightMotors.setTargetVelocity(1);
				Thread.sleep(100);
				leftMotors.setTargetVelocity(1);
				rightMotors.setTargetVelocity(-1);

				Thread.sleep(800);

				int x, y;

				x = a;

				y = b;

				a = y;

				b = x;
				
				

				leftMotors.setTargetVelocity(0);
				rightMotors.setTargetVelocity(0);
			}

			leftMotors.setTargetVelocity(a);
			rightMotors.setTargetVelocity(b);

			Thread.sleep(550);

			leftMotors.setTargetVelocity(0);
			rightMotors.setTargetVelocity(0);
		}

// Thread.sleep(100);

	}

	/*
	 * leftMotors.setAcceleration(leftMotors.getMaxAcceleration());
	 * rightMotors.setAcceleration(rightMotors.getMaxAcceleration());
	 *
	 *
	 * leftMotors.setTargetVelocity(1); rightMotors.setTargetVelocity(1);
	 *
	 *
	 * Thread.sleep(1000);
	 *
	 *
	 * leftMotors.setTargetVelocity(-1); rightMotors.setTargetVelocity(-1);
	 *
	 *
	 * Thread.sleep(1000);
	 *
	 *
	 * leftMotors.setTargetVelocity(0); rightMotors.setTargetVelocity(0);
	 */

}