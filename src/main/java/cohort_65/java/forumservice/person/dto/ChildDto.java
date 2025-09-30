package cohort_65.java.forumservice.person.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChildDto extends PersonDto {
    private String kindergarten;
}
