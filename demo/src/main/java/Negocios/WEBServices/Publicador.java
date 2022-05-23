package Negocios.WEBServices;

import Negocios.DT.DT_ListaPelicula;
import Negocios.Fabrica;
import Negocios.ISingletone;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import java.net.InetAddress;
import java.net.UnknownHostException;

import static java.lang.System.out;

/**
 *
 * @author visua
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class Publicador{

    private Endpoint endpoint = null;

    public Publicador(){}
    ISingletone s = Fabrica.getInstance();


    @WebMethod(exclude = true)
    public String GetComputerInfo() throws UnknownHostException
    {
        String ip = InetAddress.getLocalHost().getHostAddress();
        //String name = InetAddress.getLocalHost().getHostName();
        return ip;
    }

    @WebMethod(exclude = true)
    public void publicar(){
        String aux = "";
        try
        {
            //endpoint = Endpoint.publish("http://192.168.1.102:9097/publicador", this);
            endpoint = Endpoint.publish("http://localhost:8086/publicador", this);
            out.print("Servicios Publicados exitosamente");
        }
        catch (Exception ex) {
            aux = ex.getMessage();
            out.print(aux);
        }
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
        return endpoint;
    }

    @WebMethod
    public void altaPelicula(String nombre, String lanzamiento, String descripcion)
    {
        s.altaPelicula(nombre,lanzamiento,descripcion);
    }

    @WebMethod
    public DT_ListaPelicula gatPeliculas()
    {
        return s.listarPeliculas();
    }
}
