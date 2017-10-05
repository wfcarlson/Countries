package countries;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import countries.Country;

@Entity
public class State {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String code;
    private String name;

    @ManyToOne
    private final Country country;

    public State(String code, String name, Country country) {
        this.code = code;
        this.name = name;
        this.country = country;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public long getId() {
        return this.id;
    }

    public Country getCountry() {
        return this.country;
            
        
    }
}