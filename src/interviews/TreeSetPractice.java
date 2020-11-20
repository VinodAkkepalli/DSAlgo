package interviews;

/**
 * Problem :
Chotu's father is the owner of a Vada Pav shop. One Sunday, his father takes him to the shop. 
Father tells him that at the end of the day, Chotu has to give him a list consisting of the names of all the customers 
on that day who bought Vada Pav(s) from the shop. The list should not have the names of any of the customers being repeated and 
it should be such that the lexicographically smallest name comes first, ie., the names should be sorted in dictionary order.

As and when a particular customer buys a Vada Pav, Chotu writes down the name of that particular customer. 
Chotu's initial list is ready, but, he is confused as to how to make the list Father expects from him. 
Chotu comes to you for help. Your job now is to create the final list, as Father expects from Chotu.

Input :
First line consists of N, the number of names of customers in Chotu's initial list. The next N lines are such that each line consists of a customer's name.
Output :
On the first line, print the total number of names appearing in Chotu's final list. Then print the list such that every customer's name is printed on a new line.

Sample Input(Plaintext Link)
 11
babu
anand
rani
aarti
nandu
rani
rani
ap
anand
babu
nandu


Sample output(Plaintext Link)
 6
aarti
anand
ap
babu
nandu
rani
 * 
 * 
 */



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

class TreeSetPractice {
    public static void main(String args[] ) throws Exception {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        TreeSet<String> ts = new TreeSet<String>();
        
        for (int i = 0; i < N; i++) {
        	String str = br.readLine();
        	ts.add(str);
        }
        
        System.out.println(ts.size());
        for(String str1 : ts){
        	System.out.println(str1);
        }
        
    }
}
