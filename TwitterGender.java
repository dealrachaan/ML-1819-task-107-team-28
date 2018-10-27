// read tweets from male and female Twitter users
// denote (100? 1000?) most common words exclusive to male and female users
// read future tweets by scanning for presence of these keywords

import java.util.*

//String of 100 most common words in English from https://gist.github.com/gravitymonkey/2406023
String[] common = {"the","of","and","a","to","in","is","you","that","it","he","was","for","on","are","as","with","his","they","I","at","be","this","have","from","or","one","had","by","word","but","not","what","all","were","we","when","your","can","said","there","use","an","each","which","she","do","how","their","if","will","up","other","about","out","many","then","them","these","so","some","her","would","make","like","him","into","time","has","look","two","more","write","go","see","number","no","way","could","people","my","than","first","water","been","call","who","oil","its","now","find","long","down","day","did","get","come","made","may","part"};

//female data: 2D ArrayList of entry objects
//for each word: if not in common, increment Entry count of word or make new Entry
String[] entry = new String[2]; 

ArrayList<String[]> fList = new ArrayList<String[]>();

//get word
if (common.contains(word) == FALSE){
    if(contained(word) != NULL){
        i = contained(word);
        fList[i][0] = fList[i][0] +1;
    }
    else{
        fList.add(new String[] {"1", word});
    }
}
        
//check if fList contains word
public static int contained (word){
    size = fList.size();
        for (int i=0; i<size; i++){
            if fList[i][1] == word{
                return i;
            }
        }
    return NULL;
}

//male data: 2D ArrayList of entry objects
//for each word: if not in common, increment Entry count of word or make new Entry
