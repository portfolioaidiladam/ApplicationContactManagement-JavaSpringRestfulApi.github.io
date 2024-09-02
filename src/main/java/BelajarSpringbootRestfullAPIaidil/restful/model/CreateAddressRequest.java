package BelajarSpringbootRestfullAPIaidil.restful.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// belajar Create Address API urutannya Model->  Repository -> Service -> Controller -> Unit Test
// ini untuk request bodynya
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateAddressRequest {

    @JsonIgnore  // agar ini tidak dikirim menggunakan body
    @NotBlank // tidak boleh kosong
    private String contactId;

    @Size(max = 200)
    private String street;

    @Size(max = 100)
    private String city;

    @Size(max = 100)
    private String province;

    @NotBlank
    @Size(max = 100)
    private String country;

    @Size(max = 10)
    private String postalCode;
}
