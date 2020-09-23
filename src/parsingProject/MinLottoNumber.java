package parsingProject;
import java.util.Arrays;

public class MinLottoNumber {
	int[] prediction = new int[6];
	int p_bonus = 0;
	MinLottoNumber(int[] number, int[] bonus){
		int[] oldNumber = new int[45];
		int[] oldBonus = new int[45];	
		
        for(int i = 0; i < bonus.length; i++) {    	
	    	oldNumber[i] = number[i];
	    	oldBonus[i] = bonus[i];
	    }
        
		Arrays.sort(number);
		Arrays.sort(bonus);
		
		p_bonus = bonus[0];
		
	    for(int i = 0; i < 6; i++) {
	    	for(int j = 0; j < oldNumber.length; j++) {
	    		if(number[i] == oldNumber[j]) {	    			
	    			prediction[i] = j + 1;
	    			oldNumber[j] = -1;
	    			break;
	    		}
	    	}
	    	
	    }
	    
	    for(int i = 0; i < bonus.length; i++) {
	    	if(p_bonus == oldBonus[i]) {
	    		p_bonus = i + 1;
	    		break;
	    	}
	    }

	   NumberPrint();
	}
	
	public void NumberPrint() {
		Arrays.sort(prediction);
		System.out.println("예상 번호");
		for(int i = 0; i < 5; i++) {
	    	System.out.print(prediction[i] + " ");
	    }
		System.out.print("보너스 번호 : " + p_bonus);
	}
}
