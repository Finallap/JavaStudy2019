package com.controller;

import com.bean.RssMessage;
import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.feed.rss.Content;
import com.rometools.rome.feed.rss.Item;
import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description: RSSFeedViewer
 * @date: 2020/4/28 16:47
 * @author: Finallap
 * @version: 1.0
 */
public class RssFeedViewer extends AbstractRssFeedView {
    @Override
    protected void buildFeedMetadata(Map<String, Object> model, Channel feed,
                                     HttpServletRequest request) {
        feed.setTitle("YiibaiPoint Dot Com");
        feed.setDescription("Java Yiibai and Examples");
        feed.setLink("http://www.yiibai.com");

        super.buildFeedMetadata(model, feed, request);
    }

    @Override
    protected List<Item> buildFeedItems(Map<String, Object> model, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        List<RssMessage> listContent = (List<RssMessage>) model.get("feedContent");
        List<Item> items = new ArrayList<Item>(listContent.size());

        for (RssMessage tempContent : listContent) {
            Item item = new Item();

            Content content = new Content();
            content.setValue(tempContent.getSummary());
            item.setContent(content);

            item.setTitle(tempContent.getTitle());
            item.setLink(tempContent.getUrl());
            item.setPubDate(tempContent.getCreatedDate());

            items.add(item);
        }
        return items;
    }
}
