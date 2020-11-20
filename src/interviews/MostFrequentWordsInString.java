package interviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author VinodAkkepalli
 *
 *	Problem Statement:
 *	Given a string, print the words from most frequent words to least frequent
 *
 *	Solution approach:
 *	Create a HashMap which stores (words, count)
 *	store HashMap entries in a List
 *	Define a comparator that compares values of list objects
 *	sort the List on using the comparator
 *
 *	Note: Have a look at http://stackoverflow.com/questions/109383/how-to-sort-a-mapkey-value-on-the-values-in-java
 *		to understand the generic sortByValue method & approach. 
 */

class StringCount{
	String str;
	Integer count;
	
	public StringCount(String str, Integer count) {
		this.str = str;
		this.count = count;
	}
	
	public Integer getCount() {
		return count;
	}
	
	public String getStr() {
		return str;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((str == null) ? 0 : str.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StringCount other = (StringCount) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (str == null) {
			if (other.str != null)
				return false;
		} else if (!str.equals(other.str))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return this.getStr() + "-->" + this.getCount();
	}
	
}

public class MostFrequentWordsInString {
	
	//A generic mathod that can be used to sort maps on values instead of keys
	//Descending order
	public static <K, V extends Comparable<? super V>> Map<K, V> 
	sortByValue( Map<K, V> map )
	{
		List<Map.Entry<K, V>> list = new ArrayList<Map.Entry<K, V>>( map.entrySet() );
		Collections.sort( list, new Comparator<Map.Entry<K, V>>()
				{
					public int compare( Map.Entry<K, V> o1, Map.Entry<K, V> o2 )
					{
						return (o2.getValue()).compareTo( o1.getValue() );
					}
				} );

		Map<K, V> result = new LinkedHashMap<K, V>();
		for (Map.Entry<K, V> entry : list)
		{
			result.put( entry.getKey(), entry.getValue() );
		}
		return result;
	}
	
	//Comparator to compare list items on values instead of keys
	static final Comparator<StringCount> SORT_ON_COUNT = 
		new Comparator<StringCount>(){
			public int compare(StringCount w1, StringCount w2){
				
				int countCmp = w2.getCount().compareTo(w1.getCount());
				if(countCmp !=0)
					return countCmp;
				
				return w1.getStr().compareTo(w2.getStr());
			}
		};	
	
	public static void main(String[] args) {
		
		String input = "The class String includes methods for examining individual characters of the sequence, for comparing strings, for "
				+"searching strings, for extracting substrings, and for creating a copy of a string with all characters translated to "
				+"uppercase or to lowercase. Case mapping is based on the Unicode Standard version specified by the Character class."
				+"The Java language provides special support for the string concatenation operator, and for conversion of other objects "
				+"to strings. String concatenation is implemented through the StringBuilder(or StringBuffer) class and its append method. "
				+"String conversions are implemented through the method toString, defined by Object and inherited by all classes in Java. "
				+"For additional information on string concatenation and conversion, see Gosling, Joy, and Steele, The "
				+"Java Language Specification.";

		Map<String, Integer> hashMap =  new HashMap<String, Integer>();
		
		String[] words =  input.split("[ .,]+");
		
		for(String str: words){
		
			if(hashMap.get(str) == null){
				hashMap.put(str, 1);
			}else{
				hashMap.put(str, hashMap.get(str)+1);
			}
		}
		
		//storing the HashMap entries into a list so that we sort the list on values
		List<StringCount> wordsList = new ArrayList<StringCount>();
		for(Map.Entry<String, Integer> e : hashMap.entrySet()){
			wordsList.add(new StringCount(e.getKey(), e.getValue()));
		}

		//Defined a comparator that will compare the values list items
		Collections.sort(wordsList, SORT_ON_COUNT);
		
		System.out.println("Words in frequency order are: ");
		System.out.println(wordsList.toString());
		
		/*//First 20 most frequent words are
		System.out.println("The first 20 most frequent words are:");
		for(int i = 0; i<20; i++){
			System.out.println(wordsList.get(i));
		}*/
		
		/**
		 * Using the generic method which sorts any map on values instead of keys
		 */
		
		Map<String, Integer> sortedMap =  sortByValue(hashMap);
		System.out.println(sortedMap.toString());
		
	}
}