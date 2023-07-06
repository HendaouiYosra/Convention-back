package tn.dksoft.convention.service;

import tn.dksoft.convention.entity.Convention;
import java.util.List;

public interface  ConventionService {

    Convention saveConvention(Convention convention);

    List<Convention> fetchAllConventions();


    Convention updateConventionById(Long id, Convention convention);

    String deleteDepartmentById(Long id);
}
