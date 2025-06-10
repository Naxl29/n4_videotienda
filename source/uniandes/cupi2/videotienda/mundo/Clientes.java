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
	 * 
	 */
	
	
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
		
	}
	
	
	public void cargarSaldo( int saldo )
	{
		
	}
	
	
	public void descargarSaldo( int saldo )
	{
		
	}
	
	
	public int darNumerAlquiladas( )
	{
		
	}
	
	
	public ArrayList darAlquiladas( )
	{
		
	}
	
	
	public Copia buscarPeliculaAlquilada( String pelicula, int codigo )
	{
		
	}
	
	
	public void devolverCopia( String pelicula, int codigo)
	{
		
	}
}
