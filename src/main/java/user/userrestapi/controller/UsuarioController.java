package user.userrestapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import user.userrestapi.dto.FilterDTO;
import user.userrestapi.dto.UsuarioDTO;
import user.userrestapi.service.UsuarioService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/user")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/all")
    public List<UsuarioDTO> getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public UsuarioDTO getById(@PathVariable(value = "id") long id){
        return service.findById(id);
    }

    @PostMapping("/save")
    public void salvar (@RequestBody UsuarioDTO usuario){
        service.save(usuario);
    }

    @GetMapping("/delete/{id}")
    public void excluir(@PathVariable(value = "id") long id){
        service.deleteById(id);
    }

    @GetMapping("/filter")
    public List<UsuarioDTO> filter(@RequestBody FilterDTO filter){
        return service.filter(filter);
    }
}
