package cn.hamm.wecom.robot.message;

import cn.hamm.wecom.robot.WeComMessage;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <h1>模板卡片</h1>
 *
 * @author Hamm.cn
 */
public class WeComTemplateCardMessage extends WeComMessage {
    public WeComTemplateCardMessage() {
        this.setMsgType("template_card");
    }

    @JsonProperty("template_card")
    private TemplateCard templateCard = new TemplateCard();

    public TemplateCard getTemplateCard() {
        return templateCard;
    }

    /**
     * <h2>模版卡片</h2>
     *
     * @param templateCard 模板卡片
     */
    public WeComTemplateCardMessage setTemplateCard(TemplateCard templateCard) {
        this.templateCard = templateCard;
        return this;
    }

    public static class TemplateCard {
        @JsonProperty("card_type")
        private String cardType = "text_notice";

        public String getCardType() {
            return cardType;
        }

        /**
         * <h2>文本通知卡片</h2>
         */
        public TemplateCard setCardTypeText() {
            this.cardType = "text_notice";
            return this;
        }

        /**
         * <h2>文本通知卡片</h2>
         */
        public TemplateCard setCardTypeImage() {
            this.cardType = "news_notice";
            return this;
        }

        /**
         * <h2>卡片类型</h2>
         *
         * @param cardType 卡片类型
         */
        public void setCardType(String cardType) {
            this.cardType = cardType;
        }

        private Source source = new Source();

        public Source getSource() {
            return source;
        }

        /**
         * <h2>卡片来源样式信息</h2>
         *
         * @apiNote 不需要来源样式可不填写
         */
        public TemplateCard setSource(Source source) {
            this.source = source;
            return this;
        }

        @JsonProperty("sub_title_text")
        private String subTitleText;

        public String getSubTitleText() {
            return subTitleText;
        }

        /**
         * <h2>二级普通文本</h2>
         *
         * @param subTitleText 二级普通文本
         * @apiNote 建议不超过112个字，模版卡片主要内容的一级标题 <code>main_title.title</code> 和二级普通文本 <code>sub_title_text</code> 必须有一项填写
         */
        public void setSubTitleText(String subTitleText) {
            this.subTitleText = subTitleText;
        }

        @JsonProperty("main_title")
        private MainTitle mainTitle = new MainTitle();

        /**
         * <h2>模版卡片的主要内容</h2>
         *
         * @param mainTitle 模版卡片的主要内容
         */
        public TemplateCard setMainTitle(MainTitle mainTitle) {
            this.mainTitle = mainTitle;
            return this;
        }

        /**
         * <h2>模版卡片的主要内容</h2>
         *
         * @apiNote 包括一级标题和标题辅助信息
         */
        public MainTitle getMainTitle() {
            return mainTitle;
        }

        @JsonProperty("emphasis_content")
        private EmphasisContent emphasisContent = new EmphasisContent();

        public EmphasisContent getEmphasisContent() {
            return emphasisContent;
        }

        /**
         * <h2>关键数据样式</h2>
         *
         * @param emphasisContent 关键数据样式
         */
        public TemplateCard setEmphasisContent(EmphasisContent emphasisContent) {
            this.emphasisContent = emphasisContent;
            return this;
        }

        @JsonProperty("quote_area")
        private QuoteArea quoteArea;

        public QuoteArea getQuoteArea() {
            return quoteArea;
        }

        /**
         * <h2>引用文献样式</h2>
         *
         * @param quoteArea 引用文献样式
         * @apiNote 建议不与关键数据共用
         */
        public TemplateCard setQuoteArea(QuoteArea quoteArea) {
            this.quoteArea = quoteArea;
            return this;
        }

        @JsonProperty("horizontal_content_list")
        private List<HorizontalContent> horizontalContentList = new ArrayList<>();

        public List<HorizontalContent> getHorizontalContentList() {
            return horizontalContentList;
        }

        /**
         * <h2>二级标题+文本列表</h2>
         *
         * @param horizontalContentList 二级标题+文本列表
         * @apiNote 该字段可为空数组，但有数据的话需确认对应字段是否必填，列表长度不超过6
         */
        public TemplateCard setHorizontalContentList(List<HorizontalContent> horizontalContentList) {
            this.horizontalContentList = horizontalContentList;
            return this;
        }

        /**
         * <h2>添加二级标题+文本</h2>
         *
         * @param horizontalContent 二级标题+文本
         * @apiNote 该字段可为空数组，但有数据的话需确认对应字段是否必填，列表长度不超过6
         */
        public TemplateCard addHorizontalContent(HorizontalContent horizontalContent) {
            if (Objects.isNull(horizontalContentList)) {
                horizontalContentList = new ArrayList<>();
            }
            horizontalContentList.add(horizontalContent);
            return this;
        }

