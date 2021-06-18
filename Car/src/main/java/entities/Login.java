package entities;

import security.LoginController;

import java.io.Serializable;
import java.util.Collection;

public class Login  {

    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;

    private Collection<CarsFrontUser> cars;
}
