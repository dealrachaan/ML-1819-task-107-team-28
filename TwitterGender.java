

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class TwitterGender {

//master
	public static void main(String[] args) throws FileNotFoundException {
		//String of 100 most common words in English from https://gist.github.com/gravitymonkey/2406023
		String[] commonWords = {"the","of","and","a","to","in","is","you","that","it","he","was","for","on","are","as","with","his","they","I","at","be","this","have","from","or","one","had","by","word","but","not","what","all","were","we","when","your","can","said","there","use","an","each","which","she","do","how","their","if","will","up","other","about","out","many","then","them","these","so","some","her","would","make","like","him","into","time","has","look","two","more","write","go","see","number","no","way","could","people","my","than","first","water","been","call","who","oil","its","now","find","long","down","day","did","get","come","made","may","part"};

		ArrayList<String> common = new ArrayList<String>();

		for (String w : commonWords) {

			common.add(w); 
			
		}

		Scanner s = new Scanner(new File("TrainingData.csv"));
		s.useDelimiter(",");
		
		ArrayList<String> genders = new ArrayList<String>();
		ArrayList<String[]> tweets = new ArrayList<String[]>();
		ArrayList<String> femaleTweetWords = new ArrayList<String>();
		ArrayList<String> maleTweetWords = new ArrayList<String>();

		int i = 1;
		while(s.hasNext()){
		
			if(i%2!=0){
				String gender = s.next();
				genders.add(gender);

			}
				
			else {
				String tweet = s.next();
				String[] tweetWords = tweet.split(" ");
				tweets.add(tweetWords);
			}
				
            i++;
        }
		s.reset();

		for(int j = 0; j<tweets.size(); j++){

			String[] tweet = tweets.get(j);

			for (String x : tweet) {
				
				//if(genders.get(j)=="female") 
				if(j<4500)
					femaleTweetWords.add(x);
				else
					maleTweetWords.add(x);
			}

		}

		ArrayList<String> exclusivelyFemaleWords = new ArrayList<String>();
		ArrayList<String> exclusivelyMaleWords = new ArrayList<String>();

		for (String w :femaleTweetWords) {

			if(!maleTweetWords.contains(w) && !common.contains(w))
				exclusivelyFemaleWords.add(w);
			
		}

		for (String w :maleTweetWords) {

			if(!femaleTweetWords.contains(w) && !common.contains(w))
				exclusivelyMaleWords.add(w);
			
		}

		System.out.println(femaleTweetWords.size() + " words used by women");
		System.out.println(maleTweetWords.size() + " words used by men");
		System.out.println(exclusivelyFemaleWords.size() + " words used only by women");
		System.out.println(exclusivelyMaleWords.size() + " words used only by men");
		
	
	//read tweet and assess gender
	//assume male unless contains female word
	
	Scanner s1 = new Scanner(new File("TestData.csv"));
	s1.useDelimiter(",");
	int trueGender = -1;
	int guessGender = -1;
	String tweet = "";
	ArrayList<String> tweetWords = new ArrayList<String>();
	double tweetCount = 0; //item [1] and every second item thereafter in test data is Tweet text
	double correct = 0;
	
	int k =1;
	while(s1.hasNext()){ 
		
		tweetCount++;
		tweetWords.clear();
		
		if(k<500)
			trueGender = 1;
		else
			trueGender = 0;
		
		
		tweet = s1.next();
		
		String[] splitTweet = tweet.split(" ");
		for (String x : splitTweet){
			tweetWords.add(x);
		}
		for (i=0; i<tweetWords.size(); i++){
			if(exclusivelyFemaleWords.contains(tweetWords.get(i))){
				guessGender = 1;
			}
		}
		if(guessGender!=1){
			guessGender = 0;
		}
		
		if (guessGender==trueGender){
			correct++;
			//System.out.println(correct);
		}
		//System.out.println("guessed: " + guessGender);
		//System.out.println("actual: " + trueGender);
		
		k++;
			}
			
	double accuracy = (100/tweetCount)*correct;
	System.out.println(accuracy +"% accuracy.");

	s.close();
	s1.close();
//
	}
}
