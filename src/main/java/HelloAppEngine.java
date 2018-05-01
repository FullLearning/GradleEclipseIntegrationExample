import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class HelloAppEngine extends HttpServlet {
	
	static Logger log = Logger.getLogger(HelloAppEngine.class);

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		log.info("Hello James hello world");
		PrintWriter writer = res.getWriter();
		
		Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
		log.info(doc.title());
		Elements newsHeadlines = doc.select("#mp-itn b a");
		for (Element headline : newsHeadlines) {
		  log.info( 
		    headline.attr("title") + " -- " + headline.absUrl("href"));
		}

	
		writer.println("Hello world James Mortensen! How are you today?");
	}
}