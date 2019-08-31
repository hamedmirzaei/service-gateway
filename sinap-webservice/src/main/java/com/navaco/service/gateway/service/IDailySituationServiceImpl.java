/*
package com.navaco.service.gateway.service;

import com.navaco.service.gateway.model.DailySituation;
import com.navaco.service.gateway.model.IDailySituationServiceInsertSinapExceptionFaultFaultMessage;
import com.navaco.service.gateway.repository.DailySituationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("iDailySituationServiceImpl")
public class IDailySituationServiceImpl implements IDailySituationService {

    private DailySituationRepository dailySituationRepository;

    @Autowired
    IDailySituationServiceImpl(DailySituationRepository dailySituationRepository) {
        this.dailySituationRepository = dailySituationRepository;
    }

    @Override
    public String insert(DailySituation dailySituation) throws IDailySituationServiceInsertSinapExceptionFaultFaultMessage {
        return "Here it is";
    }

    @Override
    public DailySituation getFirst() {
        return dailySituationRepository.getFirstDailySituation();
    }
}
*/
