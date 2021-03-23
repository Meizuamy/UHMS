package org.uhms.oauth.controller;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class CaptchaController {
    @Autowired
    private Producer captchaProducer;

    @GetMapping("/captcha.jpg")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");

        String capText = captchaProducer.createText();

        request.getSession().setAttribute("captcha",capText);

        BufferedImage bi = captchaProducer.createImage(capText);

        ServletOutputStream out  = response.getOutputStream();

        ImageIO.write(bi,"jpeg",out);

        try {
            out.flush();
        }finally {
            out.close();
        }
    }
}
