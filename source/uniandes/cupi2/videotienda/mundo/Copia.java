package uniandes.cupi2.videotienda.mundo;

/**
 * This class represents a copy of a movie in the video store
 */
public class Copia {
    
    /**
     * Movie title this copy belongs to
     */
    private String tituloPelicula;
    
    /**
     * Unique identifier code for this copy
     */
    private int codigo;
    
    /**
     * Creates a new copy of a movie
     * @param laPelicula Movie title. laPelicula != null
     * @param elCodigo Unique identifier code. elCodigo > 0
     */
    public Copia(String laPelicula, int elCodigo) {
        tituloPelicula = laPelicula;
        codigo = elCodigo;
    }
    
    /**
     * Returns the copy's code
     * @return copy identifier code
     */
    public int darCodigo() {
        return codigo;
    }
    
    /**
     * Returns the movie title
     * @return movie title
     */
    public String darTituloPelicula() {
        return tituloPelicula;
    }

    /**
     * Checks if this copy is equal to another one
     * @param otra Other copy to compare with. otra != null
     * @return true if both copies have the same movie title and code, false otherwise
     */
    public boolean esIgualA(Copia otra) {
        return tituloPelicula.equals(otra.darTituloPelicula()) && 
               codigo == otra.darCodigo();
    }
}
