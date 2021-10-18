package guru.springframework.sfgdi.services;

import guru.springframework.sfgdi.Repositories.IEnglishGreetingRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by jt on 12/27/19.
 */
public class I18nEnglishGreetingService implements GreetingService {

    private final IEnglishGreetingRepository englishGreetingRepository;

    public I18nEnglishGreetingService(IEnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return "Hello World - EN";
    }
}
