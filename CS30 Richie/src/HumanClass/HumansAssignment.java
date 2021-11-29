package HumanClass;

public class HumansAssignment {

	private static void test() {

		human a = new human("A", 20, true);

		a.print();

		human b = new human("B", 98, false);

		b.print();

	}

	public static void checkName(human x) {

		System.out.println(x.getName());

	}

	public static void birthday(human x) {

		int age = x.getAge();

		age += 1;

		x.setAge(age);

		System.out.println(x.getAge());
	}

	public static void main(String[] args) {

		human person = new human();

		System.out.println(person.getName());

		System.out.println(person.getAge());

		System.out.println(person.isHealthy());

		human Bruno = new human();

		System.out.println(Bruno.add(4, 5));

		human Steven = new human("Steven");

		System.out.println(Steven.getName());

		human Connie = new human(15, true);

		System.out.println(Connie.getAge());

		System.out.println(Connie.isHealthy());

		Steven.print();

//test();

//checkName(Steven);

		birthday(Connie);

		System.out.println(Connie.getAge());

		System.out.println(Connie.add("six", "six"));

	}

}