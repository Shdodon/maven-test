package ru.shdodo;

import lombok.Setter;

import java.util.Random;

public class MontyGame {
    private static Random rnd;
    private final int grandPrizeDoor;
    private int playerDoor, montyDoor;

    public MontyGame() {
        rnd = new Random();
        grandPrizeDoor = rnd.nextInt(1, 4);
        playerDoor = 0;
        montyDoor = 0;
    }

    public int playGame(boolean isChangeDoorStrategy) {
        playerChoice();
        montyChoice();
        if (isChangeDoorStrategy) {
            changePlayerDoor();
        }

        return checkWin();
    }

    private void playerChoice() {
        playerDoor = rnd.nextInt(1, 4);
    }

    private void montyChoice() {
        montyDoor = chooseAnotherDoor(grandPrizeDoor, playerDoor);
    }

    private void changePlayerDoor() {
        playerDoor = chooseAnotherDoor(playerDoor, montyDoor);
    }

    private int chooseAnotherDoor(int door1, int door2) {
        int result;
        do
            result = rnd.nextInt(1,4);
        while (result == door1 || result == door2);

        return result;
    }

    private int checkWin() {
        return playerDoor == grandPrizeDoor ? 1 : 0;
    }
}
