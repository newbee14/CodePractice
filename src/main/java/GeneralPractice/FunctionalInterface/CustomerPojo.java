package GeneralPractice.FunctionalInterface;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CustomerPojo {
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;

}
