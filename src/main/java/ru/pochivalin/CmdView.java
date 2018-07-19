package ru.pochivalin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdView {

	public static final Logger LOG = LoggerFactory.getLogger(CmdView.class);

	public void start(Calculator calc) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"))) {
			String exit = "no";
			while (!exit.equals("yes")) {
				LOG.info("Enter number of operation: "
					+ "1:\"+\" 2:\"-\" 3:\"/\" 4:\"*\" : ");
				String operation = reader.readLine();
				if (!operation.isEmpty()) {
					boolean isValideOperation = calc.validateOperation(Integer.parseInt(operation));
					if (isValideOperation) {
						LOG.info("Enter first arg : ");
						String first = reader.readLine();
						boolean firstIsValide = calc.validateArgs(first);
						if (firstIsValide) {
							LOG.info("Enter second arg : ");
							String second = reader.readLine();
							boolean secondIsValide = calc.validateArgs(second);
							if (secondIsValide) {
								calc.calc(Integer.parseInt(operation),
										Integer.parseInt(first),
										Integer.parseInt(second));
								LOG.info("Result : " + calc.getResult());
								calc.cleanResult();
								LOG.info("Exit : yes/no ");
								exit = reader.readLine();
							}
						}
					}
				}
			}
		} catch (NullPointerException e) {
			LOG.info(e.getMessage());
		} catch (IOException e) {
			LOG.info(e.getMessage());
		}
	}
}
