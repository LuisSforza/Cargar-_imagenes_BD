
package cargaimagenesbd;
import Configuracion.conexion;
import java.util.Scanner;

public class CargaImagenesBD {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("=========== Programa para ingresar una imagen a la base de datos ===========");
        conexion con = new conexion();
        int op;
        int id;
        String basura,name;
        String path;
        if(con.statusConexion()){
            System.out.println("=========== °Conexión establecida ===========");
            
            do{
                op = menu();
                
                if(op == 1){
                    System.out.println("=========== Ingresar datos de la imagen ===========");
                    
                    System.out.print("Ingresar el id de la imagen:");
                    id = entrada.nextInt();
                    basura = entrada.nextLine();
                    System.out.print("Ingresar el nombre de la imagen:");
                    name = entrada.nextLine();
                    
                    System.out.print("Ingresar la ruta de la imagen:");
                    path = entrada.nextLine();
                    
                    if(con.IngresarImg(id, name, path)){
                        System.out.println("La imagen se guardo correctamente");
                    }else{
                        System.out.println("Hubo algun error al guardar la imagen");
                    }
                }
            }while(op != 2);                    
            
        }else{
          System.out.println("=========== °Conexión no establecida ===========");  
        }
        System.out.println("=========== Finalizacion del programa ===========");
    }
    
    public static int menu(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("========Base de datos========");
        System.out.println("1.Ingresa Imagen");
        System.out.println("2.Salir");
        System.out.println("=======================");
        System.out.print("Opcion:");
        return (entrada.nextInt());
    }
    
}
