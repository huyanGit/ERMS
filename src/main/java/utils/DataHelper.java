package utils;

import org.springframework.scheduling.quartz.SimpleTriggerBean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DataHelper {

    private static String base = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static String firstName = "赵钱孙李周吴郑王陈张韩杨";
    private static String girl = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍" +
            "红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛" +
            "艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣" +
            "婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融" +
            "园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫" +
            "芸菲寒伊亚宜可姬舒影荔枝思丽 ";
    private static String boy = "伟刚勇毅俊峰强军平保东文辉力明永健世广志" +
            "义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子" +
            "杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪" +
            "心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯" +
            "宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛" +
            "雄琛钧冠策腾楠榕风航弘";
    private static String[] road = "重庆大厦,黑龙江路,十梅庵街,遵义路,湘潭街,瑞金广场,仙山街,仙山东路,仙山西大厦,白沙河路,赵红广场,机场路,民航街,长城南路,流亭立交桥,虹桥广场,长城大厦,礼阳路,风岗街,中川路,白塔广场,兴阳路,文阳街,绣城路,河城大厦,锦城广场,崇阳街,华城路,康城街,正阳路,和阳广场,中城路,江城大厦,顺城路,安城街,山城广场,春城街".split(",");
    private static String email[] = {"@gmail.com", "@yahoo.com", "@msn.com",
            "@hotmail.com", "@ask.com" , "@live.com" , "@qq.com" ,"@mail.com",
            "@0355.net" , "@163.com" , "@163.net" , "@googlemail.com","@aol.com" };


    /**
     * 身份证
     * @return
     */
    public static String getID(){
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        sb.append(340100);
        for (int i = 0; i < 12; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public static int getNum(int start, int end) {
        return (int) (Math.random() * (end - start + 1) + start);
    }

    /**
     * 返回Pwd
     * @return
     * @ Min 最小长度
     * @ Max 最大长度
     */
    public static String getPwd(int Min, int Max) {
        int length = getNum(Min, Max);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = (int) (Math.random() * base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static String getEmail(int Min, int Max) {
        int length = getNum(Max, Max);
        int index = (int) (Math.random()*email.length);
        String second = email[index];
        length-=second.length();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = (int) (Math.random() * base.length());
            sb.append(base.charAt(number));
        }
        sb.append(second);
        return sb.toString();
    }

    /**
     * 返回手机号码
     */
    public static String[] telFirst="184,183,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");
    public static String getTel() {
        int index=getNum(0,telFirst.length-1);
        String first=telFirst[index];
        String second=String.valueOf(getNum(1,888)+10000).substring(1);
        String thrid=String.valueOf(getNum(1,9100)+10000).substring(1);
        return first+second+thrid;
    }
    /**
     * 返回年龄(16--46)
     * @return
     */
    public static int getAge(){
        int age = (int)(Math.ceil(Math.random()*30)+16);
        return age;
    }


    /**
     * 返回中文姓名
     */
    public static String name_sex = "男";  //姓名性别
    public static String getChineseName() {
        int index=getNum(0, firstName.length()-1);
        String first=firstName.substring(index, index+1);
        String str=boy;
        int length=boy.length();
        int sex=getNum(0,1);
        if(sex==0){
            str=girl;
            length=girl.length();
            name_sex = "女";
        }else {
            name_sex="男";
        }
        index=getNum(0,length-1);
        String second=str.substring(index, index+1);
        int hasThird=getNum(0,1);
        String third="";
        if(hasThird==1){
            index=getNum(0,length-1);
            third=str.substring(index, index+1);
        }
        return first+second+third;
    }

    /**
     * 返回地址
     * @return
     */
    public static String getAdress() {
        int index=getNum(0,road.length-1);
        String first=road[index];
        String second=String.valueOf(getNum(11,150))+"号";
        String third="-"+getNum(1,20)+"-"+getNum(1,10);
        return first+second+third;
    }

    /**
     * 输入当天等待编号职工的人数排名，返回工号
     * @param rank
     * @return
     */
    public static String  getJobNum(int rank){
        Date date = new Date();
        //获取三位编号
        String lastCode = String.format("%03d", rank);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String jobNumber = sdf.format(date)+lastCode;
        return  jobNumber;
    }


}
