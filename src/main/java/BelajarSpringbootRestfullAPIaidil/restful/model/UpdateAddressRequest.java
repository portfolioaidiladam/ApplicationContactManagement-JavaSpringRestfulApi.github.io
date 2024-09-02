package BelajarSpringbootRestfullAPIaidil.restful.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// belajar update Address Api urutannya dari model -> service -> controller -> unit test
// ini untuk request bodynya
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAddressRequest {

    @JsonIgnore
    @NotBlank
    private String contactId;

    @JsonIgnore
    @NotBlank
    private String addressId;

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
