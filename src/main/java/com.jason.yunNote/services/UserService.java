package services;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.Digester;
import dao.UserDao;
import org.springframework.stereotype.Service;
import po.User;
import vo.ResultInfo;

import javax.annotation.Resource;
import java.io.PipedWriter;

@Service
public class UserService {
    @Resource
    private UserDao userDao;

    public ResultInfo<User> checkLoginInfo(String uname,String pwd){

        //调用一次该方法创建一个消息
        if(StrUtil.isBlank(uname) || StrUtil.isBlank(pwd)) {
            ResultInfo<User> resultInfo = ResultInfo.<User>builder().code(404).msg("用户姓名或密码不能为空").build();
            return  resultInfo;
        }
        User user = userDao.queryUserByName(uname);
        if (user == null ){
            ResultInfo<User> resultInfo = ResultInfo.<User>builder().code(404).msg("用户名不存在").result(null).build();
            return  resultInfo;
        }
        if (user.getUpwd().equals(DigestUtil.md5Hex(pwd))) {
            ResultInfo<User> resultInfo = ResultInfo.<User>builder().code(100).msg("登录成功").result(user).build();
            return  resultInfo;
        } else {
            ResultInfo<User> resultInfo = ResultInfo.<User>builder().code(404).msg("密码错误，请重新输入").result(user).build();
            return  resultInfo;
        }
    }
}
