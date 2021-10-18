package guru.springframework.sfgdi.Repositories;

public class EnglishGreetingRepository implements IEnglishGreetingRepository{

    @Override
    public String getGreeting() {
        return "Hello World - EN";
    }
}
