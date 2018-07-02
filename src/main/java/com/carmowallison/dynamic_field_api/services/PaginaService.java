package com.carmowallison.dynamic_field_api.services;


import com.carmowallison.dynamic_field_api.domain.Pagina;
import com.carmowallison.dynamic_field_api.repositoties.PaginaRepository;
import com.carmowallison.dynamic_field_api.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Sort.Direction;

import java.io.*;
import java.util.List;
import java.util.Optional;


@Service
public class PaginaService {

    @Autowired
    PaginaRepository repo;

    public Pagina findById(String id) {
        Optional<Pagina> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public Pagina findByNome(String nome) {
        Optional<Pagina> obj = repo.findByNomeIgnoreCase(nome);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public Pagina insert(Pagina obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Pagina update(Pagina obj) {
        Pagina newObj = findById(obj.getId());

        updateData(newObj, obj);

        return repo.save(newObj);
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }

    public List<Pagina> findAll() {
        return repo.findAll();
    }


    public Page<Pagina> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    private File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }


    private void updateData(Pagina newObj, Pagina obj) {
        if (!obj.getNome().equals("")) {
            newObj.setNome(obj.getNome());
        }
        newObj.setCampos(obj.getCampos());
    }
}