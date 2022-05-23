package Negocios;

public class Fabrica{
    private static Singletone instancia;

    public static ISingletone getInstance(){
        if (instancia == null){
            instancia = new Singletone();
        }
        return instancia;
    }
}
