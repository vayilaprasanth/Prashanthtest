package com.abc.ecommerce.service;


import com.abc.ecommerce.bo.CityLinkRequest;
import com.abc.ecommerce.dto.CityLinkData;
import com.abc.ecommerce.dto.CityLinkReq;
import com.abc.ecommerce.dto.CityLinkResponse;
import com.abc.ecommerce.dto.LogisticResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
public class CitLinkServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private CityLinkService cityLinkService = new CityLinkService();

    @Test
    public void givenMockingIsDoneByMockito_whenGetIsCalled_shouldReturnMockedObject() {

        CityLinkResponse cityLinkResponse = new CityLinkResponse();
        CityLinkReq req = new CityLinkReq();
        CityLinkData data = new CityLinkData();
        data.setRate(231.54);
        req.setData(data);
        cityLinkResponse.setReq(req);

        CityLinkRequest cityLinkRequest = getCityLinkRequest();

        Mockito.when(restTemplate.postForEntity(
                        ArgumentMatchers.eq("https://www.citylinkexpress.com/wp-json/wp/v2/getShippingRate"),
                        ArgumentMatchers.any(HttpEntity.class),
                        ArgumentMatchers.eq(CityLinkResponse.class)))
                .thenReturn(new ResponseEntity<>(cityLinkResponse, HttpStatus.OK));

        CityLinkResponse response = cityLinkService.cityLinkLogisticRestCall(cityLinkRequest);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(231.54, response.getReq().getData().getRate());
    }

    private static CityLinkRequest getCityLinkRequest() {
        CityLinkRequest cityLinkRequest = new CityLinkRequest();
        cityLinkRequest.setHeight(1);
        cityLinkRequest.setLength(1);
        cityLinkRequest.setDestination_country("IN");
        cityLinkRequest.setOrigin_country("MY");
        cityLinkRequest.setWidth(1);
        cityLinkRequest.setDestination_postcode("50000");
        cityLinkRequest.setOrigin_postcode("508213");
        cityLinkRequest.setOrigin_state("KL");
        cityLinkRequest.setDestination_state("Mayak");
        cityLinkRequest.setSelected_type(1);
        return cityLinkRequest;
    }
}
