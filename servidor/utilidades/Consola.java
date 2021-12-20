package servidor.utilidades;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Consola {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String readLine() {
        String linea = "";
        boolean valido = false;
        do {
            try {
                linea = br.readLine();
                valido = true;
            } catch (Exception e) {
                System.out.println("Error intente nuevamente...");
                valido = false;
            }
        } while (!valido);
        return linea;
    }
}