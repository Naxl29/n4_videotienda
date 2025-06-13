/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: VideoTienda.java,v 1.1 2005/12/16 15:13:33 k-marcos Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_videotienda
 * Autor: Katalina Marcos - Diciembre 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.videotienda.mundo;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.List;

/**
 * Esta clase representa a la VideoTienda
 */
public class VideoTienda
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Tarifa de alquiler diario
     */
    private int tarifaDiaria;

    /**
     * Clientes
     */

    private List<Cliente> clientes;
    /**
     * Catálogo de pel�culas
     */
    
    private List<Pelicula> peliculas;
    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Crea una videotienda sin películas registradas.
     * @param unaTarifa Tarifa diaria de alquiler. tarifa > 0.
     */
    public VideoTienda( int unaTarifa )
    {
    	tarifaDiaria = unaTarifa;
    	clientes = new ArrayList<>();
    	peliculas = new ArrayList<>();

    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Carga en memoria los datos del archivo de películas. <br>
     * <b>post: </b> Se almacenan los datos de las películas del archivo en el catálogo eliminando las películas anteriores. <br>
     * @param archivo Nombre del archivo que contiene la información de las películas.
     * @throws Exception si hay datos inválidos en el archivo o no tiene el formato adecuado.
     */
    public void cargarPeliculas( String archivo ) throws Exception
    {
        String titulo, dato;
        int cantidadpeliculas, copias;
        Pelicula pel;

        //Limpia los datos iniciales de películas
        peliculas.clear( );

        //Obtiene los datos
        try
        {
            Properties datos = new Properties( );
            FileInputStream input = new FileInputStream( archivo );
            datos.load( input );

            //Obtiene el número de películas
            cantidadpeliculas = Integer.parseInt( datos.getProperty( "total.peliculas" ) );

            for( int i = 1; i <= cantidadpeliculas; i++ )
            {
                dato = "pelicula" + i + ".nombre";
                //Carga una película
                titulo = datos.getProperty( dato );
                if( titulo == null )
                {
                    throw new Exception( "Falta definir la propiedad " + dato );
                }

                copias = Integer.parseInt( datos.getProperty( "pelicula" + i + ".copias" ) );
                pel = new Pelicula( titulo );
                for( int j = 1; j <= copias; j++ )
                {
                    pel.agregarCopia( );
                }

                peliculas.add( pel );
            }
        }
        catch( Exception e )
        {
            throw new Exception( "Error al cargar los datos almacenados de pel�culas" );
        }
    }

    /**
     * Afilia un cliente a la videotienda. <br>
     * <b>post: </b> Se crea un nuevo cliente y se agrega a la lista de clientes de la videotienda.
     * @param cedula Cédula del cliente a afiliar. cedula != null.
     * @param nombre Nombre del cliente a afiliar. nombre != null.
     * @param direccion Dirección del cliente a afiliar. direccion != null.
     * @throws Exception Si la cédula del cliente ya está registrada en la videotienda.
     */
    public void afiliarCliente( String cedula, String nombre, String direccion ) throws Exception
    {
        if( buscarCliente( cedula ) != null )
        {
            throw new Exception( "Ya existe un cliente con cédula: " + cedula );
        }
        
        Cliente nuevocliente = new Cliente( nombre, cedula, direccion );
        clientes.add( nuevocliente );
    }
    
    /**
     * Busca el cliente dada la cédula.
     * @param cedula Cédula del cliente. cedula != null.
     * @return el cliente correspondiente a la cédula, o null si no hay un cliente con la cédula dada.
     */
    public Cliente buscarCliente( String cedula )
    {
    	if (cedula != null && clientes != null ) 
    	{
    		for (Cliente cliente : clientes) 
    		{
    			if ( cedula.equalsIgnoreCase(cliente.darCedula())) 
    			{
    				return cliente;
    			}
    		}
    	}
		return null;
    	
    	
    }



    /**
     * Adiciona el monto dado al saldo disponible del cliente. <br>
     * <b>post: </b> el saldo del cliente identificado con la cédula se incrementó con el monto dado. <br>
     * @param cedula Cédula del cliente. cedula != null.
     * @param monto Cantidad de dinero a adicionar en la cuenta. monto > 0.
     * @throws Exception Si el cliente no existe.
     * @throws Exception Si la recarga de saldo es menor que 0.
     */
    public void cargarSaldoCliente( String cedula, int monto ) throws Exception
    {
    	if( cedula == null)
    	{
    		throw new Exception( "La cédula no puede ser null" );
    	}
    	if( monto <= 0)
    	{
    		throw new Exception( "El monto no puede ser menor a 0" );
    	}
    	
    	Cliente cliente = buscarCliente( cedula );
    	
    	if( cliente == null )
    	{
    		throw new Exception( "El cliente no existe, cédula ingresada: " + cedula );
    	}
    	
    	cliente.cargarSaldo( monto );
    }
    

    /**
     * Alquila una película a un cliente. <br>
     * <b>post: </b> si hay copias disponibles, alquila una copia de la película, adicionándola a la lista de alquiladas del cliente y de la videotienda.
     * @param titulo Título de la película. titulo != null.
     * @param cedula Cédula del cliente. cedula != null.
     * @return número de copia alquilada.
     * @throws Exception Si la película no existe.
     * @throws Exception Si el cliente no existe.
     * @throws Exception Si no hay copias disponibles.
     * @throws Exception Si el saldo del cliente no es suficiente para el alquiler.
     */
    public int alquilarPelicula( String titulo, String cedula ) throws Exception {
        // Buscar al cliente por cédula
        Cliente cliente = buscarCliente( cedula );
        if ( cliente == null ) 
        {
            throw new Exception("No existe un cliente con la cédula: " + cedula );
        }

        // Buscar la película por título
        Pelicula pelicula = buscarPeliculaPorTitulo( titulo );
        if ( pelicula == null ) 
        {
            throw new Exception( "La película no existe" );
        }

        // Intentar alquilar una copia de la película
        Copia copiaAlquilada = pelicula.alquilarCopia( );
        if ( copiaAlquilada == null ) 
        {
            throw new Exception( "No hay copias disponibles para alquilar" );
        }

        // Registrar el alquiler en el cliente
        cliente.alquilarCopia( copiaAlquilada );
        cliente.descargarSaldo( tarifaDiaria );
 
        // Retornar el código de la copia alquilada
        return copiaAlquilada.darCodigo( );
    }

    /**
     * Devuelve a la videotienda una copia alquilada por el cliente identificado con la cédula dada. <br>
     * <b>post: </b> Si la copia está alquilada por el cliente, la copia se deja disponible, y el cliente ya no la tiene entre sus prestadas.
     * @param titulo Título de la película. titulo != null.
     * @param numeroCopia Número de copia a devolver.
     * @param cedula Cédula del cliente. cedula != null.
     * @throws Exception Si el cliente no existe.
     * @throws Exception Si el cliente no tiene la copia alquilada.
     */
    public void devolverCopia( String titulo, int numeroCopia, String cedula ) throws Exception
    {
        Cliente cliente = buscarCliente( cedula );
        if( cliente == null )
        {
            throw new Exception( "El cliente con cédula " + cedula + " no existe." );
        }

        Copia copia = cliente.devolverAlquiler( numeroCopia );
        if( copia == null )
        {
            throw new Exception( "El cliente no tiene alquilada una copia con número: " + numeroCopia );
        }

        Pelicula pelicula = buscarPeliculaPorTitulo( titulo );
        if( pelicula != null )
        {
            pelicula.devolverCopia( copia.darCodigo( ) );
        }
    }
    
    /**
     * Agrega una nueva copia a una película existente.
     * @param titulo Título de la película a la que se le agregará una copia. titulo != null.
     * @throws Exception Si no se encuentra una película con el título dado.
     */
    public void agregarCopiaPelicula( String titulo ) throws Exception 
    {
        Pelicula pelicula = buscarPeliculaPorTitulo( titulo );
        if ( pelicula == null ) 
        {
            throw new Exception( "No se encontró una película con el título: " + titulo );
        }
        pelicula.agregarCopia( );
    }

    
    /**
     * Modifica la tarifa diaria de alquiler.
     * @param nuevaTarifa Nueva tarifa que se desea asignar. nuevaTarifa > 0.
     * @throws Exception Si la tarifa es menor o igual a cero.
     */
    public void modificarTarifa(int nuevaTarifa) throws Exception {
        if ( nuevaTarifa <= 0 ) 
        {
            throw new Exception( "La tarifa debe ser mayor que cero." );
        }
        tarifaDiaria = nuevaTarifa;
    }

    /**
     * Busca una pel�cula en el catálogo por su título.
     * @param titulo Título de la película. titulo != null.
     * @return Película con el título dado, o null si no existe.
     */
    public Pelicula buscarPeliculaPorTitulo( String titulo )
    {
        for( Pelicula pelicula : peliculas )
        {
            if( pelicula.darTitulo( ).equalsIgnoreCase( titulo ) )
            {
                return pelicula;
            }
        }
        return null;
    }



    /**
     * Retorna la lista de clientes de la videotienda.
     * @return Lista de clientes registrados 
     */
    
    public List<Cliente> darClientes(  )
    {
    	return clientes;
    }
    /**
     * Retorna el catálogo de peleculas de la videotienda
     * @return lista de peleculas existentes. lista != null.
     */
    
    public List<Pelicula> darCatalogo(  )
    {
    	return peliculas;
    }
    //-----------------------------------------------------------------
    // Puntos de Extensión
    //-----------------------------------------------------------------

    /**
     * Método para la extensión 1
     * @return Respuesta de la extensión 1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión 2
     * @return Respuesta de la extensión 2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}
