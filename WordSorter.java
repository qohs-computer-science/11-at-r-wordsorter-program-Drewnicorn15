import java.io.File;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.SortedSet;
public class WordSorter 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in); 
		try
		{
			in = new Scanner(new File("article.txt"));	
		}
		catch(Exception e)
		{
			System.out.println("Cannot find file... Exiting Program");
			return;
		}	
		TreeSet<String> s= new TreeSet<String>();
        boolean a = false;
        boolean hasi = false;
		String word = "";
		while(in.hasNext())
		{
			word = in.next();
			word = word.toLowerCase();
			word = word.replace(",", "");
			word = word.replace("(tm)", "");
			word = word.replace(")", "");
			word = word.replace("(", "");
			word = word.replace(".", "");
			word = word.replace("'s", "");
			word = word.replace(":", "");
			word = word.replace("!", "");
			word = word.replace("?", "");
			word = word.replace("'", "");

            if(word.equals("a"))
                a = true;
            else if(word.equals("i"))
                hasi=true;
            s.add(word);
			System.out.println(word);
			
			
		}
		Scanner scan= new Scanner(System.in);
        String letters = "abcdefghijklmnopqurstuvwxyz";
        for(int i=0;i<letters.length();i++)
            s.add(""+letters.charAt(i));
		while(true){
            System.out.println("1. Print out all words starting with a specific letter \n2. Print out all words  \n3. Print out the total number of unique words \n4. Search and determine if a word is in the article \n5. Remove a word from the data structure  \n6. Exit \n Enter an option");
            
            int selected = scan.nextInt();
            scan.nextLine();
            if(selected ==1)
            {
                System.out.println("enter a letter");
                String letter = scan.nextLine();
		SortedSet<String> temp;
		temp = s.subSet(""+letter,""+letters.charAt(letters.indexOf(letter)+1));
		temp.remove(letter);
		if(letter.equals("a") && a)
		    System.out.print("a"+", ");
		else if(letter.equals("i") && hasi)
		    System.out.print("i"+", ");
		for(String thing:temp)
			System.out.print(thing+", ");
                System.out.println("");
            s.add(letter);
            }else if (selected == 2){
                for(String thing:s){
                if(thing.equals("a") && a)
		            System.out.print("a"+", ");
		        else if(thing.equals("i") && hasi)
		            System.out.print("i"+", ");
                if(thing.length()==1)
                continue;
                System.out.print(thing+", ");
                }
                System.out.println("");
            }else if (selected == 3){
                int count = 26;
                if(a)
                count--;
                if(hasi)
                count--;
                System.out.println(s.size()-count);
            }else if(selected == 4){
                System.out.println("enter a word");
                String guessword = scan.nextLine();
                if(guessword.equals("a") && a){
                    System.out.println("Yes "+guessword+" is in the article");
                    continue;
                }else if(guessword.equals("a")){
                    System.out.println("no "+guessword+" is in the article");
                    continue;
                }
                if(guessword.equals("i") && hasi){
                    System.out.println("Yes "+guessword+" is in the article");
                    continue;
                }else if(guessword.equals("i")){
                    System.out.println("no "+guessword+" is in the article");
                    continue;
                }
                if(s.contains(guessword))
                    System.out.println("Yes "+guessword+" is in the article");
                else
                    System.out.println("no "+guessword+" is in the article");
            }else if(selected == 5)
			{
				System.out.println("enter a word to remove");
                String toremove = scan.nextLine();
				if(toremove.equals("a"))
					if(a){
						a = false;
						System.out.println("Word successfully removed from the list");
					}else
					System.out.println("Word NOT found in the article");
				else if(toremove.equals("i"))
					if(hasi){
						hasi = false;
						System.out.println("Word successfully removed from the list");
					}else
					System.out.println("Word NOT found in the article");
				else if(s.contains(toremove)){
					s.remove(toremove);
					System.out.println("Word successfully removed from the list");
				}else
					System.out.println("Word not in List");
			}else if(selected == 6)
				break;
        }
		in.close();
		scan.close();
	}
}