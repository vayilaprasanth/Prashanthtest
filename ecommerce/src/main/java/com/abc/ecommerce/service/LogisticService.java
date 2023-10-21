package com.abc.ecommerce.service;

import com.abc.ecommerce.bo.CityLinkRequest;
import com.abc.ecommerce.dto.CityLinkData;
import com.abc.ecommerce.dto.CityLinkResponse;
import com.abc.ecommerce.dto.LogisticData;
import com.abc.ecommerce.dto.LogisticRequestDTO;
import com.abc.ecommerce.dto.LogisticResponseDTO;
import com.abc.ecommerce.entity.CachedLogistic;
import com.abc.ecommerce.mapper.LogisticMapper;
import com.abc.ecommerce.repository.LogisticRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogisticService {

    public static final String CITYLINK = "citylink";

    @Autowired
    private LogisticMapper logisticMapper;

    @Autowired
    private CityLinkService cityLinkService;

    @Autowired
    private LogisticRepository logisticRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public LogisticResponseDTO queryLogisticInfo(LogisticRequestDTO logisticRequestDTO) {
        //transform dto to business object
        logger.info("queryLogisticInfo source country: {} and destination country: {}", logisticRequestDTO.getOriginCountry(), logisticRequestDTO.getDestinationCountry());
        CityLinkRequest cityLinkRequest = logisticMapper.toCityLinkRequest(logisticRequestDTO);
        String hash = logisticRequestHash(cityLinkRequest);
        List<CachedLogistic> list = logisticRepository.findByHashKey(hash);
        if(!CollectionUtils.isEmpty(list)){
            logger.info("Request available in cache fetching the result from cache");
            return getCachedLogisticResponseDTO(list);
        }else{
            logger.info("Cache miss Rest has to be performed");
            List<CachedLogistic> cachedLogisticList = new ArrayList<>();
            cachedLogisticList.add(cityLinkLogisticQuery(cityLinkRequest, hash));
            return getCachedLogisticResponseDTO(cachedLogisticList);
        }

    }

    private CachedLogistic cityLinkLogisticQuery(CityLinkRequest cityLinkRequest, String hash) {
        CityLinkResponse cityLinkResponse = cityLinkService.cityLinkLogisticRestCall(cityLinkRequest);
        CityLinkData cityLinkData = cityLinkResponse != null && cityLinkResponse.getReq() != null
                                    && cityLinkResponse.getReq().getData() != null? cityLinkResponse.getReq().getData() : null;

        CachedLogistic cachedLogistic = new CachedLogistic();
        cachedLogistic.setCourier(CITYLINK);
        cachedLogistic.setError(cityLinkResponse.getError());
        if(cityLinkData != null){
            cachedLogistic.setRate(cityLinkData.getRate());
            cachedLogistic.setHttpStatus(cityLinkResponse.getReq().getStatus());
            cachedLogistic.setHash(hash);
            logger.info("saving details to database");
            return logisticRepository.save(cachedLogistic);
        }else{
            return cachedLogistic;
        }
    }



    private static LogisticResponseDTO getCachedLogisticResponseDTO(List<CachedLogistic> list) {
        LogisticResponseDTO dto = new LogisticResponseDTO();
        List<LogisticData> logisticData =  list.stream().map(cl-> getLogisticData(cl)).collect(Collectors.toList());
        dto.setData(logisticData);
        return dto;
    }

    private static LogisticData getLogisticData(CachedLogistic cl) {
        LogisticData data = new LogisticData();
        data.setCourier(cl.getCourier());
        data.setError(cl.getError());
        data.setRate(cl.getRate());
        data.setHttpStatus(cl.getHttpStatus());
        return data;
    }

    private static String logisticRequestHash(CityLinkRequest cityLinkRequest) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String req = objectMapper.writeValueAsString(cityLinkRequest);
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(req.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (JsonProcessingException e) {
            System.out.println("Error converting to json:"+e.getMessage());
            return null;
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace(); // Handle the exception
            return null;
        }
    }


}
