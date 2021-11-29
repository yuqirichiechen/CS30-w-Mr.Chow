package HumanClass;

public class human {

	private String name;

	private int age;

	private boolean healthy;

	public human() {

		name = "F/N L/N";

		age = 0;

		healthy = true;

	}

	public human(String name) {

		this.name = name;

		age = 0;

		healthy = true;

	}

	public human(int age, boolean healthy) {

		name = "F/N L/N";

		this.age = age;

		this.healthy = healthy;

	}

	public human(String name, int age, boolean healthy) {

		this.name = name;

		this.age = age;

		this.healthy = healthy;

	}

	public void print() {

		System.out.println(name);

		System.out.println(age);

		System.out.println(healthy);

	}

	public int add(int x, int y) {

		int result = x + y;

		return result;

	}

	public int add(String a, String b) {

		int x = 0;
		int y = 0;

		if (a == "one")
			x = 1;
		else if (a == "two")
			x = 2;
		else if (a == "three")
			x = 3;
		else if (a == "four")
			x = 4;
		else if (a == "five")
			x = 5;
		else if (a == "six")
			x = 6;
		else if (a == "seven")
			x = 7;
		else if (a == "eight")
			x = 8;
		else if (a == "nine")
			x = 9;
		else if (a == "zero")
			x = 0;
		else
			return -1;

		if (b == "one")
			y = 1;
		else if (b == "two")
			y = 2;
		else if (b == "three")
			y = 3;
		else if (b == "four")
			y = 4;
		else if (b == "five")
			y = 5;
		else if (b == "six")
			y = 6;
		else if (b == "seven")
			y = 7;
		else if (b == "eight")
			y = 8;
		else if (b == "nine")
			y = 9;
		else if (b == "zero")
			y = 0;
		else
			return -1;

		int result = y + x;

		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {

		if (age > 30 && Math.random() <= 0.2) {
			return age - 5;

		}
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isHealthy() {
		return healthy;
	}

	public void setHealthy(boolean healthy) {
		this.healthy = healthy;
	}
}
