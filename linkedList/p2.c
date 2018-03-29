#include <stdio.h>
#include <stdlib.h>

typedef struct Element{
    void *data;
    struct Element *next;
}Element;

/**
 * head points to the first element in the linked list
 */
Element *head;
/**
 * tail points to the last element in the linked list
 */
Element *tail;

int delete(Element *elem);
int insertAfter(Element *elem, int data);

/**
 * Delete an element in the list
 * @param elem - the element you want to delete
 * @return - 0 if you were successful, otherwise 1
 */
int delete(Element *elem){
/*
 * Use cases:
 * Check when the LinkedList is of length 0, 1, or 2
 * Assuming every item in the list is unique
 */
    if(elem == NULL){
        return 1;
    }
    // length of 0
    if(head == NULL){
        return 1;
    }
    // tail is messed up
    if(tail == NULL){
        return 1;
    }
    // length of 1
    if(tail == head && elem == head ){
        head = NULL;
        tail = NULL;
        free(elem);
        return 0;
    }
    /*
     * Delete first item in list
     */
    else if(elem == head){
        head = elem->next;
        free(elem);
        return 0;
    }
    /*
     * Length of linked list is more than 1
     */
    Element *trav = head;
    while(trav->next != NULL){
        /* delete last item in the list */
        if(trav->next == tail && elem == tail){
            /* We don't expect this to be true, but just to be safe */
            if(trav->next->next){
                trav->next = trav->next->next;
            }
            else{
                tail = trav;
                trav->next = NULL;
            }
            free(elem);
            return 0;
        }
        if(trav->next == elem){
            if(trav->next->next){
                trav->next = trav->next->next;
            }
            free(elem);
            return 0;
        }
        trav = trav->next;
    }
    // we didn't find the element to delete
    return 1;
}
int insertAfter(Element *elem, int data){
    return 0;
}
int main(void){
    return 0;
}
