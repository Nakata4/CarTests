package Implementations;

import entities.Options;
import repository.OptionsRepository;
import interfaces.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OptionsServiceImpl implements OptionsService {

    private final OptionsRepository optionsRepository;

    @Autowired
    public OptionsServiceImpl(OptionsRepository optionsRepository) {
        this.optionsRepository = optionsRepository;
    }

    @Override
    public void saveOptions(Options options) {
        optionsRepository.save(options);
    }

    @Override
    public void updateOptions(Options options) {
        optionsRepository.updateOptionsById(options.getId(), options.getConditioner(), options.getLeather(), options.getAlloyWheels(),
                options.getXenon(), options.getPdc(), options.getAssHeating(), options.getAscSystem(), options.getNavi(),
                options.getSpeakerphone(), options.getFogLights(), options.getSignaling());
    }

    @Override
    public void deleteOptions(Options options) {
        optionsRepository.delete(options);
    }
}