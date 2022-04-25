package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Project {

    String projectName;
    String projectCode;
    String projectDescription;
    String accessType;
}
