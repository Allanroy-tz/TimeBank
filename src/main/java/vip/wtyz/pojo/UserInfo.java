package vip.wtyz.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserInfo {
    @JsonProperty(value = "Name")
    String Name;
    @JsonProperty(value = "code")
    String code;
}
