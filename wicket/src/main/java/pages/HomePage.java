package pages;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.time.Duration;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

import java.awt.Button;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;
//	private int count = 0;
	
	private Model<Integer> count = new Model<>(0);
	
	private Model<String> titleModel = new Model<String>() {
		public String getObject () {
//			".article-content_headline"
			
			try {
				Document doc = Jsoup.connect("http://postimees.ee").get();
				Elements headlines = doc.select(".article-content__headline");
				int idx = (int)(headlines.size() * Math.random());
				return headlines.get(idx).text();
				
				
			} catch (Exception e) {
				return "doh";
			}
			
			
		}
	};
	
	private Label title = new Label("news", titleModel);
	
	private Label label = new Label("count", count) {
		@Override
		public boolean isVisible() {
			return count.getObject() % 2 == 0;
		}
	};

	public HomePage(final PageParameters parameters) {
		super(parameters);
		
		add(new BookmarkablePageLink<>("second-link", SecondPage.class));
		label.setOutputMarkupPlaceholderTag(true);
		label.setOutputMarkupId(true);
		add(label);
		// update every 5 sec with ajax
		title.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(5)));
		
		add(title);
		
		add(new AjaxLink<Integer>("increase", count){
			@Override
			public void onClick(AjaxRequestTarget t) {
				setModelObject(getModelObject() + 1);
				t.add(label);
			}
		});

		

    }

}
