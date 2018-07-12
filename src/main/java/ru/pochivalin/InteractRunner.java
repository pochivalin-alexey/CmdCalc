package ru.pochivalin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractRunner {
	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"))) {
			Calculator calc = new Calculator();
			String exit = "no";
			while (!exit.equals("yes")) {
				System.out.print("Enter number of operation: "
						+ "1:\"+\" 2:\"-\" 3:\"/\" 4:\"*\" : ");
				String operation = reader.readLine();
				if (!operation.isEmpty()) {
					boolean isValideOperation = calc.validateOperation(Integer.parseInt(operation));
					if (isValideOperation) {
						System.out.print("Enter first arg : ");
						String first = reader.readLine();
						boolean firstIsValide = calc.validateArgs(first);
						if (firstIsValide) {
							System.out.print("Enter second arg : ");
							String second = reader.readLine();
							boolean secondIsValide = calc.validateArgs(second);
							if (secondIsValide) {
								calc.calc(Integer.parseInt(operation),
										Integer.parseInt(first),
										Integer.parseInt(second));
								System.out.println("Result : " + calc.getResult());
								calc.cleanResult();
								System.out.println("Exit : yes/no ");
								exit = reader.readLine();
							}
						}
					}
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
