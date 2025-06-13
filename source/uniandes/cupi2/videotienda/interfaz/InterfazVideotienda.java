/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: InterfazVideotienda.java,v 1.1 2005/12/16 15:13:33 k-marcos Exp $ 
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_videotienda
 * Autor: Katalina Marcos - Diciembre 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.videotienda.interfaz;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import uniandes.cupi2.videotienda.mundo.Cliente;
import uniandes.cupi2.videotienda.mundo.Pelicula;
import uniandes.cupi2.videotienda.mundo.VideoTienda;

/**
 * Ventana principal de la aplicaci�n de la videotienda
 */
public class InterfazVideotienda extends JFrame
{
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    /**
     * Tarifa inicial de la videotienda
     */
    private static final int TARIFA_INICIAL = 5000;

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Videotienda
     */
    private VideoTienda videotienda;

    /**
     * Panel para el manejo de los clientes
     */
    private PanelClientes panelClientes;

    /**
     * Panel para el manejo de las pel�culas
     */
    private PanelPeliculas panelPeliculas;

    /**
     * Panel para el manejo de la tarifa
     */
    private PanelTarifa panelTarifa;

    /**
     * Panel para el manejo de las extensiones
     */
    private PanelOpciones panelOpciones;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Crea la interfaz para una videotienda <br>
     * <b>Post: </b> Se crea la nueva interfaz con los paneles en los tabs correspondientes
     */
    public InterfazVideotienda( )
    {
        setLayout( new BorderLayout( ) );

        panelTarifa = new PanelTarifa( this );
        panelTarifa.asignarTarifa( TARIFA_INICIAL );
        add( panelTarifa, BorderLayout.NORTH );
        panelPeliculas = new PanelPeliculas( this );
        panelClientes = new PanelClientes( this );
        JPanel panelMedio = new JPanel( new BorderLayout( ) );
        panelMedio.add( panelPeliculas, BorderLayout.CENTER );
        panelMedio.add( panelClientes, BorderLayout.SOUTH );
        add( panelMedio, BorderLayout.CENTER );
        panelOpciones = new PanelOpciones( this );
        add( panelOpciones, BorderLayout.SOUTH );

        //Inicializa la videotienda con valor diario por defecto
        videotienda = new VideoTienda( TARIFA_INICIAL );
        String archivo = "./data/peliculas.txt";
        try
        {
            videotienda.cargarPeliculas( archivo );
            panelPeliculas.actualizarPeliculas( new ArrayList<Pelicula> ( videotienda.darCatalogo( ) ) );
        }
        catch( Exception e )
        {
<<<<<<< HEAD
            JOptionPane.showMessageDialog( this, "No se pudo cargar la información de las pel�culas del archivo " + archivo, "Videotienda UniAndes", JOptionPane.INFORMATION_MESSAGE );
=======
            JOptionPane.showMessageDialog( this, "No se pudo cargar la informaci�n de las pel�culas del archivo " + archivo, "Videotienda UniAndes", JOptionPane.INFORMATION_MESSAGE );
>>>>>>> feature/interfaz
        }

        pack( );
        setTitle( "Videotienda UniAndes" );
        setResizable( true );
        centrarVentana( this );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    }
    //-----------------------------------------------------------------
<<<<<<< HEAD
    // Métodos
=======
    // M�todos
>>>>>>> feature/interfaz
    //-----------------------------------------------------------------

