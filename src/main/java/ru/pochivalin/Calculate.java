package ru.pochivalin;

public class Calculate {
	public static void main(String[] args) {
		System.out.println("Calculate...");
		int first = Integer.parseInt(args[0]);
		int second = Integer.parseInt(args[1]);
		int summ = first + second;
		System.out.println("sum " + summ);
	}
}
