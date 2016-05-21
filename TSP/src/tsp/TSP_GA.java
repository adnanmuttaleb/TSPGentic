/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.io.BufferedReader;
import java.io.FileReader;

public class TSP_GA {

    public static void main(String[] args) throws Exception {

        // Create and add our cities
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ADNAN\\Desktop\\mine\\project\\TSP\\src\\tsp\\dj38.tsp"));
        String line;
        String arr[];
        for (int i = 0; i < 38; i++) {
            line = br.readLine();
            arr = line.split(" ");
            City city = new City(Double.parseDouble(arr[1]), Double.parseDouble(arr[2]));
            TourManager.addCity(city);
        }

        // Initialize population
        Population pop = new Population(1000, true);
        System.out.println("Initial distance: " + pop.getFittest().getDistance());

        // Evolve population for 100 generations
        pop = GA.evolvePopulation(pop);
        for (int i = 0; i < 500; i++) {
            pop = GA.evolvePopulation(pop);
        }

        // Print final results
        System.out.println("Finished");
        System.out.println("Final distance: " + pop.getFittest().getDistance());
        System.out.println("Solution:");
        System.out.println(pop.getFittest());
    }
}
