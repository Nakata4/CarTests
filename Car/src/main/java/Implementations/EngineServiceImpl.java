package Implementations;

import entities.Engine;
import repository.EngineRepository;
import interfaces.EngineService;

public class EngineServiceImpl implements EngineService{

    private final EngineRepository engineRepository;


    public EngineServiceImpl(EngineRepository engineRepository) {
        this.engineRepository = engineRepository;
    }

    public void saveEngine(Engine engine){
        engineRepository.save(engine);
    }

    public void deleteEngine(Engine engine){
        engineRepository.delete(engine);
    }

    public void updateEngine(Engine engine) {
        engineRepository.updateEngineById(engine.getId(), engine.getEngineType(), engine.getVolume(),
                engine.getHp(), engine.getNm());
    }
}
