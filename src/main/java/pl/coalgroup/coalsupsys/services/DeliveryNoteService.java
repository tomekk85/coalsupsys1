package pl.coalgroup.coalsupsys.services;

import org.springframework.stereotype.Service;
import pl.coalgroup.coalsupsys.model.DeliveryNote;
import pl.coalgroup.coalsupsys.repositories.DeliveryNoteRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DeliveryNoteService implements ServiceInterface{
    private final DeliveryNoteRepository deliveryNoteRepository;

    public DeliveryNoteService(DeliveryNoteRepository deliveryNoteRepository) {
        this.deliveryNoteRepository = deliveryNoteRepository;
    }

    @Override
    public DeliveryNote save(Object o) {
        DeliveryNote deliveryNote = (DeliveryNote) o;
        deliveryNoteRepository.save(deliveryNote);
        return deliveryNote;
    }

    @Override
    public DeliveryNote findById(Long id) {
        return deliveryNoteRepository.findById(id).get();
    }

    @Override
    public DeliveryNote delete(Long id) {
        DeliveryNote deliveryNote = deliveryNoteRepository.findById(id).get();
        deliveryNoteRepository.delete(deliveryNote);
        return deliveryNote;
    }

    @Override
    public void update(Object t, Long id) {
        if(!deliveryNoteRepository.existsById(id)){
            throw new NoSuchElementException();
        } else {
            DeliveryNote updateDeliveryNote = (DeliveryNote) t;
            updateDeliveryNote.setId(id);
            deliveryNoteRepository.save(updateDeliveryNote);
        }

    }

    @Override
    public List findAll() {
        return deliveryNoteRepository.findAll();
    }
}
