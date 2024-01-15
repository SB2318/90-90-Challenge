/**
  Problem Date: 13/01/24
  Problem Name: Insertion Sort for Singly Linked List
  Problem Link: https://www.geeksforgeeks.org/problems/insertion-sort-for-singly-linked-list/1
  Problem Category: LinkedList, Sorting Algo

*/

/*** I know, the files and folders are not structured properly, especially in the GFG folder. I was not very well due to a serious headache since yesterday.
Will try to arrange those sequentially. */

class Solution
{
    public static Node insertionSort(Node head)
    {

        //One of the best solution from my POV.
        Node dummy = head;
        
        for(Node i = head; i != null; i = i.next){
            for(Node j = i.next; j != null; j = j.next){
                if(i.data > j.data){
                    int temp = i.data;
                    i.data = j.data;
                    j.data = temp;
                }
            }
        }
        return dummy;
    }
}
