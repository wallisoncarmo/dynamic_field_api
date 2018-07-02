package com.carmowallison.dynamic_field_api.services;


import com.carmowallison.dynamic_field_api.domain.Pagina;
import com.carmowallison.dynamic_field_api.domain.TipoCampo;
import com.carmowallison.dynamic_field_api.repositoties.PaginaRepository;
import com.carmowallison.dynamic_field_api.repositoties.TipoCampoRepository;
import com.carmowallison.dynamic_field_api.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class TipoCampoService {

    @Autowired
    TipoCampoRepository repo;

    public TipoCampo findById(String id) {
        Optional<TipoCampo> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }


    public TipoCampo insert(TipoCampo obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public TipoCampo update(TipoCampo obj) {
        TipoCampo newObj = findById(obj.getId());

        updateData(newObj, obj);

        return repo.save(newObj);
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }

    public List<TipoCampo> findAll() {
        return repo.findAll();
    }


    public Page<TipoCampo> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    private void updateData(TipoCampo newObj, TipoCampo obj) {
        if (!obj.getNome().equals("")) {
            newObj.setNome(obj.getNome());
        }
    }
}