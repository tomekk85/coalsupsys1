package pl.coalgroup.coalsupsys.services;

import pl.coalgroup.coalsupsys.model.Commodity;

public interface CommodityService {
    void saveCommodity(Commodity commodity);
    Commodity findCommodityById(Long id);
}
