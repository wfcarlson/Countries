package countries;

import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Map;

import countries.Country;
import countries.State;

@RequestMapping("/countries")
@RestController
public class CountryController {

    public Collection<Country> countries;
    public Collection<State> states;

    public CountryController() {

        Country us = new Country("US", "United States");
        Country can = new Country("CA", "Canada");
        Country mex = new Country("MX", "Mexico");

        State va = new State("VA", "Virginia", us);
        State ma = new State("MA", "Maine", us);
        State on = new State("ON", "Ontario", can);
        State qu = new State("QU", "Quebec", can);
        State oa = new State("OA", "Oaxaca", mex);
        State bc = new State("BC", "Baja California", mex);

        this.countries = new ArrayList<Country>(3);
        this.states = new ArrayList<State>(6);

        countries.add(us);
        countries.add(can);
        countries.add(mex);

        states.add(va);
        states.add(ma);
        states.add(on);
        states.add(qu);
        states.add(oa);
        states.add(bc);

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Country>> getCountries() {
        return new ResponseEntity<Collection<Country>>(this.countries, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Country> postCountry(@RequestBody Country country) {
        this.countries.add(country);
        return new ResponseEntity<Country>(country, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{countryCode}")
    public ResponseEntity<Collection<State>> getStates(@PathVariable String countryCode) {
        Collection<State> states = this.states.stream().filter(p -> p.getCountry().getCode().equals(countryCode)).collect(Collectors.toList());
        return new ResponseEntity<Collection<State>>(states, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{countryCode}")
    public ResponseEntity<Country> deleteCountry(@PathVariable String countryCode) {
        Country country = (Country)this.countries.stream().filter(c -> c.getCode().equals(countryCode)).toArray()[0];
        this.countries.remove(country);
        return new ResponseEntity<Country>(country, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{countryCode}")
    public ResponseEntity<Country> putCountry(@PathVariable String countryCode, @RequestBody Country updateCountry) {
        Country country = (Country)this.countries.stream().filter(c -> c.getCode().equals(countryCode)).toArray()[0];
        this.countries.remove(country);
        country.setCode(updateCountry.getCode());
        country.setName(updateCountry.getName());
        this.countries.add(country);
        return new ResponseEntity<Country>(country, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/{countryCode}")
    public ResponseEntity<Country> patchCountry(@PathVariable String countryCode, @RequestBody Map<String, Object> values) {
        Country country = (Country)this.countries.stream().filter(c -> c.getCode().equals(countryCode)).toArray()[0];
        this.countries.remove(country);
        if (values.containsKey("code")) {
            country.setCode(values.get("code").toString());
        }
        if (values.containsKey("name")) {
            country.setName(values.get("name").toString());
        }
        this.countries.add(country);
        return new ResponseEntity<Country>(country, HttpStatus.OK);
    }
}
