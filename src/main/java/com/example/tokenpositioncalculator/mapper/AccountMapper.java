package com.example.tokenpositioncalculator.mapper;


import com.example.tokenpositioncalculator.dto.AccountDTO;
import com.example.tokenpositioncalculator.entity.Account;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
   private final ModelMapper modelMapper;

    public AccountMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public Account convertToEntity(AccountDTO dto){ return modelMapper.map(dto,Account.class);}

    public AccountDTO convertToDto(Account entity){
        return modelMapper.map(entity,AccountDTO.class);
}
}