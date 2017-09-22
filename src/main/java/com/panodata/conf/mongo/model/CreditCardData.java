package com.panodata.conf.mongo.model;

import java.util.List;

/**
 * Created by wp_sp on 2017/7/7.
 */
public class CreditCardData
{
    /**
     * banner : /source/image/fullImg/card.png
     * span : 潮鸭驾到 玩味百变
     * title : 光大小黄鸭酷黑主题信用卡
     * tag : [{"tagKey":"金卡"},{"tagKey":"人民币"},{"tagKey":"刷卡免年费"}]
     * detailItem : [{"title":"专享特权","text":[{"textKey":"积分兑换B.Duck保温杯或时尚背包"},{"textKey":"B.Duck店铺消费85折优惠"},{"textKey":"小黄鸭童趣主题卡面潮酷来袭"},{"textKey":"10元畅享汉堡王"},{"textKey":"10元抢格瓦拉电影票"},{"textKey":"屈臣氏购物满200立减50元"},{"textKey":"最高100万出行意外险"}],"p":"出行享受最高保额100万元的出行意外险。 客户只需使用B DUCK小黄鸭主题信用卡支付本人全额交通工具票款或80%以上旅游团费，或客户的以上费用由另一同行（指搭乘同班次、同一交通工具出行）的中国光大银行信用卡客户使用其本人中国光大银行信用卡代为支付，B DUCK小黄鸭主题信用卡客户即可获赠最高保额达100万元人民币的出行意外保险，为客户的出行提供安全保障。"},{"cardTitle":"基本信息","cardInfo":{"level":"金卡","type":"人民币","organization":"银联"},"rule":"普卡、金卡消费1元累计1积分，生日月消费1元累计2积分","freePeriod":"20天到50天 ","applyCondition":[{"appconKey":"1、申请人应为满足18周岁（含）至60周岁（含），且具有完全民事行为能力的中国公民；"},{"appconKey":"2、申请人应有正当职业且收入稳定。"}]},{"title":"信用卡相关费用","yearFee":"200元/年，免首年年费，当年消费三笔或累计金额2000元，免次年年费。","takeCash":"最高取现比例50%，取现手续费为取现金额的2.5%，最低境内取现费10元。","repayment":"最低还款金额为本月账单的10% ，日息0.05%","latePayment":"低于最低还款金额未还部分的5% ，最低收费15元/2美元/2欧元","overMaxMoney":"超过信用额度部分的5%","overPayment":"存入金额超出欠款的部分，取出时收取1%","mention":[{"mentionKey":"在填写申请信息时，请您务必将住宅及单位地址具体到街道名称及门牌号码，您填写的信息将仅用于本次信用卡申请，请放心填写。"},{"mentionKey":"收到您的信用卡申请，我行会尽快对资料进行审核，并以短信方式告知初审结果。"},{"mentionKey":"收到我行发送的面签通知短信后，请您本人携带有效期内的身份证原件亲自前往工作单位所在地的光大银行营业网点进行面签。"},{"mentionKey":"信用卡审批通过后，卡片将免费寄往您的工作单位。您可以通过多种渠道激活卡片：中国光大银行7X24小时全球服务热线4007-888-888、中国光大银行信用卡地带xyk.cebbank.com、网点柜台、手机银行等。"},{"mentionKey":"还款顺序为：服务费、滞纳金、超限费、利息、取现、已结转的分期付款金额、转账、消费的贷款本金和未结转的分期付款金额。如欲提前还清分期付款剩余款项，请致电4007-888-888，确认最终还款金额。（本提示不适用于乐惠金卡、非标准致尚卡）"}]}]
     */

    private String banner;
    private String span;
    private String title;
    private List<TagBean> tag;
    private List<DetailItemBean> detailItem;

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getSpan() {
        return span;
    }

