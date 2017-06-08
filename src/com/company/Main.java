package com.company;

import main.SSHromosome;
import main.StreadyStageForFunction;
import main.AHromosome;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void SSHromosomeisGenerate() {
        double a=1;
        double b=5;
        SSHromosome h = new SSHromosome();
        h.generateHromosome(a, b);
        System.out.print(h.getHromosome());
    }

    public static void main(String[] args) {
        double a = 1;
        double b = 10;
        int N = 10;
        int step = 500;
        StreadyStageForFunction ga = new StreadyStageForFunction(a, b, N);
        List<SSHromosome> parentList = ga.generateHromosomes();
        for (int i = 0; i < step; i++) {
            List<SSHromosome> childrenList = ga.chooseParents(parentList);

            List<SSHromosome> listToAdd = new ArrayList<>();
            for (SSHromosome h : childrenList) {
                SSHromosome m = ga.mutation(h);
                listToAdd.add(m);
            }
            childrenList.addAll(listToAdd);
            parentList = ga.crossingover(parentList, childrenList);

        }
        SSHromosome best = ga.result(parentList);
        System.out.println("BEST "+ best.getHromosome());
    }
}