        /**
         * <h2>跳转指引样式的列表</h2>
         *
         * @apiNote 该字段可为空数组，但有数据的话需确认对应字段是否必填，列表长度不超过3
         */
        @JsonProperty("jump_list")
        private List<Jump> jumpList = new ArrayList<>();

        public List<Jump> getJumpList() {
            return jumpList;
        }

        /**
         * <h2>跳转指引样式的列表</h2>
         *
         * @param jumpList 跳转指引样式的列表
         * @apiNote 该字段可为空数组，但有数据的话需确认对应字段是否必填，列表长度不超过3
         */
        public TemplateCard setJumpList(List<Jump> jumpList) {
            this.jumpList = jumpList;
            return this;
        }

        /**
         * <h2>添加跳转指引样式</h2>
         *
         * @param jump 跳转指引样式
         * @apiNote 该字段可为空数组，但有数据的话需确认对应字段是否必填，列表长度不超过3
         */
        public TemplateCard addJump(Jump jump) {
            if (Objects.isNull(jumpList)) {
                jumpList = new ArrayList<>();
            }
            jumpList.add(jump);
            return this;
        }

        @JsonProperty("card_action")
        private CardAction cardAction = new CardAction();

        public CardAction getCardAction() {
            return cardAction;
        }

        /**
         * <h2>整体卡片的点击跳转事件</h2>
         *
         * @param cardAction 整体卡片的点击跳转事件
         * @apiNote text_notice模版卡片中该字段为必填项
         */
        public TemplateCard setCardAction(CardAction cardAction) {
            this.cardAction = cardAction;
            return this;
        }

        @JsonProperty("card_image")
        private CardImage cardImage = new CardImage();

        public CardImage getCardImage() {
            return cardImage;
        }

        /**
         * <h2>图片样式</h2>
         *
         * @param cardImage 图片样式
         */
        public TemplateCard setCardImage(CardImage cardImage) {
            this.cardImage = cardImage;
            return this;
        }

        @JsonProperty("image_text_area")
        private ImageTextArea imageTextArea = new ImageTextArea();

        public ImageTextArea getImageTextArea() {
            return imageTextArea;
        }

        /**
         * <h2>左图右文样式</h2>
         *
         * @param imageTextArea 左图右文样式
         */
        public TemplateCard setImageTextArea(ImageTextArea imageTextArea) {
            this.imageTextArea = imageTextArea;
            return this;
        }

        public static class ImageTextArea {
            private String url;

            public String getUrl() {
                return url;
            }

            /**
             * <h2>点击跳转的url</h2>
             *
             * @param url 点击跳转的url
             * @apiNote image_text_area.type是 {@link Type#URL} 时必填
             */
            public ImageTextArea setUrl(String url) {
                this.url = url;
                return this;
            }

            private String appid;

            public String getAppid() {
                return appid;
            }

            /**
             * <h2>点击跳转的小程序的appid</h2>
             *
             * @param appid 点击跳转的小程序的appid
             * @apiNote 必须是与当前应用关联的小程序，image_text_area.type是 {@link Type#MINI_PROGRAM} 时必填
             */
            public void setAppid(String appid) {
                this.appid = appid;
            }

            @JsonProperty("pagepath")
            private String pagePath;

            public String getPagePath() {
                return pagePath;
            }

            /**
             * <h2>点击跳转的小程序的pagepath</h2>
             *
             * @param pagePath 点击跳转的小程序的pagepath
             * @apiNote image_text_area.type是 {@link Type#MINI_PROGRAM} 时选填
             */
            public ImageTextArea setPagePath(String pagePath) {
                this.pagePath = pagePath;
                return this;
            }

            private String title;

            public String getTitle() {
                return title;
            }

            /**
             * <h2>左图右文样式的标题</h2>
             *
             * @param title 左图右文样式的标题
             */
            public ImageTextArea setTitle(String title) {
                this.title = title;
                return this;
            }

            private String desc;

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            @JsonProperty("image_url")
            private String imageUrl;

            public String getImageUrl() {
                return imageUrl;
            }

            /**
             * <h2>左图右文样式的图片url</h2>
             *
             * @param imageUrl 左图右文样式的图片url
             */
            public ImageTextArea setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
                return this;
            }

            private Integer type = Type.NONE.getValue();

            public Integer getType() {
                return type;
            }

