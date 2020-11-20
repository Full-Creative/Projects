
public class WordCounter implements Tokenizer {

	@Override
	public int countWords(String data) {
	int count=0;
	try{	
			if(data.length() == 0 || data == null)
				count = 0;	
		count = data.split(" ").length;
	}
	catch(NullPointerException e) { 
        System.out.println("NullPointerException.."); 
    }
	return count;
	}
}
