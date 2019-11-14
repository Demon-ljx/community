package com.ljx.community.community.Controller;

import com.ljx.community.community.Dto.AccessTokenDto;
import com.ljx.community.community.Dto.GithubUser;
import com.ljx.community.community.mapper.UserMapper;
import com.ljx.community.community.provider.GithubProvider;
import com.ljx.community.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Autowired
    private UserMapper userMapper;

    @Value("${github.Client_id}")
    private String Client_id;

    @Value("${github.Client_secret}")
    private String Client_secret;

    @Value("${github.Redirect_uri}")
    private String Redirect_uri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code")String code,
                           @RequestParam(name="state")String state,
                           HttpServletRequest request,
                           HttpServletResponse response){
        AccessTokenDto accessTokenDto=new AccessTokenDto();
        accessTokenDto.setClient_id(Client_id);
        accessTokenDto.setClient_secret(Client_secret);
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_uri(Redirect_uri);
        accessTokenDto.setState(state);
        String accessToken=githubProvider.getAccessToken(accessTokenDto);
        GithubUser githubUser=githubProvider.githubUser(accessToken);

        if (githubUser!=null)
        {
            //登录成功
            String token=UUID.randomUUID().toString();
            User user=new User();
            user.setToken(token);
            user.setName(githubUser.getName());
            user.setAccountID(String.valueOf(githubUser.getId()));
            user.setGmCreate(System.currentTimeMillis());
            user.setGmModified(user.getGmCreate());
            userMapper.insert(user);
            response.addCookie(new Cookie("token",token));
            request.getSession().setAttribute("githubUser",githubUser);
            return "redirect:/";
        }else{
            //登录失败
            return "redirect:/";
        }
    }


}
