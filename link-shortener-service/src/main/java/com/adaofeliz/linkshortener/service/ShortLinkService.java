package com.adaofeliz.linkshortener.service;

import com.adaofeliz.linkshortener.service.domain.ShortLink;
import com.adaofeliz.linkshortener.service.domain.ShortLinkRepository;
import com.adaofeliz.linkshortener.service.helper.ShortLinkHelper;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created on 02/12/14.
 */

@Service
public class ShortLinkService {

    @Autowired
    private ShortLinkHelper shortLinkHelper;

    @Autowired
    private ShortLinkRepository shortLinkRepository;

    public List<ShortLink> getAllLinks() {
        return Lists.newArrayList(shortLinkRepository.findAll());
    }

    public ShortLink createNewShortLink(String originalUrl) {
        // Create and save a new ShortLink
        ShortLink shortLink = new ShortLink();
        shortLink.setOriginalUrl(originalUrl);
        shortLink.setCreationDate(new Date());

        // Save and retrieve
        ShortLink newShortLink = shortLinkRepository.save(shortLink);

        // Updating with the Short Link
        newShortLink.setShortUri(shortLinkHelper.encode(newShortLink.getId()));
        return shortLinkRepository.save(newShortLink);
    }

    public ShortLink getShortLinkByShortUri(String shortUri) {
        ShortLink shortLink = shortLinkRepository.findOne(shortLinkHelper.decode(shortUri));
        shortLink.setShortUri(shortUri);
        return shortLink;
    }

    public void updateShortLinkOriginalUrl(String shortUri, String originalUrl) {
        ShortLink shortLink = getShortLinkByShortUri(shortUri);
        shortLink.setOriginalUrl(originalUrl);
        shortLinkRepository.save(shortLink);
    }

    public void deleteShortLinkByShortUri(String shortUri) {
        shortLinkRepository.delete(shortLinkHelper.decode(shortUri));
    }
}
