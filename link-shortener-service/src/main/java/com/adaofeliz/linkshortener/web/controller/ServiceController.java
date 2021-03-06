package com.adaofeliz.linkshortener.web.controller;

import com.adaofeliz.linkshortener.service.ShortLinkService;
import com.adaofeliz.linkshortener.service.domain.ShortLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 01/12/14.
 */

@RestController
@RequestMapping("/api")
public class ServiceController {

    @Autowired
    private ShortLinkService shortLinkService;

    @RequestMapping(value = "/link", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ShortLink createLink(@RequestBody String originalUrl) {
        return shortLinkService.createNewShortLink(originalUrl);
    }

    @RequestMapping(value = "/link/all", method = RequestMethod.GET)
    public List<ShortLink> allLinks() {
        return shortLinkService.getAllLinks();
    }

    @RequestMapping(value = "/link/{shortUri}", method = RequestMethod.GET)
    public ShortLink getLink(@PathVariable String shortUri) {
        return shortLinkService.getShortLinkByShortUri(shortUri);
    }

    @RequestMapping(value = "/link/{shortUri}", method = RequestMethod.PUT, consumes = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void updateLink(@PathVariable String shortUri, @RequestBody String originalUrl) {
        shortLinkService.updateShortLinkOriginalUrl(shortUri, originalUrl);
    }

    @RequestMapping(value = "/link/{shortUri}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteLink(@PathVariable String shortUri) {
        shortLinkService.deleteShortLinkByShortUri(shortUri);
    }

}
