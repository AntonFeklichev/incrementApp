package incrementApp;

import java.io.*;

public class IncrementorSaver {

    private static final String FILE_NAME = "incrementor.dat";

    public void save(Incrementor incrementor) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(incrementor);
        } catch (IOException e) {
            System.out.println("Ошибка сохранения состояния счетчика: " + e.getMessage());
        }
    }

    public Incrementor load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (Incrementor) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new Incrementor();
        }
    }
}
