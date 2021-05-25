package pl.coalgroup.coalsupsys.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.coalgroup.coalsupsys.model.Commodity;
import pl.coalgroup.coalsupsys.services.CommodityService;

import java.util.List;

@RestController
@RequestMapping(CommodityController.BASE_URL)

public class CommodityController {
    public static final String BASE_URL = "api/v1/commodities";
    private final CommodityService commodityService;

    public CommodityController(CommodityService commodityService) {
        this.commodityService = commodityService;
    }

    @GetMapping
    public List<Commodity> getAllCommodities(){
        return commodityService.findAll();
    }

    @GetMapping("/{id}")
    public Commodity getCommodityById(@PathVariable long id){
        return commodityService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Commodity saveCommodity(@RequestBody Commodity commodity){
        return commodityService.save(commodity);
    }

    @PutMapping("/{id}")
    public void updateCommodityById(@RequestBody Commodity commodity,
                                    @PathVariable Long id){
        commodityService.update(commodity, id);
    }

    @DeleteMapping("/{id}")
    public Commodity deleteCommodity(@PathVariable Long id){
        return commodityService.delete(id);
    }
}
