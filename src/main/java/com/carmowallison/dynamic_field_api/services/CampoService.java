package com.carmowallison.dynamic_field_api.services;


import com.carmowallison.dynamic_field_api.domain.Campo;
import com.carmowallison.dynamic_field_api.domain.Pagina;
import com.carmowallison.dynamic_field_api.repositoties.CampoRepository;
import com.carmowallison.dynamic_field_api.repositoties.PaginaRepository;
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
public class CampoService {

    @Autowired
    CampoRepository repo;

    public Campo findById(String id) {
        Optional<Campo> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }


    public Campo insert(Campo obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Campo update(Campo obj) {
        Campo newObj = findById(obj.getId());

        updateData(newObj, obj);

        return repo.save(newObj);
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }

    public List<Campo> findAll() {
        return repo.findAll();
    }


    public Page<Campo> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
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


    private void updateData(Campo newObj, Campo obj) {

        if (!obj.getNome_campo().equals("")) {
            newObj.setNome_campo(obj.getNome_campo());
        }
        if (!obj.getMax().equals("")) {
            newObj.setMax(obj.getMax());
        }
        if (!obj.getMin().equals("")) {
            newObj.setMin(obj.getMin());
        }
        if (!obj.getTipo_campo().equals("")) {
            newObj.setTipo_campo(obj.getTipo_campo());
        }
        if (!obj.getTitulo().equals("")) {
            newObj.setTitulo(obj.getTitulo());
        }
    }
}