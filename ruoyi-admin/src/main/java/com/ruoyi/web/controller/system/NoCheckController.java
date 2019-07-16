package com.ruoyi.web.controller.system;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.ResultInfo;
import com.ruoyi.framework.shiro.service.SysPasswordService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.VerificationCode;
import com.ruoyi.system.service.ISysConfigService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.IVerificationCodeService;

/**
 * 不需要拦截过滤的请求
 * @author Li Dehuan
 * @date 2019年7月10日
 *
 */
@Controller
@RequestMapping("/noCheck")
public class NoCheckController extends BaseController {

	@Autowired
	private ISysUserService sysUserService;

    @Autowired
    private IVerificationCodeService verificationCodeService;
    
    @Autowired
    private SysPasswordService passwordService;
	
    @Autowired
    private ISysConfigService configService;
    
    /**
     * 忘记密码跳转
     */
    @GetMapping("/findPassword")
    public String findPassword(ModelMap mmap) {

        return "email/findPassword";
    }
    
    
    /**
     * 检查用户邮箱是否正确
     * @param user
     * @return
     */
    @PostMapping("/checkUserEmail")
    @ResponseBody
    public AjaxResult checkUserEmail(SysUser user){
   
    	return sysUserService.checkUserEmail(user);
    }
    
    
    /**
     * 跳转验证码输入页面
     * @param user
     * @param mmap
     * @return
     */
    @GetMapping("/toVeriPage")
    public String toVeriPage(SysUser user, ModelMap mmap){
    	
    	mmap.put("sysUser", user);
    	
		return "email/veriPage";
    }
    
    
    /**
     * 检验验证码是否正确
     * @param code
     * @param username
     * @param email
     * @param token
     * @param mmap
     * @return
     */
    @GetMapping("/checkEmailVeriCode")
    public String checkEmailVeriCode(String code, String username, String email, String token, ModelMap mmap){
    	
    	VerificationCode params = new VerificationCode();
    	params.setUsername(username);
    	params.setEmail(email);
    	params.setVeriCode(code);
    	params.setVaildTime(new Date());
    	
    	//获取系统默认密码
    	//String password = configService.selectConfigByKey("sys.user.initPassword");

    	//SysUser user = sysUserService.selectUserByLoginName(username);
    	/*user.setSalt(ShiroUtils.randomSalt());
        user.setPassword(passwordService.encryptPassword(user.getLoginName(), password, user.getSalt()));*/
        
		int res = verificationCodeService.getVerificationCode(params);
		
		if(res != 1){
			ResultInfo<?> info = new ResultInfo<>(400, "验证已过期");
			mmap.put("result", info);
			return "email/errorInfo";
		}
		
		mmap.put("VeriCode", params);
		
    	return "email/updatePassword";
    }
    
    
    /**
     * 检验验证码是否正确
     * @param code
     * @param username
     * @param email
     * @return
     */
    @PostMapping("/checkEmailVeriCode")
    @ResponseBody
    public AjaxResult checkEmailVeriCode(String code, String loginName, String email){
		
    	VerificationCode params = new VerificationCode();
    	params.setUsername(loginName);
    	params.setEmail(email);
    	params.setVeriCode(code);
    	params.setVaildTime(new Date());
    	params.setVaild(1);
    	
    	//获取系统默认密码
    	//String password = configService.selectConfigByKey("sys.user.initPassword");
    	
    	//获取用户信息
		//SysUser user = sysUserService.selectUserByLoginName(loginName);
		/*user.setSalt(ShiroUtils.randomSalt());
        user.setPassword(passwordService.encryptPassword(user.getLoginName(), password, user.getSalt()));*/
        
		//验证
		int res = verificationCodeService.getVerificationCode(params);
		
		if(res != 1){
			return AjaxResult.error("验证码不正确或超时");
		}
		
		//登录
		/*UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
        Subject subject = SecurityUtils.getSubject();
        
        try {
            subject.login(token);
            
        } catch (AuthenticationException e) {
            String msg = "用户或密码错误";
            if (StringUtils.isNotEmpty(e.getMessage())) {
                msg = e.getMessage();
            }
            return error(msg);
        }*/
    	
        return success();
    }
    
    
    
    /**
     * 修改密码页面跳转
     * @param mmap
     * @return
     */
    @GetMapping("/updatePassword")
    public String updatePassword(String code, String username, String email, ModelMap mmap){
    	
    	VerificationCode params = new VerificationCode();
    	params.setUsername(username);
    	params.setEmail(email);
    	params.setVeriCode(code);
    	params.setVaildTime(new Date());
    	
    	//获取系统默认密码
    	//String password = configService.selectConfigByKey("sys.user.initPassword");

    	//SysUser user = sysUserService.selectUserByLoginName(username);
    	/*user.setSalt(ShiroUtils.randomSalt());
        user.setPassword(passwordService.encryptPassword(user.getLoginName(), password, user.getSalt()));*/
        
		int res = verificationCodeService.getVerificationCode(params);
		
		if(res != 1){
			ResultInfo<?> info = new ResultInfo<>(400, "验证已过期");
			mmap.put("result", info);
			return "email/errorInfo";
		}
		
		mmap.put("VeriCode", params);
    	
		return "email/updatePassword";
    }
    
    
    
    /**
     * 修改密码
     * @param password
     * @return
     */
    @PostMapping("/updatePassword")
    @ResponseBody
    public AjaxResult updatePassword(String code, String username, String email, String password){
		
    	SysUser user = sysUserService.selectUserByLoginName(username);
    	user.setSalt(ShiroUtils.randomSalt());
        user.setPassword(passwordService.encryptPassword(user.getLoginName(), password, user.getSalt()));
        
        VerificationCode veri = new VerificationCode();
        veri.setVaildTime(new Date());
        veri.setVeriCode(code);
        veri.setUsername(username);
        veri.setEmail(email);
        
        AjaxResult res = verificationCodeService.resetUserPwd(user, veri);
    	
    	return res;
    }
    
    
    
    /**
     * 跳转错误信息页面
     * @param info
     * @param mmap
     * @return
     */
    @GetMapping("/errorInfo")
    public String errorInfo(ResultInfo<?> info, ModelMap mmap){
    	
    	mmap.put("result", info);
    	
		return "email/errorInfo";
    }
}
