import java.io.*;
import java.util.Random;

public class FileModifier {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\kiber\\IdeaProjects\\untitled\\src\\notes.txt"; // кладем путь в переменную

        try { // открываем файл
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            //System.out.print("Исходная строка: " + line + ".\n"); // вывод строки на экран для проверки
            reader.close();

            while (true) { // меняем первую букву строки на рандомную [А,...,Z,a,...,z]
                char firstChar = line.charAt(0);
                Random r = new Random();
                int id_let = r.nextInt(52);
                char newFirstChar = (char) (((id_let < 26) ? 'A' : 'a') + id_let % 26);
                String modifiedLine;
                modifiedLine = newFirstChar + line.substring(1);

                //записываем изменненную строку в файл
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(modifiedLine);
                //System.out.print("Измененная строка: " + modifiedLine + ".\n"); // вывод строки на экран для проверки
                writer.close();

                Thread.sleep(15 * 60000); // ожидаем 15 минут
            }

        } catch(IOException | InterruptedException e) { // обработка исключения
            System.out.println("Файл не существует или его невозможно открыть.");
        }
    }
}