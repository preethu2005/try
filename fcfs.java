package org.cloudbus.cloudsim.examples;

import java.text.ParseException;

class FCFS {

    static void findWaitingTime(int processes[], int n, int bt[], int wt[]) {
        wt[0] = 0;
        for (int i = 1; i < n; i++) {
            wt[i] = bt[i - 1] + wt[i - 1];
        }
    }

    static void findTurnAroundTime(int processes[], int n, int bt[], int wt[], int tat[]) {
        for (int i = 0; i < n; i++) {
            tat[i] = bt[i] + wt[i];
        }
    }

    static void findAvgTime(int processes[], int n, int bt[]) {
        int wt[] = new int[n], tat[] = new int[n];
        int total_wt = 0, total_tat = 0;

        findWaitingTime(processes, n, bt, wt);
        findTurnAroundTime(processes, n, bt, wt, tat);

        System.out.println("Processes  Burst Time  Waiting Time  Turnaround Time");

        for (int i = 0; i < n; i++) {
            total_wt += wt[i];
            total_tat += tat[i];
            System.out.println("  " + (i + 1) + "\t\t" + bt[i] + "\t    " + wt[i] + "\t\t " + tat[i]);
        }

        float avg_wt = (float) total_wt / (float) n;
        float avg_tat = (float) total_tat / (float) n;

        System.out.println("\nAverage Waiting Time = " + avg_wt);
        System.out.println("Average Turnaround Time = " + avg_tat);
    }

    public static void main(String args[]) throws ParseException {
        int processes[] = {1, 2, 3};
        int n = processes.length;
        int burst_time[] = {7, 5, 8};

        findAvgTime(processes, n, burst_time);
    }
}
