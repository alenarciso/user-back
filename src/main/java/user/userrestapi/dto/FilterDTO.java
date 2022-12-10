package user.userrestapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class FilterDTO implements Serializable {

    private String userName;
    private String name;
    private String email;
}
