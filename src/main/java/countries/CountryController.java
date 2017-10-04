package countries;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;



import java.util.ArrayList;
import java.util.List;

import countries.Country;
import countries.State;

@RequestMapping("/countries")
@RestController
public class CountryController {

    private final AtomicLong counter1 = new AtomicLong();
    private final AtomicLong counter2 = new AtomicLong();

    private List<Country> countries;
    private List<State> states;

    public CountryController() {

        Country us = new Country( "US", "United States");
        Country can = new Country( "CA", "Canada");
        Country mex = new Country("MX", "Mexico");

        State va = new State(counter2.incrementAndGet(), "VA", "Virginia", us);
        State ma = new State(counter2.incrementAndGet(), "MA", "Maine", us);
        State on = new State(counter2.incrementAndGet(), "ON", "Ontario", can);
        State qu = new State(counter2.incrementAndGet(), "QU", "Quebec", can);
        State oa = new State(counter2.incrementAndGet(), "OA", "Oaxaca", mex);
        State bc = new State(counter2.incrementAndGet(), "BC", "Baja California", mex);

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
    public List<Country> getCountries() {
        return this.countries;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{countryCode}")
    public List<State> getStates(@PathVariable String countryCode){
        return this.states;
    }
}
