package notaalumnos;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class NotaAlumnos {
    
    public static void main(String[] args) {
        
        Path ruta = Path.of("notas.txt");
        List<String> alumnosNotasMasAltas = new ArrayList();
        List<String> alumnosNotasMasBajas = new ArrayList();
        int numAlumnos = 0;
        double media = 0;
        
        try (BufferedReader reader = Files.newBufferedReader(ruta)){
            
            String linea;
            double notaMasAlta = 0;
            double notaMasBaja = 10;
            
            while((linea = reader.readLine()) != null) {
                
                Scanner sc = new Scanner(linea);
                sc.useDelimiter(" ");
                
                String alumno = sc.next();
                double nota = Double.parseDouble(sc.nextLine());
                
                if(nota > notaMasAlta) {
                    notaMasAlta = nota;
                    alumnosNotasMasAltas.clear();
                    alumnosNotasMasAltas.add(alumno);
                } else if (nota == notaMasAlta) {
                    alumnosNotasMasAltas.add(alumno);
                }
                
                if(nota < notaMasBaja) {
                    notaMasBaja = nota;
                    alumnosNotasMasBajas.clear();
                    alumnosNotasMasBajas.add(alumno);
                } else if (nota == notaMasBaja) {
                    alumnosNotasMasBajas.add(alumno);
                }
                
                media += nota;
                numAlumnos++;
            }
            
        } catch (IOException e) {
            System.out.println(e);
        }
        
        System.out.println("La media es: " + media / numAlumnos);
    }
    
}