            /**
             * <h2>左图右文样式区域点击事件</h2>
             *
             * @param type 左图右文样式区域点击事件
             * @see Type
             */
            public ImageTextArea setType(Type type) {
                this.type = type.getValue();
                return this;
            }

            public enum Type {
                /**
                 * <h2>无跳转</h2>
                 */
                NONE(0),

                /**
                 * <h2>跳转url</h2>
                 */
                URL(1),

                /**
                 * <h2>跳转小程序</h2>
                 */
                MINI_PROGRAM(2);

                private final int value;

                Type(int value) {
                    this.value = value;
                }

                public int getValue() {
                    return value;
                }
            }
        }

        public static class CardImage {
            private String url;

            public String getUrl() {
                return url;
            }

            /**
             * <h2>图片的url</h2>
             *
             * @param url 图片的url
             */
            public CardImage setUrl(String url) {
                this.url = url;
                return this;
            }

            @JsonProperty("aspect_ratio")
            private Double aspectRatio = 1.3;

            public Double getAspectRatio() {
                return aspectRatio;
            }

            /**
             * <h2>图片的宽高比</h2>
             *
             * @param aspectRatio 宽高比要小于<code>2.25</code>，大于<code>1.3</code>，不填该参数默认<code>1.3</code>
             */
            public CardImage setAspectRatio(Double aspectRatio) {
                this.aspectRatio = aspectRatio;
                return this;
            }
        }

        public static class CardAction {
            private Integer type = Type.URL.getValue();

            public Integer getType() {
                return type;
            }

            /**
             * <h2>卡片跳转类型</h2>
             *
             * @param type 卡片跳转类型
             * @apiNote <code>text_notice</code> 模版卡片中该字段取值范围为 <code>[1, 2]</code>
             * @see Type
             */
            public CardAction setType(Type type) {
                this.type = type.getValue();
                return this;
            }

            private String url;

            public String getUrl() {
                return url;
            }

            /**
             * <h2>跳转事件的url</h2>
             *
             * @param url 跳转事件的url
             * @apiNote <code>card_action.type</code> 是 {@link Type#URL} 时必填
             */
            public CardAction setUrl(String url) {
                this.url = url;
                return this;
            }

            private String appid;

            public String getAppid() {
                return appid;
            }

            /**
             * <h2>跳转事件的小程序的appid</h2>
             *
             * @param appid AppId
             * @apiNote <code>card_action.type</code> 是 {@link Type#MINI_PROGRAM} 时必填
             */
            public CardAction setAppid(String appid) {
                this.appid = appid;
                return this;
            }

            /**
             * <h2>跳转事件的小程序的pagepath</h2>
             *
             * @apiNote <code>card_action.type</code> 是 {@link Type#MINI_PROGRAM} 时选填
             */
            @JsonProperty("pagepath")
            private String pagePath;

            public String getPagePath() {
                return pagePath;
            }

            /**
             * <h2>跳转事件的小程序的pagePath</h2>
             *
             * @param pagePath 跳转事件的小程序的pagePath
             * @apiNote <code>card_action.type</code> 是 {@link Type#MINI_PROGRAM} 时选填
             */
            public void setPagePath(String pagePath) {
                this.pagePath = pagePath;
            }

            public enum Type {
                /**
                 * <h2>跳转url</h2>
                 */
                URL(1),

                /**
                 * <h2>打开小程序</h2>
                 */
                MINI_PROGRAM(2);

                private final int value;

                Type(int value) {
                    this.value = value;
                }

                public int getValue() {
                    return value;
                }
            }
        }

        public static class Jump {
            private Integer type = Type.NORMAL.getValue();

            public Integer getType() {
                return type;
            }

            /**
             * <h2>跳转链接类型</h2>
             *
             * @param type 跳转链接类型
             * @see Type
             */
            public Jump setType(Type type) {
                this.type = type.getValue();
                return this;
            }

            private String title;

            public String getTitle() {
                return title;
            }

            /**
             * <h2>跳转链接的文案内容</h2>
             *
             * @param title 跳转链接的文案内容
             * @apiNote 建议不超过13个字
             */
            public Jump setTitle(String title) {
                this.title = title;
                return this;
            }

            private String url;

            public String getUrl() {
                return url;
            }

            /**
             * <h2>跳转链接的url</h2>
             *
             * @param url 跳转链接的url
             * @apiNote <code>jump_list.type</code> 是 {@link Type#URL} 时必填
             */
            public Jump setUrl(String url) {
                this.url = url;
                return this;
            }

            private String appid;

            public String getAppid() {
                return appid;
            }

