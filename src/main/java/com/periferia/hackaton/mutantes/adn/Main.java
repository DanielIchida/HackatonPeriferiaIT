package com.periferia.hackaton.mutantes.adn;

import com.periferia.hackaton.mutantes.adn.domain.services.search.SearchMutant;

public class Main {
    public static void main(String[] args) {
        String[] dna = new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        String[] dna2 = new String[]{"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"};
        SearchMutant mutant = new SearchMutant();
        System.out.println("IS MUTANT "+mutant.validateIsMutant(dna));
        System.out.println("IS MUTANT "+mutant.validateIsMutant(dna2));
    }

}
