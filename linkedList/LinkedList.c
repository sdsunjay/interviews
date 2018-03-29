#include <stdio.h>
#include <stdlib.h>

typedef struct Element{
    int data;
    struct Element *next;
}Element;

/**
 * Delete each item in the list one by one
 */
void deleteList( Element **head){
    Element *deleteMe = *head;
    while(deleteMe){
        Element *next = deleteMe->next;
        free(deleteMe);
        deleteMe = next;
    }
    *head = NULL;
}
/**
 * Delete the element specified
 *  @param head - the head of the list
 *  @param deleteMe - the item to delete
 *  @return whether we successfully delete the element
 */
int deleteElement(Element **head, Element *deleteMe){
    Element *elem;
    if (!head || !*head || !deleteMe)
        /* Check for null pointers */
        return 1;
    elem = *head;
    if (deleteMe == *head){ /* Special case for head */
        *head = elem->next;
        free(deleteMe);
        return 0;
    }
    while(elem){
        if (elem->next == deleteMe){
            /* elem is the element preceding deleteMe */
            elem->next = deleteMe->next;
            free(deleteMe);
            return 0;
        }
        elem = elem->next;
    }
    /* deleteMe is not found */
    return 1;
}

int insertInFront(Element **head, int data){
    Element *newElem = malloc(sizeof(Element));

    if(!newElem)
        return 1;
    newElem->data = data;
    newElem->next = *head;
    *head = newElem;
    return 0;
}
int main(void){
    return 0;
}
