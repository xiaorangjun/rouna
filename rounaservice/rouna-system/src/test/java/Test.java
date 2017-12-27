import com.sun.jndi.ldap.Connection;
import org.apache.commons.lang.StringUtils;

import javax.lang.model.element.Element;
import javax.swing.text.Document;
import java.io.IOException;

/**
 * Created by Administrator on 2017/12/16.
 */
public class Test {
//    private static final String BASE_RRL = "https://www.caipiaokong.com/lottery/3.html";
//    public void lotteryProc() throws IOException {
//        Connection conn_login = Jsoup.connect(LOGGIN_RRL);
//
//        Map<String, String> map = new HashMap<String, String>();
//
//        Response response = null;
//        try {
//            response = conn_login.ignoreContentType(true).method(Method.POST).data(map).execute();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        Connection conn = null;
//        if(response!=null){
//            conn = Jsoup.connect(BASE_RRL).cookies(response.cookies());
//        }else {
//            conn = Jsoup.connect(BASE_RRL);
//        }
//        Document doc = conn.get();
//
//        Element els = null;
//        if (StringUtils.isNotEmpty(doc.select("table"))) {
//            try {
//                els = doc.select("table").get(0);
//            } catch (Exception e) {
//                logger.error(els);
//            }
//        }
//        if (StringUtils.isEmpty(els)) return;
//        Element freLotteryBody = els.select("tbody").get(0); // 高频彩
//        Elements trs = freLotteryBody.select("tr");
//
//        Element element = null;
//        for (int i = 1 ;i<trs.size();i++){
//            element = trs.get(i);
//            if (element.toString().contains("重庆时时彩")){
//                saveLotteryProc(element, LotteryTemp.CQ_SSC, element.getElementsByTag("td").get(3).text().substring(3, element.getElementsByTag("td").get(3).text().length() - 1));
//                continue;
//            }
//            if (element.toString().contains("山东11选5")){
//                saveLotteryProc(element, LotteryTemp._11_5, element.getElementsByTag("td").get(3).text().substring(3, element.getElementsByTag("td").get(3).text().length() - 1));
//                continue;
//            }
//            if (element.toString().contains("江西11选5")){
//                saveLotteryProc(element, LotteryTemp.JX_11_5, element.getElementsByTag("td").get(3).text().substring(3, element.getElementsByTag("td").get(3).text().length() - 1));
//                continue;
//            }
//            if (element.toString().contains("辽宁11选5")){
//                saveLotteryProc(element, LotteryTemp.LN_11_5 , element.getElementsByTag("td").get(3).text().substring(1, element.getElementsByTag("td").get(3).text().length() - 1));
//                continue;
//            }
//            if (element.toString().contains("广东11选5")){
//                saveLotteryProc(element, LotteryTemp.GD_11_5, element.getElementsByTag("td").get(3).text().substring(1, element.getElementsByTag("td").get(3).text().length() - 1));
//                continue;
//            }
//            if (element.toString().contains("黑龙江11选5")){
//                saveLotteryProc(element, LotteryTemp.HLJ_11_5 , element.getElementsByTag("td").get(3).text().substring(1, element.getElementsByTag("td").get(3).text().length() - 1));
//                continue;
//            }
//            if (element.toString().contains("浙江11选5")){
//                saveLotteryProc(element, LotteryTemp.ZJ_11_5, element.getElementsByTag("td").get(3).text().substring(1, element.getElementsByTag("td").get(3).text().length() - 1));
//                continue;
//            }
//            if (element.toString().contains("江苏快3")){
//                saveLotteryProc(element, LotteryTemp.JS_KUAI_3, element.getElementsByTag("td").get(3).text().substring(1, element.getElementsByTag("td").get(3).text().length() - 1));
//                continue;
//            }
//            if (element.toString().contains("广西快3")){
//                saveLotteryProc(element, LotteryTemp.GX_KUAI_3, "20" + element.getElementsByTag("td").get(3).text().substring(1, element.getElementsByTag("td").get(3).text().length() - 1));
//                continue;
//            }
//            if (element.toString().contains("湖北快3")){
//                saveLotteryProc(element, LotteryTemp.HB_KUAI_3, element.getElementsByTag("td").get(3).text().substring(3, element.getElementsByTag("td").get(3).text().length() - 1));
//                continue;
//            }
//            if (element.toString().contains("内蒙古快3")){
//                String nmgNum = element.getElementsByTag("td").get(3).text();
//                saveLotteryProc(element, LotteryTemp.NMG_KUAI_3, nmgNum.substring(1, 7) + "0" + nmgNum.substring(7, 9));
//                continue;
//            }
//            if (element.toString().contains("安徽快3")){
//                saveLotteryProc(element, LotteryTemp.AH_KUAI_3, element.getElementsByTag("td").get(3).text().substring(3, element.getElementsByTag("td").get(3).text().length() - 1));
//                continue;
//            }
//
//        }
//    }
//
//    public void saveLotteryProc(Element element, String spell, String lotteryNo) {
//        ProductQuery pq = new ProductQuery();
//        pq.setCts(new Date());
//        pq.setSpell(spell);
//        pq.setLotteryNo(lotteryNo);
//        pq.setFrom(2);
//        pq.setLotteryNums(element.getElementsByTag("td").get(4).text().replace(" ", ""));
//        try {
//            productService.updateQueryData(pq);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