    public void setSpan(String span) {
        this.span = span;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<TagBean> getTag() {
        return tag;
    }

    public void setTag(List<TagBean> tag) {
        this.tag = tag;
    }

    public List<DetailItemBean> getDetailItem() {
        return detailItem;
    }

    public void setDetailItem(List<DetailItemBean> detailItem) {
        this.detailItem = detailItem;
    }

    public static class TagBean {
        /**
         * tagKey : 金卡
         */

        private String tagKey;

        public String getTagKey() {
            return tagKey;
        }

        public void setTagKey(String tagKey) {
            this.tagKey = tagKey;
        }
    }

    public static class DetailItemBean {
        /**
         * title : 专享特权
         * text : [{"textKey":"积分兑换B.Duck保温杯或时尚背包"},{"textKey":"B.Duck店铺消费85折优惠"},{"textKey":"小黄鸭童趣主题卡面潮酷来袭"},{"textKey":"10元畅享汉堡王"},{"textKey":"10元抢格瓦拉电影票"},{"textKey":"屈臣氏购物满200立减50元"},{"textKey":"最高100万出行意外险"}]
         * p : 出行享受最高保额100万元的出行意外险。 客户只需使用B DUCK小黄鸭主题信用卡支付本人全额交通工具票款或80%以上旅游团费，或客户的以上费用由另一同行（指搭乘同班次、同一交通工具出行）的中国光大银行信用卡客户使用其本人中国光大银行信用卡代为支付，B DUCK小黄鸭主题信用卡客户即可获赠最高保额达100万元人民币的出行意外保险，为客户的出行提供安全保障。
         * cardTitle : 基本信息
         * cardInfo : {"level":"金卡","type":"人民币","organization":"银联"}
         * rule : 普卡、金卡消费1元累计1积分，生日月消费1元累计2积分
         * freePeriod : 20天到50天
         * applyCondition : [{"appconKey":"1、申请人应为满足18周岁（含）至60周岁（含），且具有完全民事行为能力的中国公民；"},{"appconKey":"2、申请人应有正当职业且收入稳定。"}]
         * yearFee : 200元/年，免首年年费，当年消费三笔或累计金额2000元，免次年年费。
         * takeCash : 最高取现比例50%，取现手续费为取现金额的2.5%，最低境内取现费10元。
         * repayment : 最低还款金额为本月账单的10% ，日息0.05%
         * latePayment : 低于最低还款金额未还部分的5% ，最低收费15元/2美元/2欧元
         * overMaxMoney : 超过信用额度部分的5%
         * overPayment : 存入金额超出欠款的部分，取出时收取1%
         * mention : [{"mentionKey":"在填写申请信息时，请您务必将住宅及单位地址具体到街道名称及门牌号码，您填写的信息将仅用于本次信用卡申请，请放心填写。"},{"mentionKey":"收到您的信用卡申请，我行会尽快对资料进行审核，并以短信方式告知初审结果。"},{"mentionKey":"收到我行发送的面签通知短信后，请您本人携带有效期内的身份证原件亲自前往工作单位所在地的光大银行营业网点进行面签。"},{"mentionKey":"信用卡审批通过后，卡片将免费寄往您的工作单位。您可以通过多种渠道激活卡片：中国光大银行7X24小时全球服务热线4007-888-888、中国光大银行信用卡地带xyk.cebbank.com、网点柜台、手机银行等。"},{"mentionKey":"还款顺序为：服务费、滞纳金、超限费、利息、取现、已结转的分期付款金额、转账、消费的贷款本金和未结转的分期付款金额。如欲提前还清分期付款剩余款项，请致电4007-888-888，确认最终还款金额。（本提示不适用于乐惠金卡、非标准致尚卡）"}]
         */

        private String title;
        private String p;
        private String cardTitle;
        private CardInfoBean cardInfo;
        private String rule;
        private String freePeriod;
        private String yearFee;
        private String takeCash;
        private String repayment;
        private String latePayment;
        private String overMaxMoney;
        private String overPayment;
        private List<TextBean> text;
        private List<ApplyConditionBean> applyCondition;
        private List<MentionBean> mention;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getP() {
            return p;
        }

        public void setP(String p) {
            this.p = p;
        }

        public String getCardTitle() {
            return cardTitle;
        }

        public void setCardTitle(String cardTitle) {
            this.cardTitle = cardTitle;
        }

        public CardInfoBean getCardInfo() {
            return cardInfo;
        }

        public void setCardInfo(CardInfoBean cardInfo) {
            this.cardInfo = cardInfo;
        }

        public String getRule() {
            return rule;
        }

        public void setRule(String rule) {
            this.rule = rule;
        }

        public String getFreePeriod() {
            return freePeriod;
        }

        public void setFreePeriod(String freePeriod) {
            this.freePeriod = freePeriod;
        }

        public String getYearFee() {
            return yearFee;
        }

        public void setYearFee(String yearFee) {
            this.yearFee = yearFee;
        }

        public String getTakeCash() {
            return takeCash;
        }

        public void setTakeCash(String takeCash) {
            this.takeCash = takeCash;
        }

        public String getRepayment() {
            return repayment;
        }

        public void setRepayment(String repayment) {
            this.repayment = repayment;
        }

        public String getLatePayment() {
            return latePayment;
        }

        public void setLatePayment(String latePayment) {
            this.latePayment = latePayment;
        }

        public String getOverMaxMoney() {
            return overMaxMoney;
        }

        public void setOverMaxMoney(String overMaxMoney) {
            this.overMaxMoney = overMaxMoney;
        }

        public String getOverPayment() {
            return overPayment;
        }

        public void setOverPayment(String overPayment) {
            this.overPayment = overPayment;
        }

        public List<TextBean> getText() {
            return text;
        }

        public void setText(List<TextBean> text) {
            this.text = text;
        }

        public List<ApplyConditionBean> getApplyCondition() {
            return applyCondition;
        }

        public void setApplyCondition(List<ApplyConditionBean> applyCondition) {
            this.applyCondition = applyCondition;
        }

        public List<MentionBean> getMention() {
            return mention;
        }

        public void setMention(List<MentionBean> mention) {
            this.mention = mention;
        }

        public static class CardInfoBean {
            /**
             * level : 金卡
             * type : 人民币
             * organization : 银联
             */

            private String level;
            private String type;
            private String organization;

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getOrganization() {
                return organization;
            }

            public void setOrganization(String organization) {
                this.organization = organization;
            }
        }

        public static class TextBean {
            /**
             * textKey : 积分兑换B.Duck保温杯或时尚背包
             */

            private String textKey;

            public String getTextKey() {
                return textKey;
            }

            public void setTextKey(String textKey) {
                this.textKey = textKey;
            }
        }

        public static class ApplyConditionBean {
            /**
             * appconKey : 1、申请人应为满足18周岁（含）至60周岁（含），且具有完全民事行为能力的中国公民；
             */

            private String appconKey;

            public String getAppconKey() {
                return appconKey;
            }

            public void setAppconKey(String appconKey) {
                this.appconKey = appconKey;
            }
        }

        public static class MentionBean {
            /**
             * mentionKey : 在填写申请信息时，请您务必将住宅及单位地址具体到街道名称及门牌号码，您填写的信息将仅用于本次信用卡申请，请放心填写。
             */

            private String mentionKey;

            public String getMentionKey() {
                return mentionKey;
            }

            public void setMentionKey(String mentionKey) {
                this.mentionKey = mentionKey;
            }
        }
    }
}
