#include <stdio.h>
#include <stdlib.h>

typedef struct Element{
    int *data;
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
    else if(elem->data == head->data){
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

/**
 * Add a new element to the top from the stack.
 * @param **stack - a pointer to the head of the stack
 * @param **data - the data to be added to the stack
 * @return - whether or not the operation was successful
 */
int push(Element **stack, int *data){
    Element *elem = malloc(sizeof(Element));
    if(!elem)
        return 1;
    elem->data = data;
    elem->next = *stack;
    *stack = elem;
    return 0;
}

/**
 * Removes the top element from the stack.
 * @param **stack - a pointer to the head of the stack
 * @param **data - the data that has been removed from the stack
 * @return - whether or not the operation was successful
 */
int pop(Element **stack, int **data){
    Element *elem;
    elem = *stack;
    if( !(elem) )
        return 1;
    *data = elem->data;
    *stack = elem->next;
    free(elem);
    return 0;
}

/**
 * Initialize the Stack.
 */
int createStack(Element **stack){
    *stack = NULL;
    return 0;
}

/**
 * Iterate through the stack, deleting each Element.
 */
int deleteStack(Element **stack){
    Element *next;
    while(*stack){
        next = (*stack)->next;
        free(*stack);
        *stack = next;
    }
    return 0;
}

int main(void){
    int i;
    Element **top = (Element**) malloc(sizeof(Element*));
    createStack(top);
    int *data = (int*) malloc(sizeof(int));
    for(i=0; i<5; i++){
        *data = i+1;
        if(push(top, data)==1){
            printf("Error!");
        }
        else {
            printf("Value added: %d\n", *data);
        }
    }
    Element *e = (Element**) malloc(sizeof(Element*));
    if(delete(Element *elem) == 0){
        printf("Success");
    }
    return 0;
}
