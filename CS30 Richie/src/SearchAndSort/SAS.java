package SearchAndSort;

import java.util.Scanner;

public class SAS {

	public static void poprand(int[] number) {
		for (int x = 0; x < number.length; x++) {
			number[x] = (int) (Math.random() * 100 + 1);
		}
	}

	public static void popseq(int[] number) {
		for (int x = 0; x < number.length; x++) {
			number[x] = x + 1;
		}
	}

	public static void display(int[] number) {
		System.out.println("");
		for (int x = 0; x < number.length; x++) {
			if (number[x] < 10)
				System.out.print(number[x] + "   ");
			else if (number[x] == 100)
				System.out.print(number[x] + " ");
			else if (number[x] > 9)
				System.out.print(number[x] + "  ");

			if ((x + 1) % 10 == 0)
				System.out.println();
		}
		System.out.println("");
	}

	public static void shuffle(int[] number) {
		for (int x = 0; x < number.length; x++) {
			int index1 = (int) (Math.random() * number.length);
			int temp = number[index1];
			number[index1] = number[x];
			number[x] = temp;
		}
	}

	public static boolean ascending(int[] number) {
		int index = -1;
		do {
			index++;
		} while (number[index] <= number[index + 1] && index < number.length - 2);
		if (index < number.length - 2)
			return false;
		else
			return true;
	}

	public static int linear(int[] number, int target) {
		for (int x = 0; x < number.length; x++) {
			if (number[x] == target) {
				return x;
			}
		}
		return -1;
	}

	public static void binary(int[] number, int target) {
		boolean found = false;
		int lowerBund = 0;
		int higherBund = number.length - 1;
		int center = 0;
		while (found == false)

		{
			center = (higherBund + lowerBund) / 2;
			if (target == number[center]) {
				System.out.println("The The index of the number you want to find is " + center);
				System.out.println();
				found = true;
			}

			else if (target < number[center]) {
				higherBund = center;
			}

			else if (target > number[center]) {
				lowerBund = center;
			}

		}

	}

	public static void bubble(int[] number) {
		int endingIndex = number.length - 1;
		while (endingIndex > 0) {
			for (int x = 0; x < endingIndex; x++) {
				if (number[x] > number[x + 1]) {
					int temp = number[x];
					number[x] = number[x + 1];
					number[x + 1] = temp;
				}
			}
			endingIndex--;
		}
	}

	public static void selection(int[] number) {

		for (int x = 0; x < number.length - 1; x++) {
			int min = number[x];
			int minIndex = x;
			for (int y = x + 1; y < number.length; y++) {
				if (number[y] < min) {
					min = number[y];
					minIndex = y;
				}

			}

			if (minIndex != x) {
				number[minIndex] = number[x];
				number[x] = min;
			}

		}

	}

	public static void insertion(int[] number) {
		for (int x = 1; x < number.length; x++) {
			int temp = number[x];
			int leftIndex = x - 1;
			while (leftIndex >= 0 && temp < number[leftIndex]) {
				number[leftIndex + 1] = number[leftIndex];
				leftIndex--;
			}
			number[leftIndex + 1] = temp;
		}
	}

	public static void merge(int[] number, int left, int mid, int right) {
		int[] temp = new int[number.length];
		int a = left, b = mid + 1, k = left;

		while (a <= mid && b <= right) {
			if (number[a] <= number[b])
				temp[k++] = number[a++];

			else
				temp[k++] = number[b++];

		}

		while (a <= mid)
			temp[k++] = number[a++];

		while (b <= right)
			temp[k++] = number[b++];

		for (int i = left; i <= right; i++)
			number[i] = temp[i];

	}

	public static void mergeSort(int[] number, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(number, start, mid);
			mergeSort(number, mid + 1, end);
			merge(number, start, mid, end);
		}
	}

	public static void radix(int[] number) {

		for (int i = 0; i < 3; i++) {

			for (int x = 1; x < number.length; x++) {
				int temp = number[x];
				int leftIndex = x - 1;
				while (leftIndex >= 0 && getDigit(temp, i) < getDigit(number[leftIndex], i)) {
					number[leftIndex + 1] = number[leftIndex];
					leftIndex--;
				}
				number[leftIndex + 1] = temp;
			}

		}
	}

	public static int getDigit(int number, int digit) {
		int value = 0;

		if (digit == 0)
			value = number % 10;

		else if (digit == 1)
			value = number / 10 % 10;

		else if (digit == 2)
			value = number / 100;

		return value;
	}

	public static void quickSort(int[] number, int begin, int end) {
		int lm = begin;
		int rm = end;

		while (lm != rm) {
			while (number[rm] > number[lm] && rm > lm)
				rm--;

			int temp1 = number[rm];
			number[rm] = number[lm];
			number[lm] = temp1;

			while (number[lm] < number[rm] && lm < rm)
				lm++;

			int temp2 = number[rm];
			number[rm] = number[lm];
			number[lm] = temp2;

		}

		if (lm - begin > 1)
			quickSort(number, begin, lm - 1);
		if (end - lm > 1)
			quickSort(number, lm + 1, end);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] number = new int[100];
		int choice = 0;
		Scanner input = new Scanner(System.in);

		do {
			System.out.println("0. Exit the program.");
			System.out.println("1. Populate the array randomly.");
			System.out.println("2. Populate the array sequentially from 1 to 100.");
			System.out.println("3. Display the Array.");
			System.out.println("4. Shuffle the Array.");
			System.out.println("5. Test if the array is ascending");
			System.out.println("6. Linear search for a number");
			System.out.println("7. Binary search for a number");
			System.out.println("8. Sorts the list with bubble sort");
			System.out.println("9. Sorts the list with selection sort");
			System.out.println("10. Sorts the list with insertion sort");
			System.out.println("11. Sorts the list with quick sort");
			System.out.println("12. Sorts the list with radix sort");
			System.out.println("13. Sort the list with merge sort");

			System.out.println("Please make a choice: ");
			choice = input.nextInt();

			if (choice == 1)
				poprand(number);
			else if (choice == 2)
				popseq(number);
			else if (choice == 3)
				display(number);
			else if (choice == 4)
				shuffle(number);
			else if (choice == 5)
				System.out.println(ascending(number));
			else if (choice == 6) {
				System.out.println("Please choose your number: ");
				System.out.println(linear(number, input.nextInt()));
			} else if (choice == 7) {
				if (ascending(number) == true) {
					int success = 1;
					while (success == 1) {

						System.out.println("Please choose your number: ");
						int target = input.nextInt();
						if (target > 100 || target < 0) {
							System.out.println("Number is out of bounce!");
							System.out.println("Please try again!");
							System.out.println(" ");
						} else {
							binary(number, target);
							success = 0;
						}
					}
				}

				else if (ascending(number) == false) {
					System.out.println("The list is not sorted");
				}
			} else if (choice == 8)
				bubble(number);
			else if (choice == 9)
				selection(number);
			else if (choice == 10)
				insertion(number);
			else if (choice == 11)
				quickSort(number, 0, number.length - 1);
			else if (choice == 12)
				radix(number);
			else if (choice == 13)
				mergeSort(number, 0, number.length - 1);
		} while (choice != 0);

	}

}