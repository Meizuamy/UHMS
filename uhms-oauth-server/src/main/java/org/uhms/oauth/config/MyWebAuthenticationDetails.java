package org.uhms.oauth.config;

import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



public class MyWebAuthenticationDetails extends WebAuthenticationDetails {

    private boolean imageCodeIsRight;

    private String imageCode;

    private String savedImageCode;

    public boolean getImageCodeIsRight(){
        return this.imageCodeIsRight;
    }

    /**
     * Records the remote address and will also set the session Id if a session already
     * exists (it won't create one).
     *
     * @param request that the authentication request was received from
     */
    public MyWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        this.imageCode = request.getParameter("captcha");
        HttpSession session = request.getSession();
        this.savedImageCode = (String)session.getAttribute("captcha");
        if(!StringUtils.isEmpty(this.savedImageCode)){
            //清除验证码，不管是失败还是成功，所有客户端都应在登录失败时刷新验证码
            session.removeAttribute("captcha");
            if(!StringUtils.isEmpty(imageCode) && imageCode.equals(savedImageCode)){
                this.imageCodeIsRight = true;
            }
        }

    }
}
