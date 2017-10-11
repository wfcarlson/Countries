package countries;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collection;

import countries.Country;
import countries.State;

@RequestMapping("/states")
@RestController
public class StateController {

    private Collection<State> states;

    public StateController() {

        Country us = new Country("US", "United States");
        Country can = new Country("CA", "Canada");
        Country mex = new Country("MX", "Mexico");

        State va = new State("VA", "Virginia", us);
        State ma = new State("MA", "Maine", us);
        State on = new State("ON", "Ontario", can);
        State qu = new State("QU", "Quebec", can);
        State oa = new State("OA", "Oaxaca", mex);
        State bc = new State("BC", "Baja California", mex);

        this.states = new ArrayList<State>(6);

        states.add(va);
        states.add(ma);
        states.add(on);
        states.add(qu);
        states.add(oa);
        states.add(bc);

    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<State> getStates() {
        return this.states;
    }


}
