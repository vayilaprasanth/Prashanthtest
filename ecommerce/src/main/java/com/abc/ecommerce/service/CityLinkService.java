package com.abc.ecommerce.service;


import com.abc.ecommerce.bo.CityLinkRequest;
import com.abc.ecommerce.dto.CityLinkResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Service
public class CityLinkService {

    @Autowired
    private RestTemplate restTemplate;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final String CITY_LINK_URL = "https://www.citylinkexpress.com/wp-json/wp/v2/getShippingRate";

    public CityLinkResponse cityLinkLogisticRestCall(CityLinkRequest cityLinkRequest) {
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<CityLinkRequest> request = new HttpEntity<CityLinkRequest>(cityLinkRequest,headers);
            logger.info("Performing the rest call to city link API ");
            return restTemplate.postForEntity(CITY_LINK_URL, request , CityLinkResponse.class ).getBody();
        }catch (HttpStatusCodeException e){
            logger.error("Error Response from cityLink with status: {} and error: {} ", e.getStatusCode(), e.getResponseBodyAsString());
            logger.trace(e.getResponseBodyAsString());
            CityLinkResponse cityLinkResponse = new CityLinkResponse();
            cityLinkResponse.setError("Http Status Code: "+ e.getStatusCode()+" error: " +e.getResponseBodyAsString());
            return cityLinkResponse;
        }
    }
}
