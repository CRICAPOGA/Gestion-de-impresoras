package impresiondocumentos;

import java.util.LinkedList;
import javax.swing.JOptionPane;

public class ImpresionDocumentos {
//    Variables
    private static LinkedList<Documento> documentos = new LinkedList<Documento>();
    private static Documento impresoras[]=new Documento[2];
    private static int a=0;
    private static int des;
    private static String s="";
    private static int con=0;
    
//    Metodo principal
    public static void main(String[] args) {
        try{
            do{
                des=Integer.parseInt(JOptionPane.showInputDialog("Que desea hacer?\n"
                        + "1. Imprimir documento\n"
                        + "2. Eliminar proximo documento en Cola\n"
                        + "3. Agregar documento\n"
                        + "4. Documentos en cola\n"
                        + "5. Salir del programa"));
                switch (des){
                    case 1:
                        imprimirDocumento();
                        break;
                    case 2:
                        eliminarDocumento();
                        break;
                    case 3:
                        agregarDocumento();
                        break;
                    case 4:
                        documentosCola();
                        break;
                    default:
                        if (des!=5){
                            JOptionPane.showMessageDialog(null,"Opción no valida");
                        }
                }
            }while (des!=5);    
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error: "+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
//    Metodos
    public static void agregarDocumento() {
        String n=JOptionPane.showInputDialog("Nombre del documento: ");
        int c=Integer.parseInt(JOptionPane.showInputDialog("Cantidad de paginas: "));
        documentos.add(new Documento(n, a));
    }
    
    public static void eliminarDocumento() {
        if (documentos.isEmpty()){
            JOptionPane.showMessageDialog(null,"No hay documentos en cola");
        }else{
            documentos.pop();
            JOptionPane.showMessageDialog(null,"Documento eliminado");
        }
    }
    
    public static void documentosCola() {
        if (documentos.isEmpty()){
            JOptionPane.showMessageDialog(null,"No hay documentos en cola");
        }else{
            for (Documento d: documentos){
                con++;
                s+=con+". "+d.getNombre()+"\n";
            }
            for (Documento d: impresoras){
                if (d != null){
                    s+="["+d.getNombre()+"] ";                
                }
            }
            JOptionPane.showMessageDialog(null, s);
        }
    }
    
    public static void imprimirDocumento() {
        if (documentos.isEmpty()){
            JOptionPane.showMessageDialog(null,"No hay documentos en cola");
        }else{
            if (a==0){
                impresoras[a]=documentos.peek();
                JOptionPane.showMessageDialog(null,impresoras[a].getNombre()+"\nImprimiendo a la impresora N° 1");
                documentos.pop();
                a++;
            }else{
                impresoras[a]=documentos.peek();
                JOptionPane.showMessageDialog(null,impresoras[a].getNombre()+"\nEnviado a la impresora N° 2");
                documentos.pop();
                a--;
            }
        }
    }
}
