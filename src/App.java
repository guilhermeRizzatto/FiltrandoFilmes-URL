import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, Filme> map = new LinkedHashMap<>();

        URL link = null;

        try {
            link = new URL(
                    "https://raw.githubusercontent.com/alura-cursos/introducao-a-data-science/master/aula6.2/movies.csv");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(link.openStream()))) {

            String line = br.readLine();
            line = br.readLine();
            while (line != null) {
                String fields[] = line.split(",");
                Integer id = Integer.parseInt(fields[0]);
                Filme filme = new Filme(titleMovie(fields), fields[fields.length - 1]);
                map.put(id, filme);
                line = br.readLine();
            }

            System.out.println();
            for (int i = 0; i <= map.size() / 100; i++) {
                int index = i * 200;
                System.out.println("Page : " + i);
                map.keySet().stream()
                        .skip(index)
                        .limit(200)
                        .forEach(key -> System.out.println(key + " | " + map.get(key)));
                System.out.println("Press ENTER for next page");
                sc.nextLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();

    }

    public static String titleMovie(String[] fields) {
        if (fields.length > 3) {
            String title = "";
            for (int i = 1; i < fields.length - 1; i++) {
                title += fields[i];
            }
            return title;
        }
        return fields[1];
    }
}
