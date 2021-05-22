package pl.coalgroup.coalsupsys.services;

import org.springframework.stereotype.Service;
import pl.coalgroup.coalsupsys.model.GoodsReceipt;
import pl.coalgroup.coalsupsys.repositories.GoodsReceiptRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GoodsReceiptService implements  ServiceInterface{
    GoodsReceiptRepository goodsReceiptRepository;

    public GoodsReceiptService(GoodsReceiptRepository goodsReceiptRepository) {
        this.goodsReceiptRepository = goodsReceiptRepository;
    }

    @Override
    public GoodsReceipt save(Object o) {
        GoodsReceipt goodsReceipt = (GoodsReceipt) o;
        goodsReceiptRepository.save(goodsReceipt);
        return goodsReceipt;
    }

    @Override
    public GoodsReceipt findById(Long id) {
        return goodsReceiptRepository.findById(id).get();
    }

    @Override
    public GoodsReceipt delete(Long id) {
        GoodsReceipt goodsReceipt = goodsReceiptRepository.findById(id).get();
        goodsReceiptRepository.delete(goodsReceipt);
        return goodsReceipt;
    }

    @Override
    public void update(Object t, Long id) {
        if(!goodsReceiptRepository.existsById(id)){
            throw new NoSuchElementException();
        } else {
            GoodsReceipt updateGoodReceipt = (GoodsReceipt) t;
            updateGoodReceipt.setId(id);
            goodsReceiptRepository.save(updateGoodReceipt);
        }
    }

    @Override
    public List findAll() {
        return goodsReceiptRepository.findAll();
    }
}
