/*   PRACTICA 3 AUTÓMATA FINITO DETERMINISTA (AFD)          
                    ALUMNOS:
            CUEVAS OLVERA IAN AXEL
            ORTEGA ESTRADA ISMAEL
*/
package practica3tc;
import java.util.Scanner;

/**
 *
 * @author axel_
 */
public class Menu {
    char opc = ' ';
    String menu[] = {"a) "
                   , "b) "
                   , "c) "
                   , "d) "
                   , "z) Salir"};
    Scanner scan = new Scanner(System.in);
    public Menu(){
        do{
            print(menu);
            opc = scan.nextLine().charAt(0);
            switch(opc){
                case 'a':
                    break;
                case 'b':
                    itemB();
                    break;
                case 'c':
                    itemC();
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
    
    public void itemB(){
        String chain = readChain();
        
        int zeros = 0, ones = 0;
        boolean flag = true;
        for(int i=0;i<chain.length();i++){
            if(chain.charAt(i)=='0'){
                zeros++;
                ones = 0;
            }
            else{
                ones++;
                if(ones>1)
                    flag=false;
            }
        }
        if(zeros%2==1)
            flag=false;
        
        System.out.println(flag ? "\nCadena aceptada" : "\nCadena no aceptada");
    }
    
    public void itemC(){
        String chain = readChain();
        
        int a=0, b=0, c=0;
        
        for(int i=0;i<chain.length();i++){
            
        }
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
