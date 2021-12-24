package gestion_usuarios.utilidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author yerso
 */
public class Utilidades {
    public static String fechaActual() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");
        LocalDateTime now = LocalDateTime.now();
        return format.format(now);
    }
}
