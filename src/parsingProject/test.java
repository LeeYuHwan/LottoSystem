package parsingProject;

import org.jsoup.Connection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class LottoNumber {
	
	LottoNumber() {
		try {
			GetNumber();
		}catch(Exception e) {
			System.out.println("Error!");
		}
	}
	
	public void GetNumber() throws Exception{
		Document doc; 
		Elements contents;
		for(int i = 1; i < 2; i++) {
			doc = Jsoup.connect("https://dhlottery.co.kr/gameResult.do?method=byWin&drwNo="+i).get();
			contents = doc.select("span.ball_645");
			for(Element content : contents){
				int ans = Integer.parseInt(content.text());
				System.out.println(ans);
				
			}
			
			contents = doc.select("#bnusNo");
			System.out.println("[B] : "+contents.text());
		}			 
		
		
	}
} // contents.text() = text 값 출력
//attr("alt") = alt의 구성요소 출력

public class test {
	public static void main(String[] args) {
		new LottoNumber();
	}
}