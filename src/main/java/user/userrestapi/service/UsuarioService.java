package user.userrestapi.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.userrestapi.dto.FilterDTO;
import user.userrestapi.dto.UsuarioDTO;
import user.userrestapi.entity.Usuario;
import user.userrestapi.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public void save (UsuarioDTO usuarioDTO){
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        repository.save(usuario);
    }

    public void deleteById ( long id){
        repository.deleteById(id);
    }

    public UsuarioDTO findById(long id){
        UsuarioDTO dto = modelMapper.map(repository.findById(id), UsuarioDTO.class);
        return dto;
    }

    public List<UsuarioDTO> filter(FilterDTO filterDTO){
        List<Usuario> users = repository.filter(filterDTO.getUserName(), filterDTO.getName(), filterDTO.getEmail());
        return convertToListDTO(users);
    }

    private List<UsuarioDTO> convertToListDTO(List<Usuario> users){
        List<UsuarioDTO> listDTO = new ArrayList<>();
        if(users != null){
            users.forEach(user -> {
                listDTO.add(modelMapper.map(user, UsuarioDTO.class));
            });
        }
        return listDTO;
    }
}
