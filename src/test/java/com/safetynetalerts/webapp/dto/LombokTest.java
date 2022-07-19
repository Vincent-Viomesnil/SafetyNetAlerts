package com.safetynetalerts.webapp.dto;

import com.safetynetalerts.webapp.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LombokTest {

    @Test
    public void childAlertDTOTest() {

        List<Person> home = new ArrayList<>();
        ChildAlertDTO childAlertDTO = new ChildAlertDTO("firstname", "lastname", 20, home);

        ChildAlertDTO childAlertDTO2 = new ChildAlertDTO();
        childAlertDTO2.setFirstName("firstname");
        childAlertDTO2.setLastName("lastname");
        childAlertDTO2.setAge(20);
        childAlertDTO2.setHome(home);

        assertNotNull(childAlertDTO);
        assertThat(childAlertDTO2.toString()).isEqualTo("ChildAlertDTO(firstName=firstname, lastName=lastname, age=20, home=[])");
    }

    @Test
    public void fireAddressDTOTest(){
        List<String> allergies = List.of("lactose");
        List<String> medications = List.of("doliprane:1000mg");
        FireAddressDTO fireAddressDTO = new FireAddressDTO("firstname","lastname", 20, medications, allergies);

        assertNotNull(fireAddressDTO);
        assertThat(fireAddressDTO.toString()).isEqualTo("FireAddressDTO(firstName=firstname, lastName=lastname, age=20, medications=[doliprane:1000mg], allergies=[lactose])");
    }

    @Test
    public void HomeByStationNumberDTOTest(){
        List<String> allergies = List.of("lactose");
        List<String> medications = List.of("doliprane:1000mg");
        HomeByStationNumberDTO homeByStationNumberDTO = new HomeByStationNumberDTO("firstname","06123456789",20,medications,allergies);

        assertNotNull(homeByStationNumberDTO);
        assertThat(homeByStationNumberDTO.toString()).isEqualTo("HomeByStationNumberDTO(lastName=firstname, phone=06123456789, age=20, medications=[doliprane:1000mg], allergies=[lactose])");
    }

    @Test
    public void PersonByStationNumberDTOTest(){
        PersonByStationNumberDTO personByStationNumberDTO = new PersonByStationNumberDTO("firstname","lastname","address","06123456789");

        assertNotNull(personByStationNumberDTO);
        assertThat(personByStationNumberDTO.toString()).isEqualTo("PersonByStationNumberDTO(firstName=firstname, lastName=lastname, address=address, phone=06123456789)");

    }
    @Test
    public void PersonInfoDTOTest(){
        List<String> allergies = List.of("lactose");
        List<String> medications = List.of("doliprane:1000mg");
        PersonInfoDTO personInfoDTO = new PersonInfoDTO("firstname","lastname","address",20,"email", medications, allergies);

        assertNotNull(personInfoDTO);
        assertThat(personInfoDTO.toString()).isEqualTo("PersonInfoDTO(firstName=firstname, lastName=lastname, address=address, age=20, mail=email, medications=[doliprane:1000mg], allergies=[lactose])");
    }
}

