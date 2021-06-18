package interfaces;

import entities.Engine;

public interface EngineService {

    void saveEngine(Engine engine);

    void deleteEngine(Engine engine);

    void updateEngine(Engine engine);
}
