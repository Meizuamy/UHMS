package org.uhms.oauth.config;

import com.mysql.cj.util.StringUtils;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class VerificationCodeFilter extends OncePerRequestFilter {

    public AuthenticationFailureHandler  authenticationFailureHandler = new MyAuthenticationFailureHandler();

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if(!"/auth/form".equals(httpServletRequest.getRequestURI())){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }else{
            try{
                verificationCode(httpServletRequest);
                filterChain.doFilter(httpServletRequest,httpServletResponse);
            }catch (VerificationCodeException e) {
                authenticationFailureHandler.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
            }
        }
    }

    private void verificationCode(HttpServletRequest httpServletRequest) throws VerificationCodeException {
        String requestCode = httpServletRequest.getParameter("captcha");
        HttpSession session = httpServletRequest.getSession();
        String saveCode = (String) session.getAttribute("captcha");
//        if(!StringUtils.isNullOrEmpty(saveCode)) {
//            session.removeAttribute("captcha");
//        }
        if(StringUtils.isNullOrEmpty(requestCode) || StringUtils.isNullOrEmpty(saveCode) || !requestCode.equals(saveCode)){
            throw new VerificationCodeException();
        }
    }
}
