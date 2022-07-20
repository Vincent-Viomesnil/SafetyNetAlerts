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
        FireAddressDTO fireAddressDTO1 = new FireAddressDTO();
        fireAddressDTO1.setLastName("firstname");
        fireAddressDTO1.setLastName("lastname");
        fireAddressDTO1.setAge(15);
        fireAddressDTO1.setAllergies(allergies);
        fireAddressDTO1.setMedications(medications);

        assertNotNull(fireAddressDTO1);
        assertThat(fireAddressDTO.toString()).isEqualTo("FireAddressDTO(firstName=firstname, lastName=lastname, age=20, medications=[doliprane:1000mg], allergies=[lactose])");
    }

    @Test
    public void HomeByStationNumberDTOTest(){
        List<String> allergies = List.of("lactose");
        List<String> medications = List.of("doliprane:1000mg");
        HomeByStationNumberDTO homeByStationNumberDTO = new HomeByStationNumberDTO("firstname","06123456789",20,medications,allergies);

        HomeByStationNumberDTO homeByStationNumberDTO1 = new HomeByStationNumberDTO();
        homeByStationNumberDTO1.setAge(15);
        homeByStationNumberDTO1.setLastName("lastname");
        homeByStationNumberDTO1.setAllergies(allergies);
        homeByStationNumberDTO1.setMedications(medications);

        assertNotNull(homeByStationNumberDTO1);
        assertThat(homeByStationNumberDTO.toString()).isEqualTo("HomeByStationNumberDTO(lastName=firstname, phone=06123456789, age=20, medications=[doliprane:1000mg], allergies=[lactose])");
    }

    @Test
    public void PersonByStationNumberDTOTest(){
        PersonByStationNumberDTO personByStationNumberDTO = new PersonByStationNumberDTO("firstname","lastname","address","06123456789");
        PersonByStationNumberDTO personByStationNumberDTO1 = new PersonByStationNumberDTO();
        personByStationNumberDTO1.setFirstName("first");
        personByStationNumberDTO1.setLastName("last");
        personByStationNumberDTO1.setAddress("add");
        personByStationNumberDTO1.setPhone("0123456789");

        assertNotNull(personByStationNumberDTO1);
        assertThat(personByStationNumberDTO.toString()).isEqualTo("PersonByStationNumberDTO(firstName=firstname, lastName=lastname, address=address, phone=06123456789)");

    }
    @Test
    public void PersonInfoDTOTest(){
        List<String> allergies = List.of("lactose");
        List<String> medications = List.of("doliprane:1000mg");
        PersonInfoDTO personInfoDTO = new PersonInfoDTO("firstname","lastname","address",20,"email", medications, allergies);
        PersonInfoDTO personInfoDTO1 = new PersonInfoDTO();
        personInfoDTO1.setMail("mail.com");
        personInfoDTO1.setAge(10);
        personInfoDTO1.setFirstName("first");
        personInfoDTO1.setLastName("last");
        personInfoDTO1.setAddress("add");
        personInfoDTO1.setMedications(medications);
        personInfoDTO1.setAllergies(allergies);

        assertNotNull(personInfoDTO1);
        assertThat(personInfoDTO.toString()).isEqualTo("PersonInfoDTO(firstName=firstname, lastName=lastname, address=address, age=20, mail=email, medications=[doliprane:1000mg], allergies=[lactose])");
    }
}

