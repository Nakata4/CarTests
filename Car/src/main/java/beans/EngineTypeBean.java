package beans;

import entities.EngineType;
import interfaces.EngineTypeService;
import java.util.List;

public class EngineTypeBean {

    EngineTypeService engineTypeService;

    private List<EngineType> allEngineTypes;

    public void init(){
        allEngineTypes = engineTypeService.getAllEngineTypes();
    }
    public List<EngineType> getAllEngineTypes() {
        return allEngineTypes;
    }
}
