package tn.dksoft.convention.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.dksoft.convention.entity.Convention;
import tn.dksoft.convention.repository.ConventionRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ConventionServiceImpl implements ConventionService{
    @Autowired
    private ConventionRepository conventionRepository;
    @Override
    public Convention saveConvention(Convention convention){
        return conventionRepository.save(convention);
    }
    @Override
    public List<Convention> fetchAllConventions() {
        List<Convention> allConventions = conventionRepository.findAll();
        return allConventions;
    }

    @Override
    public Convention getConventionById(Long id) {
        Optional<Convention> convention = conventionRepository.findById(id);
        if (convention.isPresent()) {
            return convention.get();
        }
        return null;
    }

    @Override
    public Convention updateConventionById(Long id, Convention convention) {
        Optional<Convention> convention1 = conventionRepository.findById(id);

        if (convention1.isPresent()) {
            Convention originalConvention = convention1.get();

            if (Objects.nonNull(convention.getSociete1()) && !"".equalsIgnoreCase(convention.getSociete1())) {
                originalConvention.setSociete1(convention.getSociete1());
            }
            if (Objects.nonNull(convention.getSociete2()) && !"".equalsIgnoreCase(convention.getSociete2())) {
                originalConvention.setSociete2(convention.getSociete2());
            }


            return conventionRepository.save(originalConvention);
        }
        return null;
    }

    @Override
    public String deleteDepartmentById(Long id) {
        if (conventionRepository.findById(id).isPresent()) {
            conventionRepository.deleteById(id);
            return "Convention deleted successfully";
        }
        return "No such convention in the database";
    }

}
