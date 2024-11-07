public class Principal {
    public static void main(String[] args) {
        BusquedaConversor consulta = new BusquedaConversor();
        Moneda moneda = consulta.moneda("USD");
        System.out.println(moneda);




    }
}
