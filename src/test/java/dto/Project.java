package dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Project {

    @SerializedName("title")
    String name;
    String code;
    String description;
    @SerializedName("access")
    String accessType;
}
