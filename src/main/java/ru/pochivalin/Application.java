package ru.pochivalin;

public class Application {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		CmdView view = new CmdView();
		view.start(calculator);
	}
}
