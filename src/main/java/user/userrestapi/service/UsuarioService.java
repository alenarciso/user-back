package user.userrestapi.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.userrestapi.dto.FilterDTO;
import user.userrestapi.dto.UsuarioDTO;
import user.userrestapi.entity.Usuario;
import user.userrestapi.repository.UsuarioRepository;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public void save (UsuarioDTO usuarioDTO){
        if(usuarioDTO.getId() == null){
            usuarioDTO.setRegisterDate(LocalDateTime.now());
        }
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        repository.save(usuario);
    }

    public void deleteById ( long id){
        repository.deleteById(id);
    }

    public UsuarioDTO findById(long id){
        return modelMapper.map(repository.findById(id), UsuarioDTO.class);
    }

    public List<UsuarioDTO> filter(FilterDTO filterDTO){
        List<Usuario> users = repository.filter(filterDTO.getUserName(), filterDTO.getName(), filterDTO.getEmail());
        return convertToListDTO(users);
    }

    private List<UsuarioDTO> convertToListDTO(List<Usuario> users){
        return users.stream().map(user -> modelMapper.map(user, UsuarioDTO.class)).toList();
    }
}
