package com.springBajo8.springBajo8.repository;

import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Repository
public interface IcitasReactivaRepository extends ReactiveMongoRepository<citasDTOReactiva, String> {
    Flux<citasDTOReactiva> findByIdPaciente(String idPaciente);
    Mono<citasDTOReactiva> findByNombreMedico(String nombre);
    Mono<citasDTOReactiva> findByFechaReservaCita(LocalDate fecha);
}
