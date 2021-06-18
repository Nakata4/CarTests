package entities;

import security.LoginController;

import java.util.Collection;

public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Byte active;
    private Collection<CarsFrontUser> cars;
}
