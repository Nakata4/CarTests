package interfaces;

import entities.Type;

import java.util.List;

public interface TypeService {

    List<Type> getAllTypes();

    Type getTypeById(Integer id);
}
