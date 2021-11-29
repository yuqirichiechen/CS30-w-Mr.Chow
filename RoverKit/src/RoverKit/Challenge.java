package RoverKit;

//Add Phidgets Library
import com.phidget22.*;

public class Challenge {
	public static void main(String[] args) throws Exception {

		// Connect to wireless rover
		Net.addServer("", "192.168.100.1", 5661, "", 0);

		// Create
		DCMotor leftMotors = new DCMotor();
		DCMotor rightMotors = new DCMotor();
		DistanceSensor sonar = new DistanceSensor();

		// Address
		leftMotors.setChannel(0);
		rightMotors.setChannel(1);

		// Open
		leftMotors.open(1000);
		rightMotors.open(1000);
		sonar.open(1000);
		
//		leftMotors.setTargetVelocity(-0.5);
//		rightMotors.setTargetVelocity(-0.5);
//		Thread.sleep(5000);
//		
//		System.exit(0);

		int a = 1;
		int b = -1;
		while (true) {
			System.out.println(sonar.getDistance());
			if (sonar.getDistance() < 500) {
				// Object detected! Stop motors
				leftMotors.setTargetVelocity(1);
				rightMotors.setTargetVelocity(1);
				Thread.sleep(200);
				leftMotors.setTargetVelocity(-1);
				rightMotors.setTargetVelocity(1);
				Thread.sleep(570);

				int x, y;
				x = a;
				y = b;
				a = y;
				b = x;
				
				leftMotors.setTargetVelocity(0);
				rightMotors.setTargetVelocity(0);
				
			} else {
				
				// Move forward slowly (25% max speed)
				leftMotors.setTargetVelocity(-0.5);
				rightMotors.setTargetVelocity(-0.5);
				Thread.sleep(3000);
				leftMotors.setTargetVelocity(a);
				rightMotors.setTargetVelocity(b);
				Thread.sleep(570);
				leftMotors.setTargetVelocity(0);
				rightMotors.setTargetVelocity(0);
			}

			// Wait for 250milliseconds
			Thread.sleep(50);
		}
	}
}
