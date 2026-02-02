package practice.layerPractice.sql.sqlEntity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
public class AddressSQL {

    private String city;
    private String street;
    private String zipcode;
}
