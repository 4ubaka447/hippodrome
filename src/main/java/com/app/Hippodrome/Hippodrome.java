package main.java.com.app.Hippodrome;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    private void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    private void move() {
        for (Horse horse : getHorses()) {
            horse.move();
        }
    }

    private void print() {
        for (Horse horse : getHorses()) {
            horse.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("");
        }
    }

    private Horse getWinner() {
        double max = 0;
        Horse winner = null;

        for (Horse horse : getHorses()) {
            if (horse.getDistance() > max){
                max = horse.getDistance();
                winner = horse;
            }
        }

        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<Horse>());

        Horse horse1 = new Horse("Лошака", 3, 0);
        Horse horse2 = new Horse("Скорая", 3, 0);
        Horse horse3 = new Horse("Антон", 3, 0);

        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);

        game.run();
        game.printWinner();
    }
}
