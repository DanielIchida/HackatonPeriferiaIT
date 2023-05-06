package com.periferia.hackaton.mutantes.adn.domain.util;

public class ConvertArray {

    public  char[][] charTwoDimensions(String[] dna) {
        int sizeDna = dna.length;
        char[][] newDna = new char[sizeDna][sizeDna];
        for(int i = 0 ; i < sizeDna; i++) {
            char[] chain = dna[i].toCharArray();
            System.arraycopy(chain, 0, newDna[i], 0, chain.length);
        }
        return newDna;
    }

}
