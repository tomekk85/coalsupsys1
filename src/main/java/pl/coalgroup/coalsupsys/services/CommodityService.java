package pl.coalgroup.coalsupsys.services;

import org.springframework.stereotype.Service;
import pl.coalgroup.coalsupsys.model.Commodity;
import pl.coalgroup.coalsupsys.repositories.CommodityRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CommodityService implements ServiceInterface {
    CommodityRepository commodityRepository;

    public CommodityService(CommodityRepository commodityRepository) {
        this.commodityRepository = commodityRepository;
    }

    @Override
    public Commodity save(Object commodity) {
        commodityRepository.save((Commodity) commodity);
        return (Commodity) commodity;
    }

    @Override
    public Commodity findById(Long id) {
        return commodityRepository.findById(id).get();
    }



    @Override
    public List<Commodity> findAll() {
        return commodityRepository.findAll();
    }

    @Override
    public Commodity delete(Long id) {
        Commodity commodityToRemove = commodityRepository.findById(id).get();
        commodityRepository.delete(commodityToRemove);
        return commodityToRemove;
    }

    @Override
    public void update(Object commodity, Long id) {
        if(!commodityRepository.existsById(id)){
            throw new NoSuchElementException();
        } else {
            Commodity updateCommodity =(Commodity) commodity;
            updateCommodity.setId(id);
            commodityRepository.save(updateCommodity);
        }
    }
}
