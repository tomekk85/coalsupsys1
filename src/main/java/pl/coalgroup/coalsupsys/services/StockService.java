package pl.coalgroup.coalsupsys.services;

import org.springframework.stereotype.Service;
import pl.coalgroup.coalsupsys.model.Stock;
import pl.coalgroup.coalsupsys.repositories.StockRepository;

import java.util.List;

@Service
public class StockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Stock  findById(Long id) {
        return stockRepository.findById(id).get();
    }

    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

}
