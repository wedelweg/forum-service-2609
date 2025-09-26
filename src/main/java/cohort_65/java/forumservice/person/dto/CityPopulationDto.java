package cohort_65.java.forumservice.person.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CityPopulationDto {
    private String city;
    private Long population;
}
