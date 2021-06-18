package interfaces;

import entities.EngineType;

import java.util.List;

public interface EngineTypeService {

    List<EngineType> getAllEngineTypes();

    EngineType getEngineTypeById(Integer id);
}
