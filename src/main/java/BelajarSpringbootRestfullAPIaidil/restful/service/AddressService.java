package BelajarSpringbootRestfullAPIaidil.restful.service;

import BelajarSpringbootRestfullAPIaidil.restful.entity.Address;
import BelajarSpringbootRestfullAPIaidil.restful.entity.Contact;
import BelajarSpringbootRestfullAPIaidil.restful.entity.User;
import BelajarSpringbootRestfullAPIaidil.restful.model.AddressResponse;
import BelajarSpringbootRestfullAPIaidil.restful.model.CreateAddressRequest;
import BelajarSpringbootRestfullAPIaidil.restful.model.UpdateAddressRequest;
import BelajarSpringbootRestfullAPIaidil.restful.repository.AddressRepository;
import BelajarSpringbootRestfullAPIaidil.restful.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.UUID;

@Service
public class AddressService {
    // belajar Create Address API urutannya Model->  Repository -> Service -> Controller -> Unit Test
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public AddressResponse create(User user, CreateAddressRequest request) {
        validationService.validate(request);
        // cek dulu kontactnya ada atau tidak
        Contact contact = contactRepository.findFirstByUserAndId(user, request.getContactId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact is not found"));

        Address address = new Address();
        address.setId(UUID.randomUUID().toString());
        address.setContact(contact);
        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setProvince(request.getProvince());
        address.setCountry(request.getCountry());
        address.setPostalCode(request.getPostalCode());

        addressRepository.save(address);

        return toAddressResponse(address);
    }
    // belajar Create Address API urutannya Model->  Repository -> Service -> Controller -> Unit Test
    private AddressResponse toAddressResponse(Address address) {
        return AddressResponse.builder()
                .id(address.getId())
                .street(address.getStreet())
                .city(address.getCity())
                .province(address.getProvince())
                .country(address.getCountry())
                .postalCode(address.getPostalCode())
                .build();
    }


    // belajar Get Address API urutannya Service -> Repository -> Controller -> Unit Test
    @Transactional(readOnly = true)
    public AddressResponse get(User user, String contactId, String addressId) {
        // bikinnya di repositorynya dulu findFirstByContactAndId
        Contact contact = contactRepository.findFirstByUserAndId(user, contactId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact is not found"));

        Address address = addressRepository.findFirstByContactAndId(contact, addressId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address is not found"));

        return toAddressResponse(address);
    }
    // belajar update Address Api urutannya dari model -> service -> controller -> unit test
    @Transactional
    public AddressResponse update(User user, UpdateAddressRequest request){
        validationService.validate(request);

        Contact contact = contactRepository.findFirstByUserAndId(user, request.getContactId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact is not found"));

        Address address = addressRepository.findFirstByContactAndId(contact, request.getAddressId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address is not found"));

        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setProvince(request.getProvince());
        address.setCountry(request.getCountry());
        address.setPostalCode(request.getPostalCode());
        addressRepository.save(address);

        return toAddressResponse(address);
    }
    // belajar Remove Address API urutannya Service -> Controller -> Unit Test
    @Transactional
    public void remove(User user, String contactId, String addressId){
        Contact contact = contactRepository.findFirstByUserAndId(user, contactId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact is not found"));

        Address address = addressRepository.findFirstByContactAndId(contact, addressId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address is not found"));

        addressRepository.delete(address);
    }
    // belajar List Address API urutannya Service -> Repository -> Controller -> Unit Test
    @Transactional(readOnly = true)
    public List<AddressResponse> list(User user, String contactId){
        // bakal manggil class findFirstByUserAndId ke repository
        Contact contact = contactRepository.findFirstByUserAndId(user, contactId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact is not found"));

        List<Address> addresses = addressRepository.findAllByContact(contact);
        return addresses.stream().map(this::toAddressResponse).toList();
    }
}
