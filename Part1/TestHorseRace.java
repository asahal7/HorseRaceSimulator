package Part1;

class TestHorseRace {
    public static void main(String[] args) {
        // Test the Horse class with detailed verification
        testHorseClass();
        
        // Test the Race class with different scenarios
        testRaceClass();
        
        // Additional edge case testing
        testEdgeCases();
    }
    
    private static void testHorseClass() {
        System.out.println("===== TESTING HORSE CLASS =====");
        
        // Test 1: Constructor and Initial State
        System.out.println("\n[Test 1] Constructor Initialization");
        Horse horse1 = new Horse('♘', "THUNDERBOLT", 0.7);
        verify("Name", horse1.getName().equals("THUNDERBOLT"));
        verify("Symbol", horse1.getSymbol() == '♘');
        verify("Initial confidence", horse1.getConfidence() == 0.7);
        verify("Initial distance", horse1.getDistanceTravelled() == 0);
        verify("Initial fall status", !horse1.hasFallen());
        
        // Test 2: Movement Functionality
        System.out.println("\n[Test 2] Movement Testing");
        horse1.moveForward();
        verify("Single move", horse1.getDistanceTravelled() == 1);
        horse1.moveForward();
        verify("Double move", horse1.getDistanceTravelled() == 2);
        
        // Test 3: Fall Status
        System.out.println("\n[Test 3] Fall Status");
        horse1.fall();
        verify("After fall", horse1.hasFallen());
        System.out.println("Horse fall status before moving: " + horse1.hasFallen()); // Debug print
        int before = horse1.getDistanceTravelled();
        horse1.moveForward();
        verify("Cannot move after fall", before == horse1.getDistanceTravelled());

        
        // Test 4: Reset Functionality
        System.out.println("\n[Test 4] Reset Testing");
        horse1.goBackToStart();
        verify("Distance after reset", horse1.getDistanceTravelled() == 0);
        verify("Fall status after reset", !horse1.hasFallen());
        
        // Test 5: Confidence Bounds
        System.out.println("\n[Test 5] Confidence Validation");
        horse1.setConfidence(1.5);
        verify("Upper bound (1.5 -> 1.0)", horse1.getConfidence() == 1.0);
        horse1.setConfidence(-0.3);
        verify("Lower bound (-0.3 -> 0.0)", horse1.getConfidence() == 0.0);
        horse1.setConfidence(0.8);
        verify("Valid value (0.8)", horse1.getConfidence() == 0.8);
        
        // Test 6: Symbol Change
        System.out.println("\n[Test 6] Symbol Modification");
        horse1.setSymbol('♞');
        verify("Symbol change", horse1.getSymbol() == '♞');
    }
    
    private static void testRaceClass() {
        System.out.println("\n===== TESTING RACE CLASS =====");
        
        // Test 1: Basic Race Simulation
        System.out.println("\n[Test 1] Normal Race Simulation");
        Race race = new Race(15); // Shorter race for testing
        
        Horse fastHorse = new Horse('⚡', "SPEED DEMON", 0.9);
        Horse slowHorse = new Horse('🐢', "SLOWPOKE", 0.3);
        Horse averageHorse = new Horse('🏇', "MIDDLER", 0.6);
        
        race.addHorse(fastHorse, 1);
        race.addHorse(slowHorse, 2);
        race.addHorse(averageHorse, 3);
        
        System.out.println("Starting normal race...");
        race.startRace();
        
        // Test 2: All Horses Fall
        System.out.println("\n[Test 2] All Horses Fall Scenario");
        Race unluckyRace = new Race(10);
        
        Horse unlucky1 = new Horse('☠', "UNLUCKY 1", 0.01);
        Horse unlucky2 = new Horse('☠', "UNLUCKY 2", 0.01);
        Horse unlucky3 = new Horse('☠', "UNLUCKY 3", 0.01);
        
        unluckyRace.addHorse(unlucky1, 1);
        unluckyRace.addHorse(unlucky2, 2);
        unluckyRace.addHorse(unlucky3, 3);
        
        System.out.println("Starting unlucky race...");
        unluckyRace.startRace();
    }
    
    private static void testEdgeCases() {
        System.out.println("\n===== TESTING EDGE CASES =====");
        
        // Test 1: Invalid Lane Number
        System.out.println("\n[Test 1] Invalid Lane Handling");
        Race race = new Race(10);
        Horse testHorse = new Horse('?', "TEST", 0.5);
        race.addHorse(testHorse, 5); // Should show error message
        
        // Test 2: Minimum Confidence
        System.out.println("\n[Test 2] Zero Confidence Horse");
        Horse noConfidence = new Horse('😨', "TIMID", 0.0);
        verify("Initial distance", noConfidence.getDistanceTravelled() == 0);
        noConfidence.moveForward();
        verify("Movement with 0 confidence", noConfidence.getDistanceTravelled() == 0);
        
        // Test 3: Maximum Confidence
        System.out.println("\n[Test 3] Full Confidence Horse");
        Horse maxConfidence = new Horse('😎', "CHAMP", 1.0);
        for (int i = 0; i < 5; i++) maxConfidence.moveForward();
        verify("Movement with 1.0 confidence", maxConfidence.getDistanceTravelled() == 5);
    }
    
    // Simple verify method for boolean conditions
    private static void verify(String testName, boolean condition) {
        System.out.printf("%-40s %s%n", testName, condition ? "✅ PASSED" : "❌ FAILED");
    }
}
