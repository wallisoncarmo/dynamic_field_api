package com.carmowallison.dynamic_field_api.resources;

import com.carmowallison.dynamic_field_api.domain.Pagina;
import com.carmowallison.dynamic_field_api.domain.TipoPagina;
import com.carmowallison.dynamic_field_api.dto.PaginaDTO;
import com.carmowallison.dynamic_field_api.dto.TipoPaginaDTO;
import com.carmowallison.dynamic_field_api.services.PaginaService;
import com.carmowallison.dynamic_field_api.services.TipoPaginaService;
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
@RequestMapping(value = "/tipo-paginas")
public class TipoPaginaResource {

    @Autowired
    private TipoPaginaService service;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value = "Busca todas as páginas")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TipoPaginaDTO>> findAll() {
        List<TipoPagina> list = service.findAll();
        List<TipoPaginaDTO> listDTO = list.stream().map(obj -> new TipoPaginaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value = "Busca por uma página pelo seu id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TipoPaginaDTO> findById(@PathVariable String id) {
        TipoPagina obj = service.findById(id);
        return ResponseEntity.ok().body(new TipoPaginaDTO(obj));
    }

    @ApiOperation(value = "insere uma nova página")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody TipoPaginaDTO objDTO) {

        TipoPagina obj = new TipoPagina().fromDTO(objDTO);

        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value = "Atualiza uma página")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @PathVariable String id, @RequestBody TipoPagina obj) {
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value = "Deleta uma página")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
