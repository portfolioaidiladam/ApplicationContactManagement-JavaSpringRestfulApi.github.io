package BelajarSpringbootRestfullAPIaidil.restful.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// belajar Create Address API urutannya Model->  Repository -> Service -> Controller -> Unit Test
// ini  untuk response bodynya
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {

    private String id;

    private String street;

    private String city;

    private String province;

    private String country;

    private String postalCode;
}
