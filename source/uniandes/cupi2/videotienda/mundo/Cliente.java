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
	 * crea un cliente de la videotienda
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
	
	public String darNombre( )
	{
		return nombre;
	}
	
	
	public String darCedula( )
	{
		return cedula;
	}
	
	
	public String darDireccion( )
	{
		return direccion;
	}
	
	
	public int darSaldo( )
	{
		return saldo;
	}
	
	
	public void alquilarCopia( Copia copia )
	{
		copiasAlquiladas.add( copia );
	}
	
	
	public void cargarSaldo( int saldo )
	{
		this.saldo += saldo;
	}
	
	
	public void descargarSaldo( int saldo )
	{
		this.saldo -= saldo;
	}
	
	
	public int darNumerAlquiladas( )
	{
		return copiasAlquiladas.size( );
	}
	
	
	public ArrayList<Copia> darAlquiladas( )
	{
		return copiasAlquiladas;
	}
	
	
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
