package com.dlopez.taller3.service;

import com.dlopez.taller3.model.Prestamo;
import com.dlopez.taller3.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    //Crear un prestamo.
    public Prestamo createLoan(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    //Obtener todos los prestamos.
    public List<Prestamo> getAllLoans() {
        return prestamoRepository.findAll();
    }

    //Obtener prestamo por Id.
    public Optional<Prestamo> getLoanById(Long id) {
        return prestamoRepository.findById(id);
    }

    //Actualizar un prestamo.
    public Prestamo updateLoan(Long id, Prestamo prestamoDetails) {
        Prestamo prestamo = prestamoRepository.findById(id).orElseThrow();
        prestamo.setFechaPrestamo(prestamoDetails.getFechaPrestamo());
        prestamo.setFechaDevolucion(prestamoDetails.getFechaDevolucion());
        prestamo.setPrestado(prestamoDetails.isPrestado());
        return prestamoRepository.save(prestamo);
    }

    //Eliminar un prestamo.
    public void deleteLoan(Long id) {
        prestamoRepository.deleteById(id);
    }
}