            /**
             * <h2>跳转链接的小程序的appid</h2>
             *
             * @param appid 跳转链接的小程序的appid
             * @apiNote <code>jump_list.type</code> 是 {@link Type#MINI_PROGRAM} 时必填
             */
            public Jump setAppid(String appid) {
                this.appid = appid;
                return this;
            }

            @JsonProperty("pagepath")
            private String pagePath;

            public String getPagePath() {
                return pagePath;
            }

            /**
             * <h2>跳转链接的小程序的pagePath</h2>
             *
             * @param pagePath 跳转链接的小程序的pagePath
             * @apiNote <code>jump_list.type</code> 是 {@link Type#MINI_PROGRAM} 时选填
             */
            public void setPagePath(String pagePath) {
                this.pagePath = pagePath;
            }

            public enum Type {
                /**
                 * <h2>不是链接</h2>
                 */
                NORMAL(0),

                /**
                 * <h2>跳转url</h2>
                 */
                URL(1),

                /**
                 * <h2>跳转小程序</h2>
                 */
                MINI_PROGRAM(2);

                private final int value;

                Type(int value) {
                    this.value = value;
                }

                public int getValue() {
                    return value;
                }
            }
        }

        public static class HorizontalContent {
            @JsonProperty("keyname")
            private String keyName;

            public String getKeyName() {
                return keyName;
            }

            /**
             * <h2>二级标题</h2>
             *
             * @param keyName 二级标题
             * @apiNote 建议不超过5个字
             */
            public HorizontalContent setKeyName(String keyName) {
                this.keyName = keyName;
                return this;
            }

            private String value;

            public String getValue() {
                return value;
            }

            /**
             * <h2>二级文本</h2>
             *
             * @param value 二级文本
             * @apiNote 如果 <code>horizontal_content_list.type</code> 是 {@link Type#DOWNLOAD}，该字段代表文件名称（要包含文件类型），建议不超过26个字
             */
            public HorizontalContent setValue(String value) {
                this.value = value;
                return this;
            }

            private String url;

            public String getUrl() {
                return url;
            }

            /**
             * <h2>链接跳转的url</h2>
             *
             * @param url 链接跳转的url
             * @apiNote <code>horizontal_content_list.type</code> 是 {@link Type#URL} 时必填
             */
            public HorizontalContent setUrl(String url) {
                this.url = url;
                return this;
            }

            @JsonProperty("media_id")
            private String mediaId;

            public String getMediaId() {
                return mediaId;
            }

            /**
             * <h2>附件的media_id</h2>
             *
             * @param mediaId 附件的media_id
             * @apiNote <code>horizontal_content_list.type</code> 是 {@link Type#DOWNLOAD} 时必填
             */
            public void setMediaId(String mediaId) {
                this.mediaId = mediaId;
            }

            private String userid;

            public String getUserid() {
                return userid;
            }

            /**
             * <h2>被@的成员的userid</h2>
             *
             * @param userid 被@的成员的userid
             * @apiNote <code>horizontal_content_list.type</code> 是 {@link Type#AT} 时必填
             */
            public HorizontalContent setUserid(String userid) {
                this.userid = userid;
                return this;
            }

            private Integer type;

            public Integer getType() {
                return type;
            }

            /**
             * <h2>模版卡片的二级标题信息内容支持的类型</h2>
             *
             * @param type 模版卡片的二级标题信息内容支持的类型
             * @see Type
             */
            public HorizontalContent setType(Type type) {
                this.type = type.getValue();
                return this;
            }

            public enum Type {
                /**
                 * <h2>普通文本</h2>
                 */
                NORMAL(0),

                /**
                 * <h2>跳转url</h2>
                 */
                URL(1),

                /**
                 * <h2>下载附件</h2>
                 */
                DOWNLOAD(2),

                /**
                 * <h2>@员工</h2>
                 */
                AT(3);
                private final int value;

                Type(int value) {
                    this.value = value;
                }

                public int getValue() {
                    return value;
                }
            }
        }

        public static class Source {
            @JsonProperty("icon_url")
            private String iconUrl;

            public String getIconUrl() {
                return iconUrl;
            }

            /**
             * <h2>来源图片的url</h2>
             *
             * @param iconUrl 来源图片的url
             */
            public Source setIconUrl(String iconUrl) {
                this.iconUrl = iconUrl;
                return this;
            }

            private String desc;

            public String getDesc() {
                return desc;
            }

            /**
             * <h2>来源图片的描述</h2>
             *
             * @param desc 来源图片的描述
             * @apiNote 建议不超过13个字
             */
            public Source setDesc(String desc) {
                this.desc = desc;
                return this;
            }

            @JsonProperty("desc_color")
            private Integer descColor;

            public Integer getDescColor() {
                return descColor;
            }

