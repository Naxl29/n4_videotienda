package uniandes.cupi2.videotienda.mundo;

/**
 * Esta clase representa una copia física de una película en la videotienda.
 */
public class Copia {
    
	/**
     * Título de la película a la que pertenece esta copia.
     */
    private String tituloPelicula;
    
    /**
     * Código único que identifica esta copia.
     */
    private int codigo;
    
    
    /**
     * Crea una nueva copia de una película con su título y código.
     * @param laPelicula Título de la película a la que pertenece la copia. laPelicula != null.
     * @param elCodigo Código único de la copia. elCodigo > 0.
     */
    public Copia(String laPelicula, int elCodigo) {
        tituloPelicula = laPelicula;
        codigo = elCodigo;
    }
    
    /**
     * Retorna el código único de la copia.
     * @return Código de la copia.
     */
    public int darCodigo() {
        return codigo;
    }
    
    /**
     * Retorna el título de la película a la que pertenece esta copia.
     * @return Título de la película.
     */
    public String darTituloPelicula() {
        return tituloPelicula;
    }

    /**
     * Indica si esta copia es igual a otra copia.
     * @param otra Otra copia con la que se va a comparar. otra != null.
     * @return true si ambas copias tienen el mismo título de película y el mismo código; false en caso contrario.
     */
    public boolean esIgualA(Copia otra) {
        return tituloPelicula.equals(otra.darTituloPelicula()) && 
               codigo == otra.darCodigo();
    }
}
