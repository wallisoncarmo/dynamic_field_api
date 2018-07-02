package com.carmowallison.dynamic_field_api.repositoties;

import com.carmowallison.dynamic_field_api.domain.Valor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValorRepository extends MongoRepository<Valor, String> {
}
