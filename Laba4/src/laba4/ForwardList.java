/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laba4;

/**
 *
 * @author andre
 * @param <E>
 */
public class ForwardList<E> {
    private ListElement head;
    private ListElement tail;
    
    //Add back
    void addElement(E value){
        ListElement num = new ListElement();
        num.value = value;
        if (tail == null){
            head = num;
            tail = num;
        }
        else {
            tail.next = num;
            tail = num;
        }
    }
    
    void deleteElement(E value){
        if (head == null) return; //list is empty
        if (head == tail){ //element is lonely
            head = null;
            tail = null;
            return;
        }
        if(head.value == value){ // element is first
            head = head.next;
        }
        
        ListElement tmp = new ListElement();
        while(tmp.next != null){
            if (tmp.next.value == value){
                if (tail == tmp.next){
                    tail = tmp;
                }
                tmp.next = tmp.next.next;
                return;
            }
            tmp = tmp.next;
        }
    }
    
    void printList(){
        ListElement temp = head;
        while(temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
   }
}
