package pl.coalgroup.coalsupsys.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.coalgroup.coalsupsys.model.GoodsReceipt;
import pl.coalgroup.coalsupsys.services.GoodsReceiptService;

import java.util.List;

@RestController
@RequestMapping(GoodsReceiptController.BASE_URL)
@CrossOrigin("localhost:4200")

public class GoodsReceiptController {
    public static final String BASE_URL = "api/v1/goods_receipt";
    private final GoodsReceiptService goodsReceiptService;

    public GoodsReceiptController(GoodsReceiptService goodsReceiptService) {
        this.goodsReceiptService = goodsReceiptService;
    }

    @GetMapping
    public List<GoodsReceipt> getAllGoodsReceipts(){return goodsReceiptService.findAll();}

    @GetMapping("/{id}")
    public GoodsReceipt getGoodsReceiptByID(@PathVariable long id){

        return goodsReceiptService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GoodsReceipt saveGoodsReceipt(@RequestBody GoodsReceipt goodsReceipt){
        return goodsReceiptService.save(goodsReceipt);
    }

    @PutMapping("/{id}")
    public void updateGoodsReceiptById(@RequestBody GoodsReceipt goodsReceipt,
                                       @PathVariable long id){
        goodsReceiptService.update(goodsReceipt, id);
    }

    @DeleteMapping("/{id}")
    public GoodsReceipt deledeGoodsReceipt(@PathVariable long id){
        return goodsReceiptService.delete(id);
    }
}
