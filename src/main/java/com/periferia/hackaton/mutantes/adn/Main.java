package com.periferia.hackaton.mutantes.adn;

import com.periferia.hackaton.mutantes.adn.domain.services.search.SearchMutant;

public class Main {
    public static void main(String[] args) {
        String[] dna = new String[]{
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"
        };
        String[] dna2 = new String[]{"ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG"};
        String[] dna3 = new String[]{"AGAGAG", "AACTCG", "TCTGTA", "TGAATA", "CGGTCC", "ACAGTC"};
        String[] dna4 = new String[]{
                "CTGGCC",
                "TATACC",
                "TCGGTG",
                "TTAATG",
                "TCATTT",
                "AGCTTG"
        };
        SearchMutant mutant = new SearchMutant();
        System.out.println("IS MUTANT "+mutant.validateIsMutant(dna));
        System.out.println("IS MUTANT "+mutant.validateIsMutant(dna2));
        System.out.println("IS MUTANT "+mutant.validateIsMutant(dna3));
        System.out.println("IS MUTANT "+mutant.validateIsMutant(dna4));
    }


    public static int verticalUp(String[] dna) {
        int letterCounter = 1;
        int mutantCounter = 0;
        int midPoint = (dna[0].length() / 2);
        for (int col = dna.length - 1; col >= midPoint; col--) {
            for (int row = 1; row < dna.length; row++) {
                if (dna[row].charAt(col) == dna[row - 1].charAt(col)) {
                    letterCounter++;
                } else {
                    letterCounter = 1;
                }
                if(letterCounter == 4) {
                    mutantCounter++;
                    letterCounter = 0;
                }
            }
            letterCounter = 1;
        }
        return mutantCounter;
    }

    public static int verticalDown(String[] dna) {
        int letterCounter = 1;
        int mutantCounter = 0;
        int midPoint = (dna[0].length() / 2);
        for (int col = 0; col < midPoint; col++) {
            for (int row = 1; row < dna.length; row++) {
                if (dna[row].charAt(col) == dna[row - 1].charAt(col)) {
                    letterCounter++;
                } else {
                    letterCounter = 1;
                }
                if(letterCounter == 4) {
                    mutantCounter++;
                    letterCounter = 0;
                }
            }
            letterCounter = 1;
        }
        return mutantCounter;
    }

    public static int horizontalRight(String[] dna) {
        int letterCounter = 1;
        int mutantCounter = 0;
        int midPoint = (dna[0].length() / 2);
        for (int row = 0; row < midPoint; row++) {
            for (int col = 1; col < dna.length; col++) {
                if (dna[row].charAt(col) == dna[row].charAt(col - 1)) {
                    letterCounter++;
                } else {
                    letterCounter = 1;
                }
                if(letterCounter == 4) {
                    mutantCounter++;
                    letterCounter = 0;
                }
            }
            letterCounter = 1;
        }
        return mutantCounter;
    }

    public static int horizontalLeft(String[] dna) {
        int letterCounter = 1;
        int mutantCounter = 0;
        int midPoint = (dna[0].length() / 2);
        for (int row = dna.length - 1; row >= midPoint; row--) {
            for (int col = 1; col < dna.length; col++) {
                if (dna[row].charAt(col) == dna[row].charAt(col - 1)) {
                    letterCounter++;
                } else {
                    letterCounter = 1;
                }
                if(letterCounter == 4) {
                    mutantCounter++;
                    letterCounter = 0;
                }
            }
            letterCounter = 1;
        }
        return mutantCounter;
    }

    public static int diagonalFromRightUp(String[] dna) {
        int letterCounter = 1;
        int mutantCounter = 0;
        for (int rowPivot = 3; rowPivot < dna.length -1; rowPivot++) {
            for (int row = rowPivot, col = dna.length - 1; row > 0; row--, col--) {
                if (dna[row].charAt(col) == dna[row - 1].charAt(col - 1)) {
                    letterCounter++;
                } else {
                    letterCounter = 1;
                }
                if(letterCounter == 4) {
                    mutantCounter++;
                    letterCounter = 0;
                }
            }
            letterCounter = 1;
        }
        return mutantCounter;
    }

    public static int diagonalFromLeftUp(String[] dna) {
        int letterCounter = 1;
        int mutantCounter = 0;
        for (int rowPivot = 3; rowPivot < dna.length - 1; rowPivot++) {
            for (int row = rowPivot, col = 0; row > 0; row--, col++) {
                if (dna[row].charAt(col) == dna[row - 1].charAt(col + 1)) {
                    letterCounter++;
                } else {
                    letterCounter = 1;
                }
                if(letterCounter == 4) {
                    mutantCounter++;
                    letterCounter = 0;
                }
            }
            letterCounter = 1;
        }
        return mutantCounter;
    }

    public static int diagonalFromLeftDown(String[] dna) {
        int letterCounter = 1;
        int mutantCounter = 0;
        for (int rowPivot = dna.length - 4; rowPivot >= 0; rowPivot--) {
            for (int row = rowPivot, col = 0; dna.length - row > 1; row++, col++) {
                if (dna[row].charAt(col) == dna[row + 1].charAt(col + 1)) {
                    letterCounter++;
                } else {
                    letterCounter = 1;
                }
                if(letterCounter == 4) {
                    mutantCounter++;
                    letterCounter = 0;
                }
            }
            letterCounter = 1;
        }
        return mutantCounter;
    }

    public static int diagonalFromRightDown(String[] dna) {
        int letterCounter = 1;
        int mutantCounter = 0;
        for (int rowPivot = dna.length - 4; rowPivot >= 0; rowPivot--) {
            for (int row = rowPivot, col = dna.length - 1; dna.length - row > 1; row++, col--) {
                if (dna[row].charAt(col) == dna[row + 1].charAt(col - 1)) {
                    letterCounter++;
                } else {
                    letterCounter = 1;
                }
                if(letterCounter == 4) {
                    mutantCounter++;
                    letterCounter = 0;
                }
            }
            letterCounter = 1;
        }
        return mutantCounter;
    }



}
