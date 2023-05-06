package com.periferia.hackaton.mutantes.adn.domain.services.validate;

import com.periferia.hackaton.mutantes.adn.domain.entities.Adn;
import com.periferia.hackaton.mutantes.adn.domain.execptions.InvalidStructureDnaException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
@Getter
@Setter
public class AdnValidate {

    private final static String patternAdn = "[ATGC]+";

    private Adn adn;

    public void isFormatByChain() {
        for (String chain : adn.getDna()) {
            Pattern pattern = Pattern.compile(patternAdn, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(chain);
            if(!matcher.matches()){
                throw new InvalidStructureDnaException(String.format("Chain invalid %s",chain));
            }
        }
    }

    public void isStructureDna() {
        int columnSize = adn.getDna().length;
        if(columnSize < 4) {
            throw new InvalidStructureDnaException("Invalid Structure Column: "+columnSize);
        }
        for(String chain : adn.getDna()) {
            if(chain.length() != columnSize) {
                throw new InvalidStructureDnaException("Invalid Structure Rows: "+chain.length());
            }
        }
    }


}
