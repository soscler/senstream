package com.tsimul;

import com.tsimul.helpers.WebHelper;

public class IOTSystemResource {

    /**
     * Avoir un liste des chemins api déjà pris par le système
     * Avoir une liste des tables et vues dans la base de données appartenant au système
     * - Un plugin dans la base de donnée représente un utilisateur
     * - Un plugin dans le web représent un ...
     */

    private final WebHelper webHelper;

    IOTSystemResource(WebHelper webHelper) {
        this.webHelper = webHelper;
    }

    WebHelper getWebHelper() {
        return webHelper; // Singleton
    }
}
