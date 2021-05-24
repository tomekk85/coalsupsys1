package pl.coalgroup.coalsupsys.services;

import org.springframework.stereotype.Service;
import pl.coalgroup.coalsupsys.model.GoodsReceipt;
import pl.coalgroup.coalsupsys.model.GoodsReceiptRegister;
import pl.coalgroup.coalsupsys.model.Stock;
import pl.coalgroup.coalsupsys.repositories.GRRegisterRepository;
import pl.coalgroup.coalsupsys.repositories.GoodsReceiptRepository;
import pl.coalgroup.coalsupsys.repositories.StockRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GoodsReceiptService implements  ServiceInterface{
    private final GoodsReceiptRepository goodsReceiptRepository;
    private final GRRegisterRepository grRegisterRepository;
    private final StockRepository stockRepository;

    public GoodsReceiptService(GoodsReceiptRepository goodsReceiptRepository, GRRegisterRepository grRegisterRepository, StockRepository stockRepository) {
        this.goodsReceiptRepository = goodsReceiptRepository;
        this.grRegisterRepository = grRegisterRepository;
        this.stockRepository = stockRepository;
    }

    @Override
    public GoodsReceipt save(Object o) {
        GoodsReceipt goodsReceipt = (GoodsReceipt) o;
        goodsReceiptRepository.save(goodsReceipt);

        //Stock
        for (GoodsReceipt.Item item: goodsReceipt.getItems()){
            Stock stock = new Stock();
            stock.setCommodity(item.getCommodity());
            stock.setAmount(item.getAmount());

            List<Stock> list = stockRepository.findAll();

            for(Stock element : list){
                if(stock.getCommodity().getId() == element.getCommodity().getId()){
                    stock.setId(element.getId());
                    stock.setAmount(stock.getAmount() + element.getAmount());
                    break;
                }
            }
            stockRepository.save(stock);
        }

        //Goods Receipt Register
        GoodsReceiptRegister register = new GoodsReceiptRegister();
        register.setGoodsReceipt(goodsReceipt);

        grRegisterRepository.save(register);

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
