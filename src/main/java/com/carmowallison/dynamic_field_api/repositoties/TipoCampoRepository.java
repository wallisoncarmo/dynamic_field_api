package com.carmowallison.dynamic_field_api.repositoties;


import com.carmowallison.dynamic_field_api.domain.TipoCampo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCampoRepository extends MongoRepository<TipoCampo, String> {
}