    /**
     * Cambia la tarifa de alquiler de la videotienda
     * @param tarifa Nueva tarifa.
     */
    public void cambiarTarifa( int tarifa )
    {
        try
        {
            videotienda.modificarTarifa( tarifa );
<<<<<<< HEAD
            JOptionPane.showMessageDialog( this, "La tarifa fue actualizada con éxito", "Cambio de Tarifa", JOptionPane.INFORMATION_MESSAGE );
=======
            JOptionPane.showMessageDialog( this, "La tarifa fue actualizada con �xito", "Cambio de Tarifa", JOptionPane.INFORMATION_MESSAGE );
>>>>>>> feature/interfaz
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Cambio de Tarifa", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
<<<<<<< HEAD
     * Retorna el catálogo de películas
     * @return catálogo de películas de la videotienda
=======
     * Retorna el cat�logo de pel�culas
     * @return cat�logo de pel�culas de la videotienda
>>>>>>> feature/interfaz
     */
    public ArrayList<Pelicula> darCatalogo() {
        return new ArrayList<>(videotienda.darCatalogo( ) );
    }

    /**
<<<<<<< HEAD
     * Busca y muestra la información de la película.
     * @param titulo Título de la película. titulo != null.
=======
     * Busca y muestra la informaci�n de la pel�cula.
     * @param titulo T�tulo de la pel�cula. titulo != null.
>>>>>>> feature/interfaz
     */
    public void mostrarPelicula( String titulo )
    {
        Pelicula p = videotienda.buscarPeliculaPorTitulo( titulo );
        if( p == null )
<<<<<<< HEAD
        {
            JOptionPane.showMessageDialog( this, "La película no existe", "Ver Información Película", JOptionPane.ERROR_MESSAGE );
        return;
        }
=======
            JOptionPane.showMessageDialog( this, "La pel�cula no existe", "Ver Informaci�n Pel�cula", JOptionPane.ERROR_MESSAGE );
>>>>>>> feature/interfaz
        DialogoPelicula dialogo = new DialogoPelicula( p );
        centrarVentana( dialogo );
        dialogo.setVisible( true );
    }

    /**
<<<<<<< HEAD
     * Agrega una copia a la película del título dado
     * @param titulo Título de la película. titulo != null.
=======
     * Agrega una copia a la pel�cula del t�tulo dado
     * @param titulo T�tulo de la pel�cula. titulo != null.
>>>>>>> feature/interfaz
     */
    public void agregarCopia( String titulo )
    {
        try
        {
            videotienda.agregarCopiaPelicula( titulo );
<<<<<<< HEAD
            Pelicula p = videotienda.buscarPeliculaPorTitulo( titulo );
            JOptionPane.showMessageDialog( this, "La película \"" + titulo + "\" tiene " + p.darTotalCopias( ) + " copias", "Agregar Copia", JOptionPane.INFORMATION_MESSAGE );
=======
            Pelicula p = videotienda.buscarPelicula( titulo );
            JOptionPane.showMessageDialog( this, "La pel�cula \"" + titulo + "\" tiene " + p.darTotalCopias( ) + " copias", "Agregar Copia", JOptionPane.INFORMATION_MESSAGE );
>>>>>>> feature/interfaz
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Agregar Copia", JOptionPane.ERROR_MESSAGE );
        }

    }

    /**
<<<<<<< HEAD
     * Busca y muestra la información de un cliente.
     * @param cedula Cédula del cliente a mostrar. cedula != null.
=======
     * Busca y muestra la informaci�n de un cliente.
     * @param cedula C�dula del cliente a mostrar. cedula != null.
>>>>>>> feature/interfaz
     */
    public void mostrarCliente( String cedula )
    {
        Cliente c = videotienda.buscarCliente( cedula );
        if( c == null )
        {
<<<<<<< HEAD
            JOptionPane.showMessageDialog( this, "El cliente no está registrado", "Ver Informació	n Cliente", JOptionPane.ERROR_MESSAGE );
=======
            JOptionPane.showMessageDialog( this, "El cliente no est� registrado", "Ver Informaci�n Cliente", JOptionPane.ERROR_MESSAGE );
>>>>>>> feature/interfaz
            return;
        }
        DialogoConsultaCliente dialogo = new DialogoConsultaCliente( c, this );
        centrarVentana( dialogo );
        dialogo.setVisible( true );
    }

    /**
     * Inicia el proceso de registro de un cliente
     */
    public void afiliarCliente( )
    {
        DialogoRegistroCliente dialogo = new DialogoRegistroCliente( this );
        centrarVentana( dialogo );
        dialogo.setVisible( true );
    }

    /**
     * Afilia un nuevo cliente a la videotienda.
     * @param nombre Nombre del cliente. nombre != null.
<<<<<<< HEAD
     * @param cedula Cédula del cliente. cedula != null.
     * @param direccion Dirección del cliente. direccion != null.
=======
     * @param cedula C�dula del cliente. cedula != null.
     * @param direccion Direcci�n del cliente. direccion != null.
>>>>>>> feature/interfaz
     * @param saldo Saldo inicial del cliente. saldo >0.
     */
    public void afiliarCliente( String nombre, String cedula, String direccion, int saldo )
    {
        try
        {
            videotienda.afiliarCliente( cedula, nombre, direccion );
            videotienda.cargarSaldoCliente( cedula, saldo );
        }
        catch( Exception e )
        {
<<<<<<< HEAD
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Afiliación de Cliente", JOptionPane.ERROR_MESSAGE );
=======
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Afiliaci�n de Cliente", JOptionPane.ERROR_MESSAGE );
>>>>>>> feature/interfaz
            return;
        }

        panelClientes.actualizarClientes( new ArrayList<Cliente> ( videotienda.darClientes( ) ) );

    }

    /**
     * Retorna la lista de clientes de la videotienda
     * @return ArrayList con los clientes de la videotienda
     */
    public ArrayList<Cliente> darListaClientes( )
    {
    	return new ArrayList<Cliente>( videotienda.darClientes( ) );
    }

    /**
     * Recarga el saldo del cliente con la cantidad dada
<<<<<<< HEAD
     * @param cedula Cédula del cliente. cedula != null.
=======
     * @param cedula C�dula del cliente. cedula != null.
>>>>>>> feature/interfaz
     * @param recarga Monto de la recarga.
     */
    public void cargarSaldo( String cedula, int recarga )
    {
        try
        {
            videotienda.cargarSaldoCliente( cedula, recarga );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Recarga Saldo Cliente", JOptionPane.ERROR_MESSAGE );
            return;
        }
    }

    /**
     * Inicia el alquiler de una pel�cula
     */
    public void alquilarPelicula( )
    {
        String pelicula = panelPeliculas.darPeliculaSeleccionada( );
        if( pelicula == null )
        {
<<<<<<< HEAD
            JOptionPane.showMessageDialog( this, "Debe seleccionar una película", "Alquilar Película", JOptionPane.ERROR_MESSAGE );
=======
            JOptionPane.showMessageDialog( this, "Debe seleccionar una pel�cula", "Alquilar Pel�cula", JOptionPane.ERROR_MESSAGE );
>>>>>>> feature/interfaz
            return;
        }
        String cliente = panelClientes.darClienteSeleccionado( );
        if( cliente == null )
        {
<<<<<<< HEAD
            JOptionPane.showMessageDialog( this, "Debe seleccionar un cliente", "Alquilar Película", JOptionPane.ERROR_MESSAGE );
=======
            JOptionPane.showMessageDialog( this, "Debe seleccionar un cliente", "Alquilar Pel�cula", JOptionPane.ERROR_MESSAGE );
>>>>>>> feature/interfaz
            return;
        }
        try
        {
            int copia = videotienda.alquilarPelicula( pelicula, cliente );
<<<<<<< HEAD
            JOptionPane.showMessageDialog( this, "Se alquiló la copia " + copia + " de la película \"" + pelicula + "\"", "Alquilar Película", JOptionPane.INFORMATION_MESSAGE );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Alquilar Película", JOptionPane.ERROR_MESSAGE );
=======
            JOptionPane.showMessageDialog( this, "Se alquil� la copia " + copia + " de la pel�cula \"" + pelicula + "\"", "Alquilar Pel�cula", JOptionPane.INFORMATION_MESSAGE );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Alquilar Pel�cula", JOptionPane.ERROR_MESSAGE );
>>>>>>> feature/interfaz
        }
    }

    /**
     * Devuelve la copia alquilada por un cliente
<<<<<<< HEAD
     * @param cedula Cédula del cliente. cliente != null.
     * @param pelicula Título de la película a devolver. pelicula != null.
     * @param copia Número de la copia a devolver.
=======
     * @param cedula C�dula del cliente. cliente != null.
     * @param pelicula T�tulo de la pel�cula a devolver. pelicula != null.
     * @param copia N�mero de la copia a devolver.
>>>>>>> feature/interfaz
     */
    public void devolverCopia( String cedula, String pelicula, int copia )
    {
        try
        {
            videotienda.devolverCopia( pelicula, copia, cedula );
        }
        catch( Exception e )
        {
<<<<<<< HEAD
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Devolver Película", JOptionPane.ERROR_MESSAGE );
=======
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Devolver Pel�cula", JOptionPane.ERROR_MESSAGE );
>>>>>>> feature/interfaz
        }
    }

    /**
     * Centra una ventana en la pantalla
     * @param ventana La ventana que se va a centrar. ventana != null.
     */
    private void centrarVentana( Component ventana )
    {
        Dimension dPantalla = Toolkit.getDefaultToolkit( ).getScreenSize( );
        Dimension dVentana = ventana.getSize( );

        int xEsquina = ( dPantalla.width / 2 ) - ( dVentana.width / 2 );
        int yEsquina = ( dPantalla.height / 2 ) - ( dVentana.height / 2 );

        ventana.setLocation( xEsquina, yEsquina );
    }

    //-----------------------------------------------------------------
<<<<<<< HEAD
    // Puntos de Extensión
    //-----------------------------------------------------------------

    /**
     * Método de extensión 1
=======
    // Puntos de Extensi�n
    //-----------------------------------------------------------------

    /**
     * M�todo de extensi�n 1
>>>>>>> feature/interfaz
     */
    public void reqFuncOpcion1( )
    {
        String respuesta = videotienda.metodo1( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
<<<<<<< HEAD
     * Método de extensión 2
=======
     * M�todo de extensi�n 2
>>>>>>> feature/interfaz
     */
    public void reqFuncOpcion2( )
    {
        String respuesta = videotienda.metodo2( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    //-----------------------------------------------------------------
<<<<<<< HEAD
    // Ejecución
    //-----------------------------------------------------------------
    /**
     * Método para la ejecuci�n del programa
     * @param args Argumentos para la ejecución. No se requiere ninguno.
=======
    // Ejecuci�n
    //-----------------------------------------------------------------
    /**
     * M�todo para la ejecuci�n del programa
     * @param args Argumentos para la ejecuci�n. No se requiere ninguno.
>>>>>>> feature/interfaz
     */
    public static void main( String[] args )
    {
        try
        {
            UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName( ) );
        }
        catch( Exception e )
        {
            //Ignora el look & feel
        }
        InterfazVideotienda i = new InterfazVideotienda( );
        i.setVisible( true );
    }

}
