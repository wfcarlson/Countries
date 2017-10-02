package countries;

public class Country {

    private final long id;
    private final String code;
    private final String name;

    public Country(long id, String code, String name){
        this.id = id;
        this.code = code;
        this.name = name;
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