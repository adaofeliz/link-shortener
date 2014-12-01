package com.adaofeliz.linkshortener.web.controller;

import com.adaofeliz.linkshortener.service.dto.ShortLink;
import com.adaofeliz.web.versioning.ApiVersion;
import com.google.common.collect.Lists;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 01/12/14.
 */

@RestController
@ApiVersion("1")
@RequestMapping("/api")
public class ServiceController {

    @ResponseBody
    @RequestMapping(value = "/link", method = RequestMethod.GET)
    public List<ShortLink> link() {
        return Lists.newArrayList(); // TODO - IMPLEMENT
    }

    @ResponseBody
    @RequestMapping(value = "/link", method = RequestMethod.POST)
    public ShortLink createLink(@RequestBody String originalUrl) {
        return new ShortLink(); // TODO - IMPLEMENT
    }

    @ResponseBody
    @RequestMapping(value = "/link/{shortUri}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    public void getLink(@PathVariable String shortUri) {
        // TODO - IMPLEMENT
    }


    @ResponseBody
    @RequestMapping(value = "/link/{shortUri}", method = RequestMethod.PUT)
    public ShortLink getLink(@PathVariable String shortUri, @RequestBody String originalUrl) {
        return new ShortLink(); // TODO - IMPLEMENT
    }

    @ResponseBody
    @RequestMapping(value = "/link/{shortUri}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLink(@PathVariable String shortUri) {
        // TODO - IMPLEMENT
    }

}
