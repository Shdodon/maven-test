package ru.shdodo;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class App 
{
    public static void main( String[] args )
    {
        DescriptiveStatistics statistics = new DescriptiveStatistics();

        for (int i = 0; i < 1000; i++) {
            statistics.addValue(new MontyGame().playGame(false));
        }
        System.out.printf("Дверь не меняли. Число попыток: %d, выиграно %.1f%%\n", statistics.getN(), statistics.getMean() * 100);

        statistics.clear();

        for (int i = 0; i < 1000; i++) {
            statistics.addValue(new MontyGame().playGame(true));
        }
        System.out.printf("Дверь менялась. Число попыток: %d, выиграно %.1f%%\n", statistics.getN(), statistics.getMean() * 100);
    }
}
