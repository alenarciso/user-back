package user.userrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import user.userrestapi.entity.Usuario;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findById(long idUsuario);

    @Query("SELECT usuario FROM Usuario AS usuario "
            + " WHERE (:userName IS NULL OR usuario.userName ilike %:userName%) AND " +
            "(:name IS NULL OR usuario.name ilike %:name%) AND " +
            "(:email IS NULL OR usuario.email ilike %:email%) ")
    List<Usuario> filter(@Param("userName") String userName,
                         @Param("name") String name,
                         @Param("email") String email);
}
