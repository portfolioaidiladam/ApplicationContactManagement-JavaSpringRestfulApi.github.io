package BelajarSpringbootRestfullAPIaidil.restful.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

// membuat address Entity
// buat dulu table addresnya di database kemudian javanya disini
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    private String id;

    private String street;

    private String city;

    private String province;

    private String country;
    // karena namanya beda kita tambahkan @ Coloumn
    @Column(name = "postal_code")
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;

    @OneToMany (mappedBy = "contact")
    private List<Address> addresses;

}
