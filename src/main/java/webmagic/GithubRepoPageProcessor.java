package webmagic;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.IOException;

/**
 * Created by zdsoft on 14-6-27.
 */
public class GithubRepoPageProcessor implements PageProcessor {



    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {
//        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
//        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
//        page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
//        if (page.getResultItems().get("name")==null){
//            //skip this page
//            page.setSkip(true);
//        }
//        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));

        page.addTargetRequests(page.getHtml().links().regex(path).all());
//        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
        page.putField("name", page.getHtml().xpath("//div[@id='loadmoreindexdata']/text()").toString());
        if (page.getResultItems().get("name")==null){
            //skip this page
            page.setSkip(true);
        }
//        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {

        getJsoup();


//        Spider.create(new GithubRepoPageProcessor())
////                .addUrl("https://github.com/code4craft")
//                .addUrl(path)
////                .addPipeline(new JsonFilePipeline("/Users/zdsoft/Desktop/webmagic"))
////                .addPipeline(new FilePipeline("/Users/zdsoft/Desktop/webmagic"))
//                .addPipeline(new ConsolePipeline())
//                .thread(5)
//                .run();
    }




    private static final String path = "http://bbs.iheima.com/";
    private static void getJsoup(){
        try {
            Document doc = Jsoup.connect(path).get();
            String title = doc.title();
            Element element = doc.getElementById("loadmoreindexdata");
            Elements tables = element.getElementsByTag("table");
            Element table = tables.get(0);

            Elements tbodys = table.getElementsByTag("tbody");
            for (Element tBody : tbodys){
                getArticle(tBody);
            }

            System.out.println(title);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void getArticle(Element tBody){
        String tagCssTitle = "a.cr_xst";
        String tagCssContent = "th.summary";
        String span = "-------------------------\n------------------";

        //标题
        Element title = tBody.select(tagCssTitle).first();
        String t = title.text();

        //文章链接
        String l = title.attr("href");
        //内容
        Element content = tBody.select(tagCssContent).first();
        String c = content.text();


        System.out.println(l);
        System.out.println(t);
        System.out.println(c);
        System.out.println(span);

    }
}
