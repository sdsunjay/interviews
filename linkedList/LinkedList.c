#include <stdio.h>
#include <stdlib.h>

typedef struct IntElement{
    int data;
    struct IntElement *next;
}IntElement;

void deleteList( IntElement **head){
    IntElement *deleteMe = *head;
    while(deleteMe){
        IntElement *next = deleteMe->next;
        free(deleteMe);
        deleteMe = next;
    }
    *head = NULL;
}

int deleteElement(IntElement **head, IntElement *deleteMe){
    IntElement *elem;
    if (!head || !*head || !deleteMe) /* Check for null pointers */
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

int insertInFront(IntElement **head, int data){
    IntElement *newElem = malloc(sizeof(IntElement));
    
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
