package practice.arrays.heap;

import java.util.*;

/**
 * <b>Description</b> : Given an List of list of(item, relevance, price) in an e-commerce site.
 *  Task is to return the paginated results of the given list of items.
 *  Assume the fetchItemsToDisplay() method with its input params, return a list of items
 *  that will be part of a particular page.
 *
 * @author Vinod Akkepalli
 */
public class WebsitePagination {


    public static void main(String[] args) {
        List<List<String>> items= List.of(
                List.of("Item2", "3", "4"),
                List.of("Item1", "10", "15"),
                List.of("Item3", "17", "8"));
        List<String> strings = fetchItemsToDisplay(items, 2, 1, 2, 1);
        System.out.println(strings);
    }


    public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter,
                                                   int sortOrder, int itemsPerPage, int pageNumber) {
        PriorityQueue<List<String>> heap;

        int heapSize = itemsPerPage * (pageNumber+1);

        //0 ascending
        //1 descending
        if(sortParameter == 0) {
            if(sortOrder == 0) {
                heap = new PriorityQueue<>((item1, item2) -> item2.get(sortParameter).compareTo(item1.get(sortParameter)));
            } else {
                heap = new PriorityQueue<>(Comparator.comparing(item -> item.get(sortParameter)));
            }
        } else {
            if(sortOrder == 0) {
                heap = new PriorityQueue<>((item1, item2) -> Integer.valueOf(item2.get(sortParameter)).compareTo(Integer.valueOf(item1.get(sortParameter))));
            } else {
                heap = new PriorityQueue<>(Comparator.comparing(item -> Integer.valueOf(item.get(sortParameter))));
            }
        }

        for (List<String> item : items) {
            heap.add(item);
            if (heap.size() > heapSize) {
                heap.remove();
            }
        }

        int collect = items.size() - (itemsPerPage * pageNumber);

        List<String> returnList = new ArrayList<>();
        for (int i = 0; i < itemsPerPage && i < collect; i++) {
            returnList.add(heap.remove().get(0));
        }
        Collections.reverse(returnList);

        return returnList;
    }
}
