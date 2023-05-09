public class Main {
    public static void main(String[] args) {

        System.out.println("Patrón GoF - Iterador");
        System.out.println("Album de láminas\n\n");

        // Construimos una colección
        Album miAlbum = new Album();
        miAlbum.SetNombre("Mundial 2022");
        miAlbum.SetLamina(new Lamina(1, "Equipo - Francia"));
        miAlbum.SetLamina(new Lamina(2, "Jugador - Leonel Messi"));
        miAlbum.SetLamina(new Lamina(3, "Equipo - Brasil"));
        miAlbum.SetLamina(new Lamina(4, "Jugador - Cristiano Ronaldo"));
        miAlbum.SetLamina(new Lamina(5, "Jugador - Neymar"));
        miAlbum.SetLamina(new Lamina(6, "Equipo - Japón"));
        miAlbum.SetLamina(new Lamina(7, "Equipo - Holanda"));
        miAlbum.SetLamina(new Lamina(8, "Equipo - Mexico"));

        // Creamos el iterador
        Iterador unIterador = miAlbum.CrearIterador();
        unIterador.SetIncremento(6);

        System.out.println("Iterando de a " + unIterador.GetIncremento() +
                " laminas sobre el album: "+ miAlbum.GetNombre());
        for (Lamina unaLamina = unIterador.Primera();
             !unIterador.EstaTerminado();
             unaLamina = unIterador.Siguiente())
        {
            System.out.println(unaLamina.toString());
        }
    }
}