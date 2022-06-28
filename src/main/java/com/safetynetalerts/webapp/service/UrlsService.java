package com.safetynetalerts.webapp.service;

import com.safetynetalerts.webapp.dao.UrlsDAO;
import com.safetynetalerts.webapp.dto.ChildAlertListByAddressDTO;
import com.safetynetalerts.webapp.model.ChildAlertDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UrlsService {

    UrlsDAO urlsDAO = new UrlsDAO();

    public List<ChildAlertDTO> getChildListByAddress(@PathVariable String address) {
        return urlsDAO.getChildListByAddress(address);
    }

}
