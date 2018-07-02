package com.carmowallison.dynamic_field_api.resources;

import com.carmowallison.dynamic_field_api.domain.Pagina;
import com.carmowallison.dynamic_field_api.domain.TipoCampo;
import com.carmowallison.dynamic_field_api.dto.PaginaDTO;
import com.carmowallison.dynamic_field_api.dto.TipoCampoDTO;
import com.carmowallison.dynamic_field_api.services.PaginaService;
import com.carmowallison.dynamic_field_api.services.TipoCampoService;
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
@RequestMapping(value = "/tipo-campos")
public class TipoCampoResource {

    @Autowired
    private TipoCampoService service;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value = "Busca todos os tipo de campos")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TipoCampoDTO>> findAll() {
        List<TipoCampo> list = service.findAll();
        List<TipoCampoDTO> listDTO = list.stream().map(obj -> new TipoCampoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value = "Busca por um tipo de campos pelo seu id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TipoCampoDTO> findById(@PathVariable String id) {
        TipoCampo obj = service.findById(id);
        return ResponseEntity.ok().body(new TipoCampoDTO(obj));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value = "insere um novo tipo de campos")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody TipoCampoDTO objDTO) {

        TipoCampo obj = new TipoCampo().fromDTO(objDTO);

        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value = "Atualiza um tipo de campos")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @PathVariable String id, @RequestBody TipoCampo obj) {
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value = "Deleta um tipo de campos")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
