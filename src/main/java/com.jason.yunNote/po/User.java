package po;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class User {
    private int  userID; //用户id
    private String uname; //用户名称
    private String upwd; //用户密码
    private String nick; //用户昵称
    private String head; //用户头像
    private String mood; //用户心情

}
