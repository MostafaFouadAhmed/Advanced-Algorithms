package challenges;

import java.util.Scanner;

public class TwoEggProblem {

    private static int numberOfTrials = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int floors = in.nextInt();
        int eggs = in.nextInt();

        System.out.println(solve(floors, eggs));

    }


    private static int solve (final int floors, final int eggs) {

        numberOfTrials++;

        if (floors == 0 || floors == 1) {
            return numberOfTrials;
        }


        return getNumberOfTrials(floors, eggs, 1);
    }

    private static int getNumberOfTrials (final int floors, final int eggs, int currentFloor) {

        while (currentFloor < floors) {

            numberOfTrials ++;
            getNumberOfTrials(floors, eggs, (currentFloor+= eggs + 1 ));

        }
        return numberOfTrials;
    }

}
