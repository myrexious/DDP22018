public class Simulator {
    public static void main(String[] args) {
        Circuit losail = new Circuit("Losail International Circuit", 120);
        losail.addMotorcycle(new Motorcycle(135, 30, 1000, "Andrea Dovizioso"));
        losail.addMotorcycle(new Motorcycle(140, 25, 1000, "Marc Márquez"));
        losail.addMotorcycle(new Motorcycle(130, 20, 1000, "Cal Crutchlow"));
        losail.addMotorcycle(new Motorcycle(150, 15, 1000, "Valentino Rossi"));

        losail.doRace();

        losail.refuel(100);
        // Andrea Dovizioso and Cal Crutchlow can't complete the race due to no fuel.
        losail.doRace();

        Circuit assen = new Circuit("TT Circuit Assen", 100);
        assen.addMotorcycle(new Motorcycle(150, 40, 150, "Maverick Viñales"));
        assen.addMotorcycle(new Motorcycle(100, 30, 190, "Takaaki Nakagami"));
        assen.addMotorcycle(new Motorcycle(170, 25, 225, "Joan Mir"));
        assen.addMotorcycle(new Motorcycle(180, 25, 250, "Aleix Espargaro"));
        assen.addMotorcycle(new Motorcycle(200, 15, 275, "Jorge Lorenzo"));

        assen.refuel(100);
        assen.doRace();
        // Maverick Viñales and Takaaki Nakagami can't complete the race due to no fuel.
        assen.doRace();
        // no one can complete this race
        assen.doRace();
    }
}
