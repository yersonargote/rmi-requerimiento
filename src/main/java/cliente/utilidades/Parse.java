package cliente.utilidades;

/**
 *
 * @author yerso
 */
public class Parse {
    public static int StringToInt(String str) {
        int number = -1;
        try {
            number = Integer.parseInt(str);
        }catch(NumberFormatException ex) {
        }
        return number;
    }
}
