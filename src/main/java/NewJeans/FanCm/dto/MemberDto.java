package NewJeans.FanCm.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberDto {
    private String Id;
    private String nickName;

    public MemberDto(String id, String nickName) {
        Id = id;
        this.nickName = nickName;
    }
}
