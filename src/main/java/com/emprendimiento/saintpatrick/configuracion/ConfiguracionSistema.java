package com.emprendimiento.saintpatrick.configuracion;

import java.util.Properties;

public class ConfiguracionSistema {
    private static ConfiguracionSistema instancia;
    private Properties propiedades;

    private ConfiguracionSistema() {
        propiedades = new Properties();
        // Carga valores por defecto o desde archivo externo
        propiedades.setProperty("db.url", "jdbc:...");
        propiedades.setProperty("ui.theme", "light");
        // …
    }

    public static synchronized ConfiguracionSistema getInstance() {
        if (instancia == null) {
            instancia = new ConfiguracionSistema();
        }
        return instancia;
    }

    public String get(String clave) {
        return propiedades.getProperty(clave);
    }

    public void set(String clave, String valor) {
        propiedades.setProperty(clave, valor);
    }
}

