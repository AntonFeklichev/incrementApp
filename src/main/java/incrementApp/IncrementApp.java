package incrementApp;

import java.util.Scanner;

public class IncrementApp {
    private Incrementor incrementor;
    private IncrementorSaver incrementorSaver = new IncrementorSaver();

    public IncrementApp() {
        this.incrementor = incrementorSaver.load();
    }

    public void run() {
        System.out.println("Счетчик загружен, значение '" + incrementor.getValue() + "'");
        System.out.println("Доступные команды: /inc, /reset, /stop");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine().trim();

            switch (command) {
                case "/inc":
                    incrementor.increment();
                    System.out.println("Счетчик увеличен, текущее значение: " + incrementor.getValue());
                    incrementorSaver.save(incrementor);
                    break;
                case "/reset":
                    incrementor.reset();
                    System.out.println("Счетчик сброшен, текущее значение: " + incrementor.getValue());
                    incrementorSaver.save(incrementor);
                    break;
                case "/stop":
                    incrementorSaver.save(incrementor);
                    System.out.println("Текущее значение счетчика: " + incrementor.getValue());
                    System.out.println("Завершаю работу");
                    return;
                default:
                    System.out.println("Неизвестная команда. Доступные команды: /inc, /reset, /stop");
                    break;
            }
        }
    }

    public static void main(String[] args) {

        IncrementApp incrementApp = new IncrementApp();
        incrementApp.run();

    }
}
