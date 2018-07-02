package com.carmowallison.dynamic_field_api.repositoties;


import com.carmowallison.dynamic_field_api.domain.TipoPagina;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPaginaRepository extends MongoRepository<TipoPagina, String> {
}
