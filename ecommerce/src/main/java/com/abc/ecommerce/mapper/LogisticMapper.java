package com.abc.ecommerce.mapper;

import com.abc.ecommerce.bo.CityLinkRequest;
import com.abc.ecommerce.dto.LogisticRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class LogisticMapper {

    public CityLinkRequest toCityLinkRequest(LogisticRequestDTO logisticRequestDTO){
        CityLinkRequest cityLinkRequest = new CityLinkRequest();
        cityLinkRequest.setOrigin_country(logisticRequestDTO.getOriginCountry());
        cityLinkRequest.setOrigin_state(logisticRequestDTO.getOriginState());
        cityLinkRequest.setOrigin_postcode(logisticRequestDTO.getOriginPostcode());
        cityLinkRequest.setDestination_country(logisticRequestDTO.getDestinationCountry());
        cityLinkRequest.setDestination_state(logisticRequestDTO.getDestinationState());
        cityLinkRequest.setDestination_postcode(logisticRequestDTO.getDestinationPostcode());
        cityLinkRequest.setLength(logisticRequestDTO.getLength());
        cityLinkRequest.setWidth(logisticRequestDTO.getWidth());
        cityLinkRequest.setHeight(logisticRequestDTO.getHeight());
        cityLinkRequest.setSelected_type(logisticRequestDTO.getSelectedType());
        cityLinkRequest.setParcel_weight(logisticRequestDTO.getParcelWeight());
        return cityLinkRequest;
    }
}
