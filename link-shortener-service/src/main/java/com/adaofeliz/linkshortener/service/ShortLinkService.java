package com.adaofeliz.linkshortener.service;

import com.adaofeliz.linkshortener.service.domain.ShortLink;
import com.adaofeliz.linkshortener.service.domain.ShortLinkRepository;
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

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_-=";
    private static final int BASE = ALPHABET.length();

    @Autowired
    private ShortLinkRepository shortLinkRepository;

    public List<ShortLink> getAllLinks() {
        return Lists.newArrayList(shortLinkRepository.findAll());
    }

    public ShortLink createNewShortLink(String originalUrl) {
        ShortLink shortLink = new ShortLink();

        shortLink.setOriginalUrl(originalUrl);
        shortLink.setCreationDate(new Date());

        ShortLink newShortLink = shortLinkRepository.save(shortLink);
        shortLink.setShortUri(encode(newShortLink.getId()));

        return newShortLink;
    }

    public ShortLink getShortLinkByShortUri(String shortUri) {

        ShortLink shortLink = shortLinkRepository.findOne(decode(shortUri));
        shortLink.setShortUri(shortUri);

        return shortLink;
    }

    public void updateShortLink(String shortUri, String originalUrl) {

        ShortLink shortLink = getShortLinkByShortUri(shortUri);
        shortLink.setOriginalUrl(originalUrl);

        shortLinkRepository.save(shortLink);
    }

    public void deleteShortLinkByShortUri(String shortUri) {
        shortLinkRepository.delete(decode(shortUri));
    }

    private Long decode(String s) {
        Long num = 0L;
        for (char ch : s.toCharArray()) {
            num *= BASE;
            num += ALPHABET.indexOf(ch);
        }
        return num;
    }

    private String encode(Long num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(ALPHABET.charAt((int) (num % BASE)));
            num /= BASE;
        }
        return sb.reverse().toString();
    }
}
