package countries;

import countries.Country;

public class State {

    private final long id;
    private final String code;
    private final String name;
    private final Country country;

    public State(long id, String code, String name, Country country){
        this.id = id;
        this.code = code;
        this.name = name;
        this.country = country;
    }

    public String getCode(){
        return this.code;
    }

    public String getName(){
        return this.name;
    }

    public long getId(){
        return this.id;
    }
}