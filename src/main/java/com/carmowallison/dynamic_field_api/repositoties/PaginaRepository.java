package com.carmowallison.dynamic_field_api.repositoties;

import com.carmowallison.dynamic_field_api.domain.Pagina;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaginaRepository extends MongoRepository<Pagina, String> {
    Optional<Pagina> findByNomeIgnoreCase(String nome);
}
