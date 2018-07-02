package com.carmowallison.dynamic_field_api.resources;

import com.carmowallison.dynamic_field_api.domain.Campo;
import com.carmowallison.dynamic_field_api.domain.Pagina;
import com.carmowallison.dynamic_field_api.dto.CampoDTO;
import com.carmowallison.dynamic_field_api.dto.PaginaDTO;
import com.carmowallison.dynamic_field_api.services.CampoService;
import com.carmowallison.dynamic_field_api.services.PaginaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/campos")
public class CampoResource {

    @Autowired
    private CampoService service;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value = "Busca todos os campo")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CampoDTO>> findAll() {
        List<Campo> list = service.findAll();
        List<CampoDTO> listDTO = list.stream().map(obj -> new CampoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value = "Busca por um campo pelo seu id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CampoDTO> findById(@PathVariable String id) {
        Campo obj = service.findById(id);
        return ResponseEntity.ok().body(new CampoDTO(obj));
    }

    @ApiOperation(value = "insere um novo campo")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody CampoDTO objDTO) {

        Campo obj = new Campo().fromDTO(objDTO);

        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value = "Atualiza um campo")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @PathVariable String id, @RequestBody Campo obj) {
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value = "Deleta um campo")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
