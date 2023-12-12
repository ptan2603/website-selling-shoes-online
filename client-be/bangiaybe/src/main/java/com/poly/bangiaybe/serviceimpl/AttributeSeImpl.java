package com.poly.bangiaybe.serviceimpl;

import com.poly.bangiaybe.constant.*;
import com.poly.bangiaybe.entity.Attribute;
import com.poly.bangiaybe.exception.AppException;
import com.poly.bangiaybe.repository.*;
import com.poly.bangiaybe.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AttributeSeImpl implements AttributeService {
	@Autowired
    AttributeRepo attributeRepo;
	
	@Override
    public Attribute findById(Long id) {
        Optional<Attribute> optionalAttribute = attributeRepo.findById(id);
        if(!optionalAttribute.isPresent()){
            throw new AppException(AttributeConst.ATTRIBUTE_MSG_ERROR_NOT_EXIST);
        }
        return optionalAttribute.get();
    }

	
    @Override
    public List<Attribute> findAll() {
        return attributeRepo.findAll();
    }
    
    @Override
    public Attribute save(Attribute attribute) {
        return attributeRepo.save(attribute);
    }
    
    @Override
    public Attribute getByProductIdAndSize(Long productId, Integer size) {
        return attributeRepo.findByProduct_IdAndSize(productId, size);
    }


    @Override
	public List<Attribute> cacheAttribute(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public Boolean isValidCart(Long id, Integer quantity) {
        Attribute attribute = findById(id);
        if(quantity > attribute.getStock()){
            throw new AppException(AttributeConst.ATTRIBUTE_MSG_ERROR_NOT_ENOUGH_STOCK);
        }
        return Boolean.TRUE;
    }


	@Override
	public List<Attribute> backAttribute(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
