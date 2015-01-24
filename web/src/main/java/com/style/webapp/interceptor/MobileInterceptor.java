package com.style.webapp.interceptor;

import com.style.Constants;
import com.style.webapp.action.BaseAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MobileInterceptor implements Interceptor {

    @Override
    public void destroy() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void init() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        String namespace = invocation.getProxy().getNamespace();
        String hostName = request.getHeader("HOST");

        String tabletRegEx = "(.*)(ipad|ipad.*mobile|android.*nexus[\\s]+(7|10)|^.*android.*nexus(?:(?!mobile).)*$|samsung.*tablet|galaxy.*tab|sc-01c|gt-p1000|gt-p1003|gt-p1010|gt-p3105|gt-p6210|gt-p6800|gt-p6810|gt-p7100|gt-p7300|gt-p7310|gt-p7500|gt-p7510|sch-i800|sch-i815|sch-i905|sgh-i957|sgh-i987|sgh-t849|sgh-t859|sgh-t869|sph-p100|gt-p3100|gt-p3108|gt-p3110|gt-p5100|gt-p5110|gt-p6200|gt-p7320|gt-p7511|gt-n8000|gt-p8510|sgh-i497|sph-p500|sgh-t779|sch-i705|sch-i915|gt-n8013|gt-p3113|gt-p5113|gt-p8110|gt-n8010|gt-n8005|gt-n8020|gt-p1013|gt-p6201|gt-p7501|gt-n5100|gt-n5105|gt-n5110|shv-e140k|shv-e140l|shv-e140s|shv-e150s|shv-e230k|shv-e230l|shv-e230s|shw-m180k|shw-m180l|shw-m180s|shw-m180w|shw-m300w|shw-m305w|shw-m380k|shw-m380s|shw-m380w|shw-m430w|shw-m480k|shw-m480s|shw-m480w|shw-m485w|shw-m486w|shw-m500w|gt-i9228|sch-p739|sch-i925|gt-i9200|gt-i9205|gt-p5200|gt-p5210|gt-p5210x|sm-t311|sm-t310|sm-t310x|sm-t210|sm-t210r|sm-t211|sm-p600|sm-p601|sm-p605|sm-p900|sm-p901|sm-t217|sm-t217a|sm-t217s|sm-p6000|sm-t3100|sgh-i467|xe500|sm-t110|gt-p5220|gt-i9200x|gt-n5110x|gt-n5120|sm-p905|sm-t111|sm-t2105|sm-t315|sm-t320|sm-t320x|sm-t321|sm-t520|sm-t525|sm-t530nu|sm-t230nu|sm-t330nu|sm-t900|xe500t1c|sm-p605v|sm-p905v|sm-p600x|sm-p900x|sm-t210x|sm-t230|sm-t230x|sm-t325|gt-p7503|sm-t531|sm-t330|sm-t530|sm-t705c|sm-t535|sm-t331|kindle|silk.*accelerated|android.*\\b(kfot|kftt|kfjwi|kfjwa|kfote|kfsowi|kfthwi|kfthwa|kfapwi|kfapwa|wfjwae)\\b|windows nt [0-9.]+; arm;|hp slate 7|hp elitepad 900|hp-tablet|elitebook.*touch|hp 8|^.*padfone((?!mobile).)*$|transformer|tf101|tf101g|tf300t|tf300tg|tf300tl|tf700t|tf700kl|tf701t|tf810c|me171|me301t|me302c|me371mg|me370t|me372mg|me172v|me173x|me400c|slider sl101|\\bk00f\\b|tx201la|playbook|rim tablet|htc flyer|htc jetstream|htc-p715a|htc evo view 4g|pg41200|xoom|sholest|mz615|mz605|mz505|mz601|mz602|mz603|mz604|mz606|mz607|mz608|mz609|mz615|mz616|mz617|android.*nook|nookcolor|nook browser|bnrv200|bnrv200a|bntv250|bntv250a|bntv400|bntv600|logicpd zoom2|android.*; \\b(a100|a101|a110|a200|a210|a211|a500|a501|a510|a511|a700|a701|w500|w500p|w501|w501p|w510|w511|w700|g100|g100w|b1-a71|b1-710|b1-711|a1-810|a1-830)\\b|w3-810|\\ba3-a10\\b|android.*(at100|at105|at200|at205|at270|at275|at300|at305|at1s5|at500|at570|at700|at830)|toshiba.*folio|\\bl-06c|lg-v900|lg-v500|lg-v909|lg-v500|lg-v510|lg-vk810\\b|android.*\\b(f-01d|f-02f|f-05e|f-10d|m532|q572)\\b|pmp3170b|pmp3270b|pmp3470b|pmp7170b|pmp3370b|pmp3570c|pmp5870c|pmp3670b|pmp5570c|pmp5770d|pmp3970b|pmp3870c|pmp5580c|pmp5880d|pmp5780d|pmp5588c|pmp7280c|pmp7280c3g|pmp7280|pmp7880d|pmp5597d|pmp5597|pmp7100d|per3464|per3274|per3574|per3884|per5274|per5474|pmp5097cpro|pmp5097|pmp7380d|pmp5297c|pmp5297c_quad|ideatab|thinkpad([ ]+)?tablet|lenovo.*(s2109|s2110|s5000|s6000|k3011|a3000|a1000|a2107|a2109|a1107|b6000|b8000|b8080-f)|android.*\\b(tab210|tab211|tab224|tab250|tab260|tab264|tab310|tab360|tab364|tab410|tab411|tab420|tab424|tab450|tab460|tab461|tab464|tab465|tab467|tab468|tab07-100|tab07-101|tab07-150|tab07-151|tab07-152|tab07-200|tab07-201-3g|tab07-210|tab07-211|tab07-212|tab07-214|tab07-220|tab07-400|tab07-485|tab08-150|tab08-200|tab08-201-3g|tab08-201-30|tab09-100|tab09-211|tab09-410|tab10-150|tab10-201|tab10-211|tab10-400|tab10-410|tab13-201|tab274euk|tab275euk|tab374euk|tab462euk|tab474euk|tab9-200)\\b|android.*\\boyo\\b|life.*(p9212|p9514|p9516|s9512)|lifetab|an10g2|an7bg3|an7fg3|an8g3|an8cg3|an7g3|an9g3|an7dg3|an7dg3st|an7dg3childpad|an10bg3|an10bg3dt|inm8002kp|inm1010fp|inm805nd|intenso tab|m702pro|megafon v9|\\bzte v9\\b|android.*\\bmt7a\\b|e-boda (supreme|impresspeed|izzycomm|essential)|allview.*(viva|alldro|city|speed|all tv|frenzy|quasar|shine|tx1|ax1|ax2)|\\b(101g9|80g9|a101it)\\b|qilive 97r|archos 101g10|archos 101 neon|novo7|novo8|novo10|novo7aurora|novo7basic|novo7paladin|novo9-spark|sony.*tablet|xperia tablet|sony tablet s|so-03e|sgpt12|sgpt13|sgpt114|sgpt121|sgpt122|sgpt123|sgpt111|sgpt112|sgpt113|sgpt131|sgpt132|sgpt133|sgpt211|sgpt212|sgpt213|sgp311|sgp312|sgp321|ebrd1101|ebrd1102|ebrd1201|sgp351|sgp341|sgp511|sgp512|sgp521|sgp541|sgp551|android.*(k8gt|u9gt|u10gt|u16gt|u17gt|u18gt|u19gt|u20gt|u23gt|u30gt)|cube u8gt|mid1042|mid1045|mid1125|mid1126|mid7012|mid7014|mid7015|mid7034|mid7035|mid7036|mid7042|mid7048|mid7127|mid8042|mid8048|mid8127|mid9042|mid9740|mid9742|mid7022|mid7010|m9701|m9000|m9100|m806|m1052|m806|t703|mid701|mid713|mid710|mid727|mid760|mid830|mid728|mid933|mid125|mid810|mid732|mid120|mid930|mid800|mid731|mid900|mid100|mid820|mid735|mid980|mid130|mid833|mid737|mid960|mid135|mid860|mid736|mid140|mid930|mid835|mid733|android.*(\\bmid\\b|mid-560|mtv-t1200|mtv-pnd531|mtv-p1101|mtv-pnd530)|android.*(rk2818|rk2808a|rk2918|rk3066)|rk2738|rk2808a|iq310|fly vision|bq.*(elcano|curie|edison|maxwell|kepler|pascal|tesla|hypatia|platon|newton|livingstone|cervantes|avant)|maxwell.*lite|maxwell.*plus|mediapad|mediapad 7 youth|ideos s7|s7-201c|s7-202u|s7-101|s7-103|s7-104|s7-105|s7-106|s7-201|s7-slim|\\bn-06d|\\bn-08d|pantech.*p4100|broncho.*(n701|n708|n802|a710)|touchpad.*[78910]|\\btouchtab\\b|z1000|z99 2g|z99|z930|z999|z990|z909|z919|z900|tb07sta|tb10sta|tb07fta|tb10fta|android.*\\bnabi|kobo touch|\\bk080\\b|\\bvox\\b build|\\barc\\b build|dslide.*\\b(700|701r|702|703r|704|802|970|971|972|973|974|1010|1012)\\b|navipad|tb-772a|tm-7045|tm-7055|tm-9750|tm-7016|tm-7024|tm-7026|tm-7041|tm-7043|tm-7047|tm-8041|tm-9741|tm-9747|tm-9748|tm-9751|tm-7022|tm-7021|tm-7020|tm-7011|tm-7010|tm-7023|tm-7025|tm-7037w|tm-7038w|tm-7027w|tm-9720|tm-9725|tm-9737w|tm-1020|tm-9738w|tm-9740|tm-9743w|tb-807a|tb-771a|tb-727a|tb-725a|tb-719a|tb-823a|tb-805a|tb-723a|tb-715a|tb-707a|tb-705a|tb-709a|tb-711a|tb-890hd|tb-880hd|tb-790hd|tb-780hd|tb-770hd|tb-721hd|tb-710hd|tb-434hd|tb-860hd|tb-840hd|tb-760hd|tb-750hd|tb-740hd|tb-730hd|tb-722hd|tb-720hd|tb-700hd|tb-500hd|tb-470hd|tb-431hd|tb-430hd|tb-506|tb-504|tb-446|tb-436|tb-416|tb-146se|tb-126se|playstation.*(portable|vita)|st10416-1|vt10416-1|st70408-1|st702xx-1|st702xx-2|st80208|st97216|st70104-2|vt10416-2|st10216-2a|\\b(ptbl10ceu|ptbl10c|ptbl72bc|ptbl72bceu|ptbl7ceu|ptbl7c|ptbl92bc|ptbl92bceu|ptbl9ceu|ptbl9cuk|ptbl9c)\\b|android.* \\b(e3a|t3x|t5c|t5b|t3e|t3c|t3b|t1j|t1f|t2a|t1h|t1i|e1c|t1-e|t5-a|t4|e1-b|t2ci|t1-b|t1-d|o1-a|e1-a|t1-a|t3a|t4i)\\b |genius tab g3|genius tab s2|genius tab q3|genius tab g4|genius tab q4|genius tab g-ii|genius tab gii|genius tab giii|genius tab s1|android.*\\bg1\\b|funbook|micromax.*\\b(p250|p560|p360|p362|p600|p300|p350|p500|p275)\\b|android.*\\b(a39|a37|a34|st8|st10|st7|smart tab3|smart tab2)\\b|fine7 genius|fine7 shine|fine7 air|fine8 style|fine9 more|fine10 joy|fine11 wide|\\b(pem63|plt1023g|plt1041|plt1044|plt1044g|plt1091|plt4311|plt4311pl|plt4315|plt7030|plt7033|plt7033d|plt7035|plt7035d|plt7044k|plt7045k|plt7045kb|plt7071kg|plt7072|plt7223g|plt7225g|plt7777g|plt7810k|plt7849g|plt7851g|plt7852g|plt8015|plt8031|plt8034|plt8036|plt8080k|plt8082|plt8088|plt8223g|plt8234g|plt8235g|plt8816k|plt9011|plt9045k|plt9233g|plt9735|plt9760g|plt9770g)\\b|bq1078|bc1003|bc1077|rk9702|bc9730|bc9001|it9001|bc7008|bc7010|bc708|bc728|bc7012|bc7030|bc7027|bc7026|tpc7102|tpc7103|tpc7105|tpc7106|tpc7107|tpc7201|tpc7203|tpc7205|tpc7210|tpc7708|tpc7709|tpc7712|tpc7110|tpc8101|tpc8103|tpc8105|tpc8106|tpc8203|tpc8205|tpc8503|tpc9106|tpc9701|tpc97101|tpc97103|tpc97105|tpc97106|tpc97111|tpc97113|tpc97203|tpc97603|tpc97809|tpc97205|tpc10101|tpc10103|tpc10106|tpc10111|tpc10203|tpc10205|tpc10503|tx-a1301|tx-m9002|q702|kf026|tab-p506|tab-navi-7-3g-m|tab-p517|tab-p-527|tab-p701|tab-p703|tab-p721|tab-p731n|tab-p741|tab-p825|tab-p905|tab-p925|tab-pr945|tab-pl1015|tab-p1025|tab-pi1045|tab-p1325|tab-protab[0-9]+|tab-protab25|tab-protab26|tab-protab27|tab-protab26xl|tab-protab2-ips9|tab-protab30-ips9|tab-protab25xxl|tab-protab26-ips10|tab-protab30-ips10|ov-(steelcore|newbase|basecore|baseone|exellen|quattor|edutab|solution|action|basictab|teddytab|magictab|stream|tb-08|tb-09)|hcl.*tablet|connect-3g-2.0|connect-2g-2.0|me tablet u1|me tablet u2|me tablet g1|me tablet x1|me tablet y2|me tablet sync|dps dream 9|dps dual 7|v97 hd|i75 3g|visture v4( hd)?|visture v5( hd)?|visture v10|ctp(-)?810|ctp(-)?818|ctp(-)?828|ctp(-)?838|ctp(-)?888|ctp(-)?978|ctp(-)?980|ctp(-)?987|ctp(-)?988|ctp(-)?989|\\bmt8125|mt8389|mt8135|mt8377\\b|concorde([ ]+)?tab|concorde readman|goclever tab|a7goclever|m1042|m7841|m742|r1042bk|r1041|tab a975|tab a7842|tab a741|tab a741l|tab m723g|tab m721|tab a1021|tab i921|tab r721|tab i720|tab t76|tab r70|tab r76.2|tab r106|tab r83.2|tab m813g|tab i721|gcta722|tab i70|tab i71|tab s73|tab r73|tab r74|tab r93|tab r75|tab r76.1|tab a73|tab a93|tab a93.2|tab t72|tab r83|tab r974|tab r973|tab a101|tab a103|tab a104|tab a104.2|r105bk|m713g|a972bk|tab a971|tab r974.2|tab r104|tab r83.3|tab a1042|freetab 9000|freetab 7.4|freetab 7004|freetab 7800|freetab 2096|freetab 7.5|freetab 1014|freetab 1001 |freetab 8001|freetab 9706|freetab 9702|freetab 7003|freetab 7002|freetab 1002|freetab 7801|freetab 1331|freetab 1004|freetab 8002|freetab 8014|freetab 9704|freetab 1003|\\b(argus[ _]?s|diamond[ _]?79hd|emerald[ _]?78e|luna[ _]?70c|onyx[ _]?s|onyx[ _]?z|orin[ _]?hd|orin[ _]?s|otis[ _]?s|speedstar[ _]?s|magnet[ _]?m9|primus[ _]?94[ _]?3g|primus[ _]?94hd|primus[ _]?qs|android.*\\bq8\\b|sirius[ _]?evo[ _]?qs|sirius[ _]?qs|spirit[ _]?s)\\b|v07ot2|tm105a|s10ot1|tr10cs1|ezee[_']?(tab|go)[0-9]+|tablc7|looney tunes tab|smarttab([ ]+)?[0-9]+|smarttabii10|smart[ ']?tab[ ]+?[0-9]+|family[ ']?tab2|rm-790|rm-997|rmd-878g|rmd-974r|rmt-705a|rmt-701|rme-601|rmt-501|rmt-711|i-mobile i-note|tolino tab [0-9.]+|tolino shine|android.* (skypad|phoenix|cyclops)|tecno p9|android.*\\b(f3000|a3300|jxd5000|jxd3000|jxd2000|jxd300b|jxd300|s5800|s7800|s602b|s5110b|s7300|s5300|s602|s603|s5100|s5110|s601|s7100a|p3000f|p3000s|p101|p200s|p1000m|p200m|p9100|p1000s|s6600b|s908|p1000|p300|s18|s6600|s9100)\\b|tablet (spirit 7|essentia|galatea|fusion|onix 7|landa|titan|scooby|deox|stella|themis|argon|unique 7|sygnus|hexen|finity 7|cream|cream x2|jade|neon 7|neron 7|kandy|scape|saphyr 7|rebel|biox|rebel|rebel 8gb|myst|draco 7|myst|tab7-004|myst|tadeo jones|tablet boing|arrow|draco dual cam|aurix|mint|amity|revolution|finity 9|neon 9|t9w|amity 4gb dual cam|stone 4gb|stone 8gb|andromeda|silken|x2|andromeda ii|halley|flame|saphyr 9,7|touch 8|planet|triton|unique 10|hexen 10|memphis 4gb|memphis 8gb|onix 10)|fx2 pad7|fx2 pad10|kidspad 701|pad[ ]?712|pad[ ]?714|pad[ ]?716|pad[ ]?717|pad[ ]?718|pad[ ]?720|pad[ ]?721|pad[ ]?722|pad[ ]?790|pad[ ]?792|pad[ ]?900|pad[ ]?9715d|pad[ ]?9716dr|pad[ ]?9718dr|pad[ ]?9719qr|pad[ ]?9720qr|telepad1030|telepad1032|telepad730|telepad731|telepad732|telepad735q|telepad830|telepad9730|telepad795|megapad 1331|megapad 1851|megapad 2151|viewpad 10pi|viewpad 10e|viewpad 10s|viewpad e72|viewpad7|viewpad e100|viewpad 7e|viewsonic vb733|vb100a|loox|xeno10|odys space)(.*)";
        String mobileRegEx1 = "(?i)(.*)((android|bb\\d+|meego).+mobile|avantgo|bada\\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|iris|kindle|lge |maemo|midp|mmp|mobile.+firefox|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\\.(browser|link)|vodafone|wap|windows ce|xda|xiino)(.*)";
        String mobileRegEx2 = "(?i)(.*)(1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\\-(n|u)|c55\\/|capi|ccwa|cdm\\-|cell|chtm|cldc|cmd\\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\\-s|devi|dica|dmob|do(c|p)o|ds(12|\\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\\-|_)|g1 u|g560|gene|gf\\-5|g\\-mo|go(\\.w|od)|gr(ad|un)|haie|hcit|hd\\-(m|p|t)|hei\\-|hi(pt|ta)|hp( i|ip)|hs\\-c|ht(c(\\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\\-(20|go|ma)|i230|iac( |\\-|\\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\\/)|klon|kpt |kwc\\-|kyo(c|k)|le(no|xi)|lg( g|\\/(k|l|u)|50|54|\\-[a-w])|libw|lynx|m1\\-w|m3ga|m50\\/|ma(te|ui|xo)|mc(01|21|ca)|m\\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\\-2|po(ck|rt|se)|prox|psio|pt\\-g|qa\\-a|qc(07|12|21|32|60|\\-[2-7]|i\\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\\-|oo|p\\-)|sdk\\/|se(c(\\-|0|1)|47|mc|nd|ri)|sgh\\-|shar|sie(\\-|m)|sk\\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\\-|v\\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\\-|tdg\\-|tel(i|m)|tim\\-|t\\-mo|to(pl|sh)|ts(70|m\\-|m3|m5)|tx\\-9|up(\\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\\-|your|zeto|zte\\-)(.*)";
        String ua=request.getHeader("User-Agent").toLowerCase();

        //setting up session variable mobileSite to request parameter is its there else set to true if url having "/m" , by default it will be false
        if(session.getAttribute("mobileSite") == null){         // Adding this null check since mobileSite attribute has been overwrited because recursive call of this interceptors.

            if(request.getParameter("mobileSite") != null) {
                session.setAttribute("mobileSite",request.getParameter("mobileSite"));
            }
            else if(ua.matches(tabletRegEx)) {
                session.setAttribute("mobileSite","false");
            }
            else if(ua.matches(mobileRegEx1) || ua.substring(0,4).matches(mobileRegEx2)) {
                session.setAttribute("mobileSite","true");
            }
            else {
                session.setAttribute("mobileSite","false");
            }
        }
//        Resetting mobileSite as false when user switch to desktop view
        if(request.getParameter("mobileSite")!=null){
            session.setAttribute("mobileSite", request.getParameter("mobileSite"));
        }

        session.setAttribute("mobileWapSite", "false");



        if ((invocation.getAction()) instanceof BaseAction) {
            ((BaseAction) invocation.getAction()).setMobileSite(session.getAttribute("mobileSite").equals("true"));
            ((BaseAction) invocation.getAction()).setMobileWapSite(session.getAttribute("mobileWapSite").equals("true"));
        }
        return invocation.invoke();
    }
}