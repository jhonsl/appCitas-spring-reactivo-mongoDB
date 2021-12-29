package com.springBajo8.springBajo8.service;

import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

public interface IcitasReactivaService {
    Mono<citasDTOReactiva> save(citasDTOReactiva citasDTOReactiva);

    Mono<citasDTOReactiva> delete(String id);

    Mono<citasDTOReactiva> update(String id, citasDTOReactiva citasDTOReactiva);

    Mono<citasDTOReactiva> findById(String id);

    Mono<citasDTOReactiva> findCita(LocalDate fecha, String hora);

    Mono<citasDTOReactiva> cancelCita(String id);

    Flux<citasDTOReactiva> findByIdPaciente(String idPaciente);

    Flux<citasDTOReactiva> findAll();

    Mono<citasDTOReactiva> findByFechaReservaCita(LocalDate fecha);

    Mono<citasDTOReactiva> findByNombreMedico(String name);
}
