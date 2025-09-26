package cohort_65.java.forumservice.person.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonUpdateDto {
    private String city;
    private String street;
    private int building;
}
