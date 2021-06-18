package interfaces;

import entities.Options;

public interface OptionsService {

    void saveOptions(Options options);

    void updateOptions(Options options);

    void deleteOptions(Options options);
}
