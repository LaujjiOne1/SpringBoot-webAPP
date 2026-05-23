package com.pour.tp.jenkins.myHelloWorld;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MonControlleurTests {

    @Test
    void monTestUnitaireSimple() {
        // Un test basique qui vérifie une opération logique
        int resultat = 2 + 2;
        assertEquals(4, resultat, "Le calcul de base doit être correct");
    }
}