package de.hfu;


import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ResidentRepositoryStub implements ResidentRepository {

    private ArrayList<Resident> residents = new ArrayList<>();

Resident Larry, Manuela, Maryjane,Mathias, Leon;

public ResidentRepositoryStub() {
    residents.add(Larry = new Resident("Larry", "Bilson", "Glendale Avenue 2", "Glendale", new Date(1943 - 1900, 10, 17)));
    residents.add(Maryjane = new Resident("Maryjane", "Bilson", "Glendale Avenue 2", "Glendale", new Date(1947 - 1900, 1, 4)));
    residents.add(Manuela = new Resident("Manuela", "Burger", "Pomenade 11", "Gerolzhofen", new Date(1992 - 1900, 2, 3)));
    residents.add(Mathias = new Resident("Mathias", "Burger", "Pomenade 11", "Gerolzhofen", new Date(1989 - 1900, 6, 23)));
    residents.add(Leon = new Resident("Leon", "Gottschalk", "Flughafenstrasse 18", "Gemnath", new Date(1978 - 1900, 4, 11)));
    residents.add(new Resident("Leon", "Gottschalk", "Flughafenstrasse 18", "Gemnath", new Date(1978 - 1900, 4, 11)));
}

public List<Resident> getResidents(){
    return residents;
}


}




