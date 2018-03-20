#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <sys/types.h>
#include <sys/socket.h>
#include <pthread.h>
#include <netdb.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdbool.h>


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

bool deleteElement(IntElement **head, IntElement *deleteMe){
    IntElement *elem;
    if (!head || !*head || !deleteMe) /* Check for null pointers */
        return false;
    elem = *head;
    if (deleteMe == *head){ /* Special case for head */
        *head = elem->next;
        free(deleteMe);
        return true;
    }
    while(elem){
        if (elem->next == deleteMe){
            /* elem is the element preceding deleteMe */
            elem->next = deleteMe->next;
            free(deleteMe);
            return true;
        }
        elem = elem->next;
    }
    /* deleteMe is not found */
    return false;
}

bool insertInFront(IntElement **head, int data){
    IntElement *newElem = malloc(sizeof(IntElement));
    
    if(!newElem)
        return false;
    newElem->data = data;
    newElem->next = *head;
    *head = newElem;
    return true;
}
int main(void){
    return 0;
}
