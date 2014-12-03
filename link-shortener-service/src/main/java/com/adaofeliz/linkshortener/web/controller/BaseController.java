package com.adaofeliz.linkshortener.web.controller;

import com.adaofeliz.linkshortener.service.ShortLinkService;
import com.adaofeliz.linkshortener.service.domain.ShortLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class BaseController {

    @Autowired
    private ShortLinkService shortLinkService;

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void applicationIndex(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendRedirect("/swagger/index.html");
    }

    @ResponseBody
    @RequestMapping(value = "/{shortUri}", method = RequestMethod.GET)
    public void getLink(@PathVariable String shortUri, HttpServletResponse httpServletResponse) throws IOException {
        ShortLink shortLink = shortLinkService.getShortLinkByShortUri(shortUri);
        httpServletResponse.sendRedirect(shortLink.getOriginalUrl());
    }
}
