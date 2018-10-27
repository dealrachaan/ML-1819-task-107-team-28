import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class TwitterGender {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("/home/doom/Desktop/Ethan/MachineLearningThing/Data.csv"));
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
		s.close();

		for(int j = 0; j<tweets.size(); j++){

			String[] tweet = tweets.get(j);

			for (String x : tweet) {
				
				if(j<5368) //5368 is the last female entry in the dataset
					femaleTweetWords.add(x);
				else
					maleTweetWords.add(x);
			}

		}

		ArrayList<String> exclusivelyFemaleWords = new ArrayList<String>();
		ArrayList<String> exclusivelyMaleWords = new ArrayList<String>();

		for (String w :femaleTweetWords) {

			if(!maleTweetWords.contains(w))
				exclusivelyFemaleWords.add(w);
			
		}

		for (String w :maleTweetWords) {

			if(!femaleTweetWords.contains(w))
				exclusivelyMaleWords.add(w);
			
		}

		System.out.println(femaleTweetWords.size() + " words used by women");
		System.out.println(maleTweetWords.size() + " words used by men");
		System.out.println(exclusivelyFemaleWords.size() + " words used only by women");
		System.out.println(exclusivelyMaleWords.size() + " words used only by men");
		
	}

}