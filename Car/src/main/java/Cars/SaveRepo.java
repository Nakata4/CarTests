package Cars;

import java.util.UUID;

public interface SaveRepo {
    void addClassSave(UUID gun, UUID gunType) throws DB;

    void removeClassSave(UUID gun, UUID gunType);
}
