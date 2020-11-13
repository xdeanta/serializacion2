/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacion;

import java.io.*;

/**
 *
 * @author dam2a
 */
public class Serializacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ObjectOutputStream out;
        ObjectInputStream in;
        String[] descs = {"parafusos" , "cravos" , "tachas"};
        String[] cods = {"p1" , "p2" , "p3"};
        double[] precios = {3,4,5};
        Product[] prod = new Product[3];
        Product pnu=null;
        Object o;
        
        for(int i = 0 ; i<3 ;++i){
            prod[i]=new Product(cods[i],descs[i],precios[i]);
        }
        try{
            out=new ObjectOutputStream(new FileOutputStream("serial"));
            for(int i = 0 ; i < 3;i++){
                out.writeObject(prod[i]);
            }
            out.writeObject(pnu);
            out.close();
        }catch(IOException e){
            System.out.println("No se pudo abrir el archivo");
        }
        
       try{
           in = new ObjectInputStream(new FileInputStream("serial"));
           while((o=in.readObject())!=null){
               pnu=(Product)o;
               System.out.println(o);
           }
       }catch(IOException e2){
           System.out.println("Error al abrir el archivo");
       }catch(ClassNotFoundException e3){
           System.out.println("Clase no encontrada");
       }
            
    }
    
}
