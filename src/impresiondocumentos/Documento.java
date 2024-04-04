package impresiondocumentos;

// @author camil
public class Documento {
    private String nombre;
    private int numPags;
//Constructorr
    public Documento(String dueño, int numPags) {
        this.nombre = dueño;
        this.numPags = numPags;
    }
//Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public int getNumPags() {
        return numPags;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}