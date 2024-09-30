package com.stylostore.stylo_store.service;

import com.stylostore.stylo_store.model.Talla;
import com.stylostore.stylo_store.repository.TallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TallaService {

    @Autowired
    private TallaRepository tallaRepository;

    // Obtener todas las tallas
    public List<Talla> obtenerTodos() {
        return tallaRepository.obtenerTodos();
    }

    // Obtener talla por ID
    public Talla obtenerPorId(Long id) {
        return tallaRepository.obtenerPorId(id);
    }

    // Insertar nueva talla
    public void insertarTalla(Talla talla) {
        tallaRepository.insertarTalla(talla);
    }

    // Actualizar talla
    public void actualizarTalla(Long id, Talla talla) {
        tallaRepository.actualizarTalla(id, talla);
    }

    // Eliminar talla
    public void eliminarTalla(Long id) {
        tallaRepository.eliminarTalla(id);
    }
}
