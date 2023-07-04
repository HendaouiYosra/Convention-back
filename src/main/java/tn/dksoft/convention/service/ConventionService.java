package tn.dksoft.convention.service;

import tn.dksoft.convention.entity.Convention;
import java.util.List;

public interface ConventionService {

    Convention saveConvention(Convention employee);

    List<Convention> fetchAllConventions();

    Convention getConventionById(Long id);

    Convention updateConventionById(Long id, Convention employee);

    String deleteDepartmentById(Long id);
}
