/*   PRACTICA 3 AUTÓMATA FINITO DETERMINISTA (AFD)          
                    ALUMNOS:
            CUEVAS OLVERA IAN AXEL
            ORTEGA ESTRADA ISMAEL
                 GRUPO: 2CM3
*/
package practica3tc;
import java.util.Scanner;

/**
 *
 * @author axel_
 */
public class Menu {
    char opc = ' ';
    String menu[] = {"a) AFD que Acepta un Número Real"
                   , "b) AFD que reconoce cadenas con un número par de 0 sin 1 sucesivos"
                   , "c) AFD que acepta cadenas de longitud 3 con contenga 2 o más simbolos consecutivos iguales"
                   , "d) AFD Máquinas Expendedoras"
                   , "z) Salir\n"};
    Scanner scan = new Scanner(System.in);
    public Menu(){
        do{
            print(menu);
            opc = scan.nextLine().charAt(0);
            String chain = "";
            switch(opc){
                case 'a':
                    
                    break;
                case 'b':
                    chain = readChain();
                    incisoB b = new incisoB(chain);
                    break;
                case 'c':
                    chain = readChain();
                    incisoC c = new incisoC(chain);
                    break;
                case 'd':
                    
                    break;    
                case 'z':
                    
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }while(opc!='z');
    }
    
    public String readChain(){
        System.out.print("Inserte la cadena: ");
        return scan.nextLine();
    }
    
    public void print(String a[]){
        for (String a1 : a)
            System.out.print("\n" + a1);
    }
}
