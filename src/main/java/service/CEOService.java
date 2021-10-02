package service;

import base.service.BaseService;
import domain.CEO;

public interface CEOService extends BaseService<CEO, Long> {

    CEO checkCEO(long ceoCode);
}
