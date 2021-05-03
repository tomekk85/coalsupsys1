package pl.coalgroup.coalsupsys.services;

import pl.coalgroup.coalsupsys.model.Commodity;
import pl.coalgroup.coalsupsys.repositories.CommodityRepository;

public class CommodityServiceImpl implements CommodityService {
    CommodityRepository commodityRepository;

    public CommodityServiceImpl(CommodityRepository commodityRepository) {
        this.commodityRepository = commodityRepository;
    }

    @Override
    public void saveCommodity(Commodity commodity) {
        commodityRepository.save(commodity);
    }

    @Override
    public Commodity findCommodityById(Long id) {
        return commodityRepository.getOne(id);
    }
}
