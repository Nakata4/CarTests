package beans;

import entities.Type;
import interfaces.TypeService;
import java.util.List;

public class TypeBean{

    TypeService typeService;

    private List<Type> allTypes;

    public void init(){
        allTypes = typeService.getAllTypes();
    }
    public List<Type> getAllTypes() {
        return allTypes;
    }
}
