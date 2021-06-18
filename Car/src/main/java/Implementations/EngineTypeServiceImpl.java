package Implementations;

import entities.EngineType;
import repository.EngineTypeRepository;
import interfaces.EngineTypeService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class EngineTypeServiceImpl implements EngineTypeService{

    private final EngineTypeRepository engineTypeRepository;


    public EngineTypeServiceImpl(EngineTypeRepository engineTypeRepository) {
        this.engineTypeRepository = engineTypeRepository;
    }

    public List<EngineType> getAllEngineTypes(){
        return engineTypeRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public EngineType getEngineTypeById(Integer id){
        return engineTypeRepository.findOne(id);
    }
}
