package uniandes.cupi2.videotienda.mundo;

import java.util.ArrayList;
	
	/**
	 * esta es la clase que representa a los clientes
	 */
public class Cliente
{
	
	//-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

	/**
	 *  Numero de cedula del cliente
	 */
	private String cedula;
	
	/**
	 * Nombre del cliente
	 */
	private String nombre;
	
	/**
	 * Direccion del cliente
	 */
	private String direccion;
	
	/**
	 * Saldo del cliente
	 */
	private int saldo;
	
	/**
	 *  copias alquiladas por el cliente
	 */
	private ArrayList<Copia> copiasAlquiladas;
	
	//-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------
	
	/**
     * Crea un nuevo cliente de  videotienda.
     * @param pNombre Nombre del cliente. pNombre != null.
     * @param pCedula Cédula del cliente. pCedula != null.
     * @param pDireccion Dirección del cliente. pDireccion != null.
     */
	public Cliente( String pNombre, String pCedula, String pDireccion )
	{
		// inicializa los atributos del cliente
		nombre = pNombre;
		cedula = pCedula;
		direccion = pDireccion;
		saldo = 0;
		copiasAlquiladas = new ArrayList<>();
	}
	
	/**
     * Retorna el nombre del cliente.
     * @return Nombre del cliente.
     */
	public String darNombre( )
	{
		return nombre;
	}
	
	/**
     * Retorna la cédula del cliente.
     * @return Cédula del cliente.
     */
	public String darCedula( )
	{
		return cedula;
	}
	
	/**
     * Retorna la dirección del cliente.
     * @return Dirección del cliente.
     */
	public String darDireccion( )
	{
		return direccion;
	}
	
	/**
     * Retorna el saldo disponible del cliente.
     * @return Saldo del cliente.
     */
	public int darSaldo( )
	{
		return saldo;
	}
	
	/**
     * Agrega una copia a la lista de copias alquiladas por el cliente.
     * @param copia Copia que se desea alquilar. copia != null.
     */
	public void alquilarCopia( Copia copia )
	{
		copiasAlquiladas.add( copia );
	}
	
	/**
     * Carga un valor al saldo del cliente.
     * @param saldo Cantidad a cargar al saldo.
     */
	public void cargarSaldo( int saldo )
	{
		this.saldo += saldo;
	}
	
	/**
     * Descarga un valor del saldo del cliente.
     * @param saldo Cantidad a restar del saldo.
     */
	public void descargarSaldo( int saldo )
	{
		this.saldo -= saldo;
	}
	
	/**
     * Retorna la cantidad de copias alquiladas 
     * @return Número de copias alquiladas.
     */
	public int darNumerAlquiladas( )
	{
		return copiasAlquiladas.size( );
	}
	
	/**
     * Retorna la lista de copias alquiladas 
     * @return Lista de copias alquiladas.
     */
	public ArrayList<Copia> darAlquiladas( )
	{
		return copiasAlquiladas;
	}
	
	/**
     * Busca una copia de una película alquilada por título y código.
     * @param tituloPelicula Título de la película a buscar. tituloPelicula != null.
     * @param codigo Código de la copia.
     * @return Copia encontrada o null si no la tiene alquilada.
     */
	public Copia buscarPeliculaAlquilada( String tituloPelicula, int codigo )
	{
        for ( Copia copia : copiasAlquiladas ) 
        {
            if ( copia.darCodigo( ) == codigo && copia.darTituloPelicula( ).equalsIgnoreCase( tituloPelicula ) ) 
            {
                return copia;
            }
        }
        return null;
    }
	
	/**
     * Devuelve una copia alquilada por su código.
     * La copia se elimina de la lista de copias alquiladas.
     * @param codigoCopia Código de la copia a devolver.
     * @return Copia devuelta o null si no se encuentra.
     */
	public Copia devolverAlquiler( int codigoCopia ) 
	{
        for ( int i = 0; i < copiasAlquiladas.size( ); i++ ) 
        {
            Copia c = copiasAlquiladas.get( i );
            if ( c.darCodigo( ) == codigoCopia ) 
            {
                copiasAlquiladas.remove( i );
                return c;
            }
        }
        return null;
    }
}
