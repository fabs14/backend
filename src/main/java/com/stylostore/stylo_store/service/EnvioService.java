package com.stylostore.stylo_store.service;

import com.stylostore.stylo_store.model.Envio;
import com.stylostore.stylo_store.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvioService {

    @Autowired
    private EnvioRepository envioRepository;

    // Obtener todos los envíos
    public List<Envio> obtenerTodos() {
        return envioRepository.obtenerTodos();
    }

    // Obtener envío por ID
    public Envio obtenerPorId(Long id) {
        return envioRepository.obtenerPorId(id);
    }

    // Insertar nuevo envío
    public void insertarEnvio(Envio envio) {
        envioRepository.insertarEnvio(envio);
    }

    // Actualizar envío
    public void actualizarEnvio(Long id, Envio envio) {
        envioRepository.actualizarEnvio(id, envio);
    }

    // Eliminar envío
    public void eliminarEnvio(Long id) {
        envioRepository.eliminarEnvio(id);
    }
}