            /**
             * <h2>来源文字的颜色</h2>
             *
             * @param descColor 来源文字的颜色
             * @see DescColor
             */
            public Source setDescColor(DescColor descColor) {
                this.descColor = descColor.getValue();
                return this;
            }

            public enum DescColor {
                GRAY(0),

                BLACK(1),

                RED(2),

                GREEN(3);

                private final int value;

                DescColor(int value) {
                    this.value = value;
                }

                public int getValue() {
                    return value;
                }
            }
        }

        public static class MainTitle {
            private String title;

            public String getTitle() {
                return title;
            }

            /**
             * <h2>一级标题</h2>
             *
             * @param title 一级标题
             * @apiNote 建议不超过26个字, <code>模版卡片主要内容的一级标题main_title.title和二级普通文本sub_title_text必须有一项填写</code
             */
            public MainTitle setTitle(String title) {
                this.title = title;
                return this;
            }

            private String desc;

            public String getDesc() {
                return desc;
            }

            /**
             * <h2>标题辅助信息</h2>
             *
             * @param desc 标题辅助信息
             * @apiNote 建议不超过30个字
             */
            public MainTitle setDesc(String desc) {
                this.desc = desc;
                return this;
            }
        }

        public static class EmphasisContent {
            private String title;

            public String getTitle() {
                return title;
            }

            /**
             * <h2>关键数据样式的数据内容</h2>
             *
             * @param title 关键数据样式的数据内容
             * @apiNote 建议不超过10个字
             */
            public EmphasisContent setTitle(String title) {
                this.title = title;
                return this;
            }

            private String desc;

            public String getDesc() {
                return desc;
            }

            /**
             * <h2>关键数据样式的数据描述内容</h2>
             *
             * @param desc 关键数据样式的数据描述内容
             * @apiNote 建议不超过15个字
             */
            public void setDesc(String desc) {
                this.desc = desc;
            }
        }

        public static class QuoteArea {
            private Integer type;

            public Integer getType() {
                return type;
            }

            /**
             * <h2>设置引用文献样式区域点击事件</h2>
             *
             * @param type 类型
             * @return QuoteArea
             * @see Type
             */
            public QuoteArea setType(Type type) {
                this.type = type.getValue();
                return this;
            }

            /**
             *
             */
            private String url;

            public String getUrl() {
                return url;
            }

            /**
             * <h2>点击跳转的url</h2>
             *
             * @param url 点击跳转的url
             * @apiNote <code>quote_area.type</code> 是 {@link Type#URL} 时必填
             */
            public QuoteArea setUrl(String url) {
                this.url = url;
                return this;
            }

            /**
             *
             */
            private String appid;

            public String getAppid() {
                return appid;
            }

            /**
             * <h2>点击跳转的小程序的appid</h2>
             *
             * @param appid 点击跳转的小程序的appid
             * @apiNote <code>quote_area.type</code> 是 {@link Type#MINI_PROGRAM} 时必填
             */
            public QuoteArea setAppid(String appid) {
                this.appid = appid;
                return this;
            }

            @JsonProperty("pagepath")
            private String pagePath;

            public String getPagePath() {
                return pagePath;
            }

            /**
             * <h2>点击跳转的小程序的pagePath</h2>
             *
             * @param pagePath 点击跳转的小程序的pagePath
             * @apiNote <code>quote_area.type</code> 是 {@link Type#MINI_PROGRAM} 时选填
             */
            public void setPagePath(String pagePath) {
                this.pagePath = pagePath;
            }

            /**
             * <h2>引用文献样式的标题</h2>
             */
            private String title;

            public String getTitle() {
                return title;
            }

            /**
             * <h2>引用文献样式的标题</h2>
             *
             * @param title 引用文献样式的标题
             */
            public QuoteArea setTitle(String title) {
                this.title = title;
                return this;
            }

            @JsonProperty("quote_text")
            private String quoteText;

            public String getQuoteText() {
                return quoteText;
            }

            /**
             * <h2>引用文献样式的引用文案</h2>
             *
             * @param quoteText 引用文献样式的引用文案
             */
            public void setQuoteText(String quoteText) {
                this.quoteText = quoteText;
            }

            public enum Type {
                /**
                 * <h2>无跳转</h2>
                 */
                NONE(0),

                /**
                 * <h2>跳转url</h2>
                 */
                URL(1),

                /**
                 * <h2>跳转小程序</h2>
                 */
                MINI_PROGRAM(2);

                private final int value;

                Type(int value) {
                    this.value = value;
                }

                public int getValue() {
                    return value;
                }
            }
        }
    }
}
