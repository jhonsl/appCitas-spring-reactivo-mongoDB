package com.springBajo8.springBajo8.service.impl;

import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import com.springBajo8.springBajo8.repository.IcitasReactivaRepository;
import com.springBajo8.springBajo8.service.IcitasReactivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
public class citasReactivaServiceImpl implements IcitasReactivaService {

    @Autowired
    private IcitasReactivaRepository icitasReactivaRepository;
    //private IcitasReactivaRepository IcitasReactivaRepository;

    @Override
    public Mono<citasDTOReactiva> save(citasDTOReactiva citasDTOReactiva) {
        return this.icitasReactivaRepository.save(citasDTOReactiva);
    }

    @Override
    public Mono<citasDTOReactiva> delete(String id) {
        return this.icitasReactivaRepository
                .findById(id)
                .flatMap(p -> this.icitasReactivaRepository.deleteById(p.getId()).thenReturn(p));

    }

    @Override
    public Mono<citasDTOReactiva> update(String id, citasDTOReactiva citasDTOReactiva) {
        return this.icitasReactivaRepository.findById(id)
                .flatMap(citasDTOReactiva1 -> {
                    citasDTOReactiva.setId(id);
                    return save(citasDTOReactiva);
                })
                .switchIfEmpty(Mono.empty());
    }
    @Override
    public Mono<citasDTOReactiva> cancelCita(String id) {
        return this.icitasReactivaRepository.findById(id)
                .flatMap(citasDTOReactiva -> {
                    citasDTOReactiva.setEstadoReservaCita(false);
                    return save(citasDTOReactiva);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<citasDTOReactiva> findByIdPaciente(String idPaciente) {
        return this.icitasReactivaRepository.findByIdPaciente(idPaciente);
    }

    @Override
    public Flux<citasDTOReactiva> findAll() {
        return this.icitasReactivaRepository.findAll();
    }

    @Override
    public Mono<citasDTOReactiva> findByFechaReservaCita(LocalDate fecha) {
        return this.icitasReactivaRepository.findByFechaReservaCita(fecha);
    }

    @Override
    public Mono<citasDTOReactiva> findByNombreMedico(String name) {
        return this.icitasReactivaRepository.findByNombreMedico(name)
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<citasDTOReactiva> findById(String id) {
        return this.icitasReactivaRepository.findById(id);
    }

    @Override
    public Mono<citasDTOReactiva> findCita(LocalDate fecha, String hora) {
        return this.icitasReactivaRepository.findByFechaReservaCita(fecha)
                .filter(citasDTOReactiva -> citasDTOReactiva.getHoraReservaCita().equals(hora))
                .switchIfEmpty(Mono.empty());
    }
}