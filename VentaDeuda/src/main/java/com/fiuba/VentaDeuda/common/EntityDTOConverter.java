package com.fiuba.VentaDeuda.common;

import com.fiuba.VentaDeuda.DTO.Deuda.DeudaRequest;
import com.fiuba.VentaDeuda.DTO.Deuda.DeudaResponse;
import com.fiuba.VentaDeuda.Domain.Deuda;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityDTOConverter {

    @Autowired
    private ModelMapper modelMapper;

    public DeudaResponse convertDeudaToDTO(Deuda deuda){
        return modelMapper.map(deuda,DeudaResponse.class);
    }

    public Deuda convertDTOToDeuda(DeudaRequest deudaRequest){
        return modelMapper.map(deudaRequest,Deuda.class);
    }

    public List<DeudaResponse> convertDeudasToDTO(List<Deuda> deudas){
        return deudas.stream().map(deuda -> convertDeudaToDTO(deuda)).collect(Collectors.toList());
    }
}
