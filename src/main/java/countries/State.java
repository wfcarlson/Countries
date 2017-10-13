package countries;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import countries.Country;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class State {

    @Id
    @JsonIgnore
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

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public long getId() {
        return this.id;
    }

    public Country getCountry() {
        return this.country;
    }
}