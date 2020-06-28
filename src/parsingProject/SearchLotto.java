package parsingProject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SearchLotto {
	int[] number = new int[45];		
	int[] bonus = new int[45];
	
	SearchLotto(){
		try {
			getCarName();
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("수행에 실패하였습니다.");
		}
	}

	public void getCarName() throws Exception {
		
		Document doc = Jsoup.connect("https://signalfire85.tistory.com/28").get();		
		Elements contents = doc.select("td.xl69");
		
		for(int i = 0; i < number.length; i++) {
			number[i] = 0;
			bonus[i] = 0;
		}
		
		int count = 0;
		
		for(Element content : contents) {
			if(!content.text().equals("")) {
				count++;
				int num = Integer.parseInt(content.text());
				if(count % 7 != 0) number[num - 1] += 1;
				else if(count % 7 == 0) bonus[num - 1] += 1;
			}			
		}		
				
		new MinLottoNumber(number, bonus);
	}
}
