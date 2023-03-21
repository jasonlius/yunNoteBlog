package vo;

import lombok.Getter;
import lombok.Setter;

/**
 *
 *  主要实现两个功能
 *  状态码 成功=1 失败=2
 *  返回的状态信息（字符串、可以是Javabean）
**/
@Getter
@Setter
public class ResultInfo<T> {
    private Integer code;
    private String msg;
    private T result;//返回对象（字符串、javaBean、集合、Map等）


}
