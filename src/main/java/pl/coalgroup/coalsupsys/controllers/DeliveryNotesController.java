package pl.coalgroup.coalsupsys.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.coalgroup.coalsupsys.model.DeliveryNote;
import pl.coalgroup.coalsupsys.services.DeliveryNoteService;

import java.util.List;

@RestController
@RequestMapping(DeliveryNotesController.BASE_URL)
public class DeliveryNotesController {
    public static final String BASE_URL = "api/v1/delivery_notes";
    private final DeliveryNoteService deliveryNoteService;

    public DeliveryNotesController(DeliveryNoteService deliveryNoteService) {
        this.deliveryNoteService = deliveryNoteService;
    }

    @GetMapping
    public List<DeliveryNote> getAllDeliveryNotes(){
        return deliveryNoteService.findAll();
    }

    @GetMapping("/{id}")
    public DeliveryNote getDeliveryNoteById(@PathVariable long id){
        return deliveryNoteService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryNote saveDeliveryNote(@RequestBody DeliveryNote deliveryNote){
        return deliveryNoteService.save(deliveryNote);
    }

    @PutMapping("/{id}")
    public void updateDeliveryNoteById(@RequestBody DeliveryNote deliveryNote,
                                       @PathVariable long id){
        deliveryNoteService.update(deliveryNote, id);
    }

    @DeleteMapping("/{id}")
    public DeliveryNote deleteDeliveryNote(@PathVariable long id){
        return deliveryNoteService.delete(id);
    }
}
