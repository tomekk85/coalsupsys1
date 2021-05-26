package pl.coalgroup.coalsupsys.controllers;

import org.springframework.web.bind.annotation.*;
import pl.coalgroup.coalsupsys.model.Stock;
import pl.coalgroup.coalsupsys.services.StockService;

import java.util.List;

@RestController
@RequestMapping(StockController.BASE_URL)
@CrossOrigin("http://localhost:4200")

public class StockController {
    public static final String BASE_URL = "api/v1/stock";
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public List<Stock> getWholeStock(){
        return stockService.findAll();
    }

    @GetMapping("/{id}")
    Stock getStockItemByID(@PathVariable long id){
        return stockService.findById(id);
    }
}
