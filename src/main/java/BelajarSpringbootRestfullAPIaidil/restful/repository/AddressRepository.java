package BelajarSpringbootRestfullAPIaidil.restful.repository;

import BelajarSpringbootRestfullAPIaidil.restful.entity.Address;
import BelajarSpringbootRestfullAPIaidil.restful.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

// belajar Create Address API urutannya Model->  Repository -> Service -> Controller -> Unit Test
// repository akan memanggil entity dari class JpaRepository
@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
    // belajar Get Address API urutannya Service -> Repository -> Controller -> Unit Test
    Optional<Address> findFirstByContactAndId(Contact contact, String id);
    // belajar List Address API urutannya Service -> Repository -> Controller -> Unit Test
    List<Address> findAllByContact(Contact contact);
}
