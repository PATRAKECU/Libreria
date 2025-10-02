package com.emprendimiento.saintpatrick.configuracion;

import com.emprendimiento.saintpatrick.configuracion.ConfiguracionSistema;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConfiguracionSistemaTest {

    @Test
    void getInstance_deberiaRetornarInstanciaNoNula() {
        ConfiguracionSistema config = ConfiguracionSistema.getInstance();
        assertNotNull(config);
    }

    @Test
    void getInstance_deberiaRetornarSiempreLaMismaInstancia() {
        ConfiguracionSistema config1 = ConfiguracionSistema.getInstance();
        ConfiguracionSistema config2 = ConfiguracionSistema.getInstance();
        assertSame(config1, config2);
    }

    @Test
    void get_conClaveExistente_deberiaRetornarValorCorrecto() {
        ConfiguracionSistema config = ConfiguracionSistema.getInstance();
        config.set("ui.theme", "light"); // Restaurar valor esperado
        String valor = config.get("ui.theme");
        assertEquals("light", valor);
    }

    @Test
    void get_conClaveInexistente_deberiaRetornarNull() {
        ConfiguracionSistema config = ConfiguracionSistema.getInstance();
        String valor = config.get("clave.inexistente");
        assertNull(valor);
    }

    @Test
    void set_conClaveYValor_deberiaActualizarPropiedad() {
        ConfiguracionSistema config = ConfiguracionSistema.getInstance();
        config.set("ui.theme", "dark");
        assertEquals("dark", config.get("ui.theme"));
    }

    @Test
    void set_conClaveNueva_deberiaAgregarPropiedad() {
        ConfiguracionSistema config = ConfiguracionSistema.getInstance();
        config.set("app.version", "1.0.0");
        assertEquals("1.0.0", config.get("app.version"));
    }
}