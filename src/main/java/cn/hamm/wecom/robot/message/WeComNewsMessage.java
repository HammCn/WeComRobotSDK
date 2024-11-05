package cn.hamm.wecom.robot.message;

import cn.hamm.wecom.robot.base.WeComMessage;
import cn.hamm.wecom.robot.constant.WeComAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <h1>图文</h1>
 *
 * @author Hamm.cn
 */
public class WeComNewsMessage extends WeComMessage {
    private News news = new News();

    public WeComNewsMessage() {
        this.setMsgType(WeComAlias.NEWS);
    }

    public News getNews() {
        return news;
    }

    public WeComNewsMessage setNews(News news) {
        this.news = news;
        return this;
    }

    public static class News {
        private List<Article> articles = new ArrayList<>();

        public List<Article> getArticles() {
            return articles;
        }

        /**
         * <h2>图文消息</h2>
         *
         * @param articles 图文消息
         * @apiNote 一个图文消息支持1到8条图文
         */
        public News setArticles(List<Article> articles) {
            this.articles = articles;
            return this;
        }

        /**
         * <h2>添加图文消息</h2>
         *
         * @param article 图文消息
         * @apiNote 一个图文消息支持1到8条图文
         */
        public News addArticle(Article article) {
            if (Objects.isNull(articles)) {
                articles = new ArrayList<>();
            }
            articles.add(article);
            return this;
        }

        public static class Article {
            private String title;

            private String description;

            private String url;

            @JsonProperty(WeComAlias.PICTURE_URL)
            private String picUrl;

            public String getTitle() {
                return title;
            }

            /**
             * <h2>标题</h2>
             *
             * @param title 标题
             * @apiNote 不超过128个字节，超过会自动截断
             */
            public Article setTitle(String title) {
                this.title = title;
                return this;
            }

            public String getDescription() {
                return description;
            }

            /**
             * <h2>描述</h2>
             *
             * @param description 描述
             * @apiNote 不超过512个字节，超过会自动截断
             */
            public Article setDescription(String description) {
                this.description = description;
                return this;
            }

            public String getUrl() {
                return url;
            }

            /**
             * <h2>点击后跳转的链接</h2>
             *
             * @param url 点击后跳转的链接
             */
            public Article setUrl(String url) {
                this.url = url;
                return this;
            }

            public String getPicUrl() {
                return picUrl;
            }

            /**
             * <h2>图文消息的图片链接</h2>
             *
             * @param picUrl 图文消息的图片链接
             */
            public Article setPicUrl(String picUrl) {
                this.picUrl = picUrl;
                return this;
            }
        }
    }
}
