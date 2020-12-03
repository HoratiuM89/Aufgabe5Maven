package de.hfu;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;
import org.easymock.EasyMock;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResidentRepositoryTest {

    @Test
    public void getFilteredResidentsList() {
        BaseResidentService service = new BaseResidentService();
        ResidentRepositoryStub stub = new ResidentRepositoryStub();

        service.setResidentRepository(stub);
        //Vorname Test
        List<Resident> ListResidentM = service.getFilteredResidentsList(new Resident("M*", "*", "*", "*", null));
        assertThat(ListResidentM, hasItems(stub.Manuela, stub.Maryjane, stub.Mathias));
        //Nachname Test
        ListResidentM = service.getFilteredResidentsList(new Resident("*", "B*", "*", "*", null));
        assertThat(ListResidentM, hasItems(stub.Manuela, stub.Maryjane, stub.Mathias, stub.Larry));
        //Strassenname Test
        ListResidentM = service.getFilteredResidentsList(new Resident("*", "*", "*", "G*", null));
        assertThat(ListResidentM, hasItems(stub.Manuela, stub.Maryjane, stub.Mathias, stub.Maryjane, stub.Leon));
        //Stadtname Test
        ListResidentM = service.getFilteredResidentsList(new Resident("*", "*", "*", "G*", null));
        assertThat(ListResidentM, hasItems(stub.Manuela, stub.Maryjane, stub.Mathias, stub.Maryjane, stub.Leon));

    }


    @Test
    public void getUniqueResident() {
        BaseResidentService service = new BaseResidentService();
        ResidentRepositoryStub stub = new ResidentRepositoryStub();


        //unique assert equal
        service.setResidentRepository(stub);
        try {
            Resident Manuela = service.getUniqueResident(stub.Manuela);
            assertEquals(stub.Manuela, Manuela);
        } catch (ResidentServiceException e) {
            fail();
        }

        // mit wildcard für exception
        try {
            Resident Manuela = service.getUniqueResident(new Resident("*", "*", "*", "*", null));
            fail();

        } catch (ResidentServiceException e) {
        }

        // doppeltest
        try {
            Resident Manuela = service.getUniqueResident(stub.Leon);
            fail();
        } catch (ResidentServiceException e) {
        }
    }

    @Test
    public void easyMock(){

        ArrayList<Resident> residents = new ArrayList<>();

        Resident Larry, Manuela, Maryjane,Mathias, Leon;


            residents.add(Larry = new Resident("Larry", "Bilson", "Glendale Avenue 2", "Glendale", new Date(1943 - 1900, 10, 17)));
            residents.add(Maryjane = new Resident("Maryjane", "Bilson", "Glendale Avenue 2", "Glendale", new Date(1947 - 1900, 1, 4)));
            residents.add(Manuela = new Resident("Manuela", "Burger", "Pomenade 11", "Gerolzhofen", new Date(1992 - 1900, 2, 3)));
            residents.add(Mathias = new Resident("Mathias", "Burger", "Pomenade 11", "Gerolzhofen", new Date(1989 - 1900, 6, 23)));
            residents.add(Leon = new Resident("Leon", "Gottschalk", "Flughafenstrasse 18", "Gemnath", new Date(1978 - 1900, 4, 11)));
            residents.add(new Resident("Leon", "Gottschalk", "Flughafenstrasse 18", "Gemnath", new Date(1978 - 1900, 4, 11)));

            ResidentRepository repo = EasyMock.mock(ResidentRepository.class);
            EasyMock.expect(repo.getResidents()).andStubReturn(residents);
            EasyMock.replay(repo);

        BaseResidentService service = new BaseResidentService();

        service.setResidentRepository(repo);
        try {
            Resident Manuela2 = service.getUniqueResident(Manuela);
            assertEquals(Manuela2, Manuela);
        } catch (ResidentServiceException e) {
            fail();
        }

        // mit wildcard für exception
        try {
            service.getUniqueResident(new Resident("*", "*", "*", "*", null));
            fail();

        } catch (ResidentServiceException e) {
        }

        // doppeltest
        try {
            service.getUniqueResident(Leon);
            fail();
        } catch (ResidentServiceException e) {
        }
    }
}
