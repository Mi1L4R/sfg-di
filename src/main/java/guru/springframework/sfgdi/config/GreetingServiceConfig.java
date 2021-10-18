package guru.springframework.sfgdi.config;

import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;
import guru.springframework.sfgdi.Repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.Repositories.IEnglishGreetingRepository;
import guru.springframework.sfgdi.datasource.FakeDataSource;
import guru.springframework.sfgdi.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(@Value("${guru.username}") String username,
                                  @Value("${guru.password}")  String password,
                                  @Value("${guru.jdbcURL}") String jdbcURL){

        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcURL(jdbcURL);

        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Profile({"dog","default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){

        return petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory){

        return petServiceFactory.getPetService("cat");
    }


    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){

        return new PrimaryGreetingService();
    }

    @Bean
    IEnglishGreetingRepository englishGreetingRepository(){
        return  new EnglishGreetingRepository();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(IEnglishGreetingRepository englishGreetingRepository){

        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18NSpanishService i18NSpanishService(){

        return new I18NSpanishService();
    }

    //@Bean
    ConstructorGreetingService constructorGreetingService(){

        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){

        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){

        return new SetterInjectedGreetingService();
    }
}